pipeline {
    agent any

    environment {
        EC2_IP = credentials('ec2-ip')

    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/rana854/java-cicd-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Dev') {
            steps {
                sshagent(credentials: ['ec2-ssh-key']) {
                    sh """
                    scp -o StrictHostKeyChecking=no target/*.jar ec2-user@$EC2_IP:/home/ec2-user/java-cicd-app-dev.jar
                    ssh ec2-user@$EC2_IP 'nohup java -jar /home/ec2-user/java-cicd-app-dev.jar --server.port=8081 > dev.log 2>&1 &'
                    """
                }
            }
        }


        stage('Deploy to Test') {
            when {
                expression {
                    currentBuild.currentResult == 'SUCCESS'
                }
            }
            steps {
                sshagent(credentials: ['ec2-ssh-key']) {
                    sh """
                    scp -o StrictHostKeyChecking=no target/*.jar ec2-user@$EC2_IP:/home/ec2-user/java-cicd-app-test.jar
                    ssh ec2-user@$EC2_IP 'nohup java -jar /home/ec2-user/java-cicd-app-test.jar --server.port=8082 > test.log 2>&1 &'
                    """
                }
            }
        }

       stage('Deploy to STG') {
    when {
        expression {
            return env.CHANGE_TARGET == 'master'
        }
    }
    steps {
        sshagent(credentials: ['ec2-ssh-key']) {
            sh """
            scp -o StrictHostKeyChecking=no target/*.jar ec2-user@$EC2_IP:/home/ec2-user/java-cicd-app-stg.jar
            ssh ec2-user@$EC2_IP 'nohup java -jar /home/ec2-user/java-cicd-app-stg.jar --server.port=8083 > stg.log 2>&1 &'
            """
        }
    }
}


    post {
        always {
            echo "Pipeline finished with status: ${currentBuild.currentResult}"
        }
    }
}
}