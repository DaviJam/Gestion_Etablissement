pipeline {
	agent any
	stages {
		stage("Build") {
			steps {
				bat "JAVA_HOME=C:\Program Files\Java\jdk-11.0.9 mvn clean install"
			}
			post {
                success {
                    junit 'testReports/**/*.xml'
				}
			}
		}
	}
}