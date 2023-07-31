Api Automation Task:
This is a RestAssured and Cucumber based project. 
It uses maven for packaging and to manage dependencies.

Overview:
The purpose of the project is to test https://fakerestapi.azurewebsites.net APIs using
RestAssured and Cucumber frameworks.

Features:
TestRunner class configuration. TestRunner class executes the feature files and generates Extent Spark report.
It generates Extent Spark report with all the step details. Report will be generated in HTML. 
Feature file has examples of reading request details.
This also has an example to validate response body using json schema file.
Test execution can be triggered form command line.

Required Setup:
Jdk 11 should be installed and configured.
Maven should be installed and configured.
Download the source code from Git repository either as zip file OR using Git clone

Running Tests:
Open the project root directory in terminal. Run the below Maven command.
mvn clean test
Once the execution completes report will be generated in below folder.
Report: target/SparkReport
