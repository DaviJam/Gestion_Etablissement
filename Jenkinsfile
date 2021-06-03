pipeline {
	agent any
	tools {
		maven "Maven-3.6.3"
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