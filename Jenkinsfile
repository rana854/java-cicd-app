pipeline {
    agent any

    stages {
        /*stage('Checkout') {
            steps {
                checkout scm
            }
        }*/

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
/*
        stage('Deploy to DEV') {
            steps {
                sh 'scp -i /path/to/key.pem target/demo-1.0.0.jar ec2-user@your-dev-ec2:/home/ec2-user/'
                sh 'ssh -i /path/to/key.pem ec2-user@your-dev-ec2 "java -jar /home/ec2-user/demo-1.0.0.jar &"'
            }
        }*/
    }
}
