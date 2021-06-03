pipeline {
	agent any
	stages {
		stage("Build") {
			steps {
				echo 
				bat "mvn clean install test"
			}
			post {
                success {
                    junit 'testReports/**/*.xml'
				}
			}
		}
	}
}