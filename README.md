# Selenium-101
Basic Selenium Project

## Requirements 
Download and install Java JDK 21. 
https://www.oracle.com/java/technologies/downloads/ 
Download an IntelliJ IDE Community edition.
https://www.jetbrains.com/idea/

## Add dependency from dependencies folder
Go to IntelliJ
File > Project Structure
Set SDK openjdk-21 and check dependencies.
Go to Modules
Selenium Server (Grid) jar file should be there.
This jar is located in dependencies folder if you need to add it manualy.

## How to add TestNg
Go to Tests/LoginPageTests
Click on @Test and select show Context Actions
Select the testng, and it will be installed.

## How to run
Go to Run Tab and click run LoginPageTests. 
If you want only one test go to a test e.g, TestSuccessfulLogin
Right click on the name and click run TestSuccessfulLogin.