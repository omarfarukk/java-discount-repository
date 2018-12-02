Maven - Bill Discount Framework - Java
======================================

#1. Technologies / Frameworks /Tools used
==========================================
* Maven 3.5.0 for building the Project, generating the static code analysis, executing test cases, generating code coverage,    connecting to Sonar Qube for continuous code quality inspection.
* Log4j with SL4J -sl4j-log12-1.7.25 to achieve Logging.
* Junit 4.12 to write test cases for the code/component.
* Mockito Core 2.7.22 to achieve Mocking during test case execution.
* Sonar Qube Server 7.4 for continuous Code quality inspection
* Spring Tool Suite IDE 3.9.2.RELEASE for project development

#2. Maven Plugins Used for Static Code Analysis
===============================================
* spotbugs-maven-plugin 3.1.8
* maven-pmd-plugin 3.11.0
* jacoco-maven-plugin
* Open Source Sonar scanner for Maven

#3. PreRequisites for the project to build and run
======================================================
* JDK 1.8 to be installed  in the system
* Sonar Qube Server 7.4 to be installed in the system and make it up and running with default sonar port 9000.
* Maven 3.5.0 to be Installed in the system

#4. build / execute the project, Generate static Code Analysis and Code Coverage
=================================================================================
* Clone this project using git url https://github.com/omarfarukk/java-discount-repository.git 
  GIT CLI or GIT eclipse plugin could be used to clone the project.
* go to the project root directory, For this project, it'll be bill-discount-app
* build the project using below command

    mvn clean install
  
* run the test cases for the project using below command

    mvn clean test
  
* Generate the static code analysis for the project using below command. 
Reports could be found in {Project_Base_Directory}/target/site/project-reports.html directory.

    mvn clean install site

* Generate the code coverage analysis for the project using below command. 
Reports could be found in {Project_Base_Directory}/target/site/jacoco/index.html directory.

    mvn clean install site
    
#5. SONAR QUBE Integration
===============================================
* build the project using below command from the project root directory

    mvn clean install
    
* Find the code quality, code analysis or code coverage inside locally installed SONAR QUBE running on port 9000 using below command.

    mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
    
    You might change the sonar URL dynamically in the above command. 
    By Default mvn sonar:sonar will pick up the local server runnning on port 9000.
    After Executing mvn sonar:sonar , reach the "http://localhost:9000" project dashboard area to see the project summary.
