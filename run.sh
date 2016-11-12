#!/usr/bin/env bash

echo http://localhost:8080/hello?target=world
echo http://localhost:8080/length?target=world
java -jar jetty-runner.jar target/hello-web-1.0.war
