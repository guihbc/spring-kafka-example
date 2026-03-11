pipeline {
    agent { label 'built-in' }

    tools {
        jdk 'graalvm21'
    }

    stages {
        stage('Pipeline Info') {
            steps {
                sh 'echo "Build ID: ${BUILD_NUMBER}"'
                sh 'echo "Build URL: ${BUILD_URL}"'
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
                sh 'ls -la'
            }
        }

        stage('Build & Test Project') {
            steps {
                withMaven(maven: 'Default') {
                    sh 'mvn -version'
                    sh 'mvn clean verify'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube-local') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}