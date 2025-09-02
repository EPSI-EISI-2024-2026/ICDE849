pipeline {
    tools {
        maven 'Maven'
    }
    agent any
    stages {
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('Local') {
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
                configFileProvider([configFile(fileId: 'maven-nexus-creds', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn deploy -DskipTests'
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
