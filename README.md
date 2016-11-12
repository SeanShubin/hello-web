### Sample Java Web Archive Project
- Demonstrates how to get dispatch under unit test coverage
- steps to run
    - mvn package
    - java -jar jetty-runner.jar target/hello-web-1.0.war
    - open a web browser
    - navigate to
        - http://localhost:8080/hello?target=world
        - http://localhost:8080/length?target=world
