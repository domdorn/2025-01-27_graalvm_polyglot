package com.dominikdorn.javavienna.multilang.samples.s01_randomnumber;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.io.ByteSequence;

public class S004_WasmRandomNumberGen implements RandomNumberGen {

  @Override
  public double getRandomNumber() {

    try (Context context =
        Context.newBuilder("wasm")
            .option("wasm.Builtins", "wasi_snapshot_preview1")
            .build()
        ) {

      File file = new File("src/main/resources/wasm/random/random.wasm");
      if (!file.exists()) {
        throw new RuntimeException("Could not find wasm file");
      }
      Source source = Source.newBuilder("wasm", file)
          .name("example").build();

      context.eval(source); // wasm einlesen

      // initialisieren
      context
          .getBindings("wasm")
          .getMember("example")
          .getMember("_initialize")
          .executeVoid();


      // ausfuehren
      Value result = context .getBindings("wasm")
          .getMember("example")
          .getMember("get_random_number")
          .execute();
      return result.asDouble();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
