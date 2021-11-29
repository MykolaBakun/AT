mvn clean install exec:java -Dexec.mainClass="practice.serialization.MainExecutorExample" -Dexec.args="arg0 arg1" -DskipTests=true

#TEST execution
mvn clean test
allure serve -h localhost
