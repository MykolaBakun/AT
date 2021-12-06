mvn clean install exec:java -Dexec.mainClass="practice.test.MainExecutorExample" -Dexec.args="Mykola Bak" -DskipTests=true

#TEST execution
mvn clean test
allure serve -h localhost
