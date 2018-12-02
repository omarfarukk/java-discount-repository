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

#2. Maven Plugins Used for Code Analysis, Code Quality and Code Coverage
===============================================
* spotbugs-maven-plugin 3.1.8
* maven-pmd-plugin 3.11.0
* jacoco-maven-plugin
* Sonar scanner for Maven

#3. PreRequisites for the project to build and run
======================================================
* JDK 1.8 to be installed  in the system and JAVA_HOME to be set properly.
* Sonar Qube Server 7.4 to be installed in the system and make it up and running with default port 9000.
* Maven 3.5.0 to be Installed in the system and M2_HOME is set properly.
* Spring Tool SUite / Eclipse Latest version installed with "The ObjectAid UML Explorer for Eclipse" Plugin

#4. build / execute the project, Generate static Code Analysis and Code Coverage
=================================================================================
* Download /clone this project using git url https://github.com/omarfarukk/java-discount-repository.git 
  GIT CLI or GIT eclipse plugin could be used to clone the project.
* Set M2_HOME properly to point a valid Maven tool in the system.
* Open a command Prompt and go to the downloaded project root directory, For this project, it'll be bill-discount-app
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
    
#5. SONAR QUBE and Code Summary
===============================================
* build the project using below command from the project root directory

    mvn clean install
    
* Find the code quality, code analysis or code coverage inside locally installed SONAR QUBE running on port 9000 using below command.

    mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
    
    You might change the sonar URL dynamically in the above command. 
    By Default mvn sonar:sonar will pick up the local server runnning on port 9000.
    After Executing mvn sonar:sonar , reach the "http://localhost:9000" project dashboard area to see the project summary.

#6. UML Class Diagram for the Project
=====================================
* GO to the Project Root Location, in this case it is "bill-discount-app"
* Find UML Diagram in "model.ucls" file . You might view this file using "The ObjectAid UML Explorer for Eclipse Plugin".


