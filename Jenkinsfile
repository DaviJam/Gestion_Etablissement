pipeline {
	agent any
	stages {
		stage("Build") {
			steps {
				bat "mvn clean install"
			}
			post {
                success {
                    junit 'testReports/**/*.xml'
				}
			}
		}
	}
}