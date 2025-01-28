const http = require("http");
const fs = require("fs");
const path = require("path");
const url = require("url");
require("colors");

const springCtxClass = Java.type("com.dominikdorn.javavienna.multilang.SpringEntryPoint")

const springCtx = springCtxClass.buildCtx();

const calculator = springCtx.getBean("calculator");

const server = http.createServer((req, res) => {
  const parsedUrl = url.parse(req.url, true);
  const pathname = parsedUrl.pathname;

  if (pathname === "/") {
    // Serve the HTML UI
    fs.readFile(path.join(__dirname, "index.html"), (err, data) => {
      if (err) {
        res.writeHead(500, { "Content-Type": "text/plain" });
        res.end("Error loading UI");
        return;
      }
      res.writeHead(200, { "Content-Type": "text/html" });
      res.end(data);
    });
  } else if (pathname.startsWith("/api/calculate")) {
    const { op, a, b } = parsedUrl.query;

    if (!op || isNaN(a) || isNaN(b)) {
      res.writeHead(400, { "Content-Type": "application/json" });
      res.end(JSON.stringify({ error: "Invalid parameters" }));
      return;
    }

    try {
      let result = 0.0;
      switch (op) {
        case "add":
          result = calculator.add(parseInt(a), parseInt(b));
          break;
        case "sub":
          result = calculator.subtract(parseInt(a), parseInt(b));
          break;
        case "mult":
          result = calculator.multiply(parseInt(a), parseInt(b));
          break;
        case "div":
          result = calculator.divide(parseInt(a), parseInt(b));
          break;
      }

      res.writeHead(200, { "Content-Type": "application/json" });
      res.end(JSON.stringify({ result }));
    } catch (error) {
      res.writeHead(400, { "Content-Type": "application/json" });
      res.end(JSON.stringify({ error: error.message }));
    }
  } else {
    res.writeHead(404, { "Content-Type": "text/plain" });
    res.end("Not Found");
  }
});

server.listen(8000, () => {
  console.log("Node.js server running at http://127.0.0.1:8000/".red);
});