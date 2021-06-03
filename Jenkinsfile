pipeline {
	agent any
	stages {
		stage("Build") {
			steps {
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