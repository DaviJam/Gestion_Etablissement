pipeline {
    agent any
     tools {
        maven 'Maven 3.6.3'
        jdk 'jdk11'
    }
    stages {
        stage('Build') {
            steps {
            echo "Buiding Gestion d'établissement"
                sh 'mvn -Pclient install'
            }
            post {
                success {
                    junit 'target/../testReports/**/*.xml'
                }
            }
        }
    }
}