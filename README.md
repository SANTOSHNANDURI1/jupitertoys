# jupitertoys

Setup Selenium with Java, Eclipse and JUnit
Selenium is an open source project which provides a suite of tools for automating web browsers across a variety of platforms and languages. The current release is version 2 or WebDriver, which supersedes the original Selenium RC version.
The primary source of information about the Selenium project is the Selenium HQ website which can be found at the following URL:
http://seleniumhq.org
Setup
The easiest way to setup a Selenium Java project is to use Maven (http://maven.apache.org/) which is a project and dependency management tool.
The steps to create a project are:
Create a directory for your project
Copy the xml found at the following url: http://docs.seleniumhq.org/docs/03_webdriver.jsp#setting-up-a-selenium-webdriver-project
	https://github.com/SeleniumHQ/seleniumhq.github.io/tree/trunk/examples/java
Paste the xml into a file and save it as pom.xml in your project directory
Open your command line and cd to the project directory
Run the following command: mvn clean install
Executing the above command will download all of the Selenium dependencies and add them to your project.
Eclipse 
With your project setup, you can use Maven to generate an Eclipse project and import it into Eclipse by following the steps below:
Open your command line and cd to the project directory
The first time you use eclipse and maven together, you must add the maven repository path to eclipse using the command below (replacing <path-to-eclipse-workspace>):  mvn “–Declipse.workspace=<path-to-eclipse-workspace>”  eclipse:add-maven-repo
Run the following command: mvn eclipse:eclipse
Open the Eclipse IDE
Select the File>Import menu 
Select General >Existing Projects into Workspace, then follow the wizard to import from your project directory: 

Switch to the Java perspective by clicking the Window>Open Perspective menu 
Right click the project icon and select the New>Source Folder menu
Name the folder src

JUnit Test Setup
With your project imported into Eclipse, and assuming the use of JUnit to organise and run the tests, the following steps detail the integration of JUnit :
Right click the project icon and select the Build Path>Add Libraries menu, then select JUnit, then JUnit 4 within the wizard
Right click the src folder and select the New>Package menu
Name the package with a reverse domain name format e.g. au.net.planit.project.tests
Right click the package and select the New>JUnit Test Case menu 
Name the JUnit test appropriately and select the setup and teardown method stubs


Your project should now look similar to the following image:
