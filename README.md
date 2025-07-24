# Java Application & CI/CD Pipeline Project

##  About the Project

This project demonstrates a complete CI/CD pipeline setup for a basic Java application using Jenkins and deploying to AWS EC2 instances. The application is a simple Java program that prints "Hello, World!", built using Maven.


## Project Structure

- src/main/java/: Contains the main Java source code.

- src/test/java/: Contains unit test code.

- pom.xml: Maven configuration file managing dependencies and build lifecycle.

- Jenkinsfile: Defines the CI/CD pipeline stages (build, test, deploy).

- README.md: Documentation file explaining the project and the CI/CD process.


 ##  prerequisites 
 
- Java Development Kit (JDK) 17 or higher  
- Maven
- Jenkins  
- AWS EC2
- Git


## Pipeline Steps

- Build: Compile and package the app using Maven.
- Test: Run unit tests.  
- Deploy to Dev: Automatically deploy after successful build/test.  
- Deploy to Test: Only if deployment to Dev succeeded.  
- Deploy to Staging: Happens only when a merge request targets the `master` branch.


## How to Use

- Clone the repository:

```bash
https://github.com/rana854/java-cicd-app.git
'''

## Set Up the Jenkins Pipeline

- Open your Jenkins dashboard.

- Create a new Pipeline project.

- In the project configuration, select Pipeline script from SCM.

- Choose Git as the SCM.

- Enter the repository URL.

- Specify the branch you want to build from.

- Set the script path if the Jenkinsfile.

- Save and run the pipeline.






