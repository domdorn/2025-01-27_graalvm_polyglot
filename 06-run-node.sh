#! /usr/bin/env bash

if [ ! -f target/multilang-1.0-SNAPSHOT-shaded.jar ]; then
  echo "jar does not exist, building it."
  mvn package -DskipTests=true
fi;


#node --vm.cp=target/multilang-1.0-SNAPSHOT-shaded.jar app.js
node --vm.cp=target/multilang-1.0-SNAPSHOT:target/modules --jvm --polyglot app.js

