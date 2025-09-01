pipeline {
    tools {
        maven 'Maven'
    }
    agent any
    stages {
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv() {
                    sh "mvn clean verify sonar:sonar -Dsonar.projectKey=calculator -Dsonar.projectName='Calculator'"
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'nexus-credentials', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASSWORD')]) {
                    sh 'mvn clean deploy -Dnexus.user=$NEXUS_USER -Dnexus.password=$NEXUS_PASSWORD'
                }
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
