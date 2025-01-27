#! /usr/bin/env bash

if [ ! -f target/multilang-1.0-SNAPSHOT-shaded.jar ]; then
  echo "jar does not exist, building it."
  mvn package -DskipTests=true
fi;




node --jvm --vm.cp=target/multilang-1.0-SNAPSHOT.jar::target/modules/collections-24.1.2.jar:target/modules/micrometer-commons-1.14.3.jar:target/modules/micrometer-observation-1.14.3.jar:target/modules/nativeimage-24.1.2.jar:target/modules/polyglot-24.1.2.jar:target/modules/spring-aop-6.2.2.jar:target/modules/spring-beans-6.2.2.jar:target/modules/spring-context-6.2.2.jar:target/modules/spring-core-6.2.2.jar:target/modules/spring-expression-6.2.2.jar:target/modules/spring-jcl-6.2.2.jar:target/modules/word-24.1.2.jar app.js

