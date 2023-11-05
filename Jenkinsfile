pipeline {
    agent any

    tools {
         jdk 'openjdk-17.0.8.1'
    }

    stages {
        stage('Clean Workspace') {
                steps {
                    deleteDir()
                }
        }
        stage('Checkout') {
            steps {
                checkout scm
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
    }
}