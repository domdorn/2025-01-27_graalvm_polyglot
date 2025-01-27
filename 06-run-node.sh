#! /usr/bin/env bash

if [ ! -f target/multilang-1.0-SNAPSHOT.jar ]; then
  echo "jar does not exist, building it."
  mvn package -DskipTests=true
fi;


node --vm.cp=target/multilang-1.0-SNAPSHOT.jar app.js

