#!/usr/bin/env bash

echo http://localhost:8080/hello?target=world
echo http://localhost:8080/length?target=world
java -jar jetty-runner-9.3.9.v20160517.jar target/hello-web-1.0.war
