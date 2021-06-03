pipeline {
	agent any
	tools {
		maven "Maven3.1.1"
		jdk "java-1.8.0_291"
	}
	
	stages {
		stage ("Initialize") {
			steps {
				echo "PATH = %PATH%"
				echo "M2_HOME = %M2_HOME%"
				echo "JAVA_HOME = %JAVA_HOME%"
			}
		}
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