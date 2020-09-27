# hobbyJavaproject
Java application is to find the available food trucks based on the current time and makes use external REST API to fetch the data.Application makes use of Gradle Build tool.

Installation & Execution Steps are as follows:- 
Prerequisite:- Java 8 & above.
•	Unzip the FoodTruckFinder zip file.
•	Open the FoodTruckFinder directory inside unzipped location in the terminal.
•	Execute the following command to create the executable jar file. 
./gradlew shadowJar
This will download gradle if necessary and also download all the dependencies.
•	Execute the following command to run the application.
java -jar build/libs/FoodTruckFinder-all.jar


