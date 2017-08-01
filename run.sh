#!/usr/bin/env bash

wget -nc -O jetty-runner.jar http://central.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.3.v20170317/jetty-runner-9.4.3.v20170317.jar
chmod +x ./jetty-runner.jar

echo http://localhost:8080/hello?target=world
echo http://localhost:8080/add?left=2\&right=3
java -jar jetty-runner.jar target/hello-web-1.0.war
