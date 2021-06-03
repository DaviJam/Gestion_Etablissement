pipeline {
	agent any
	tools {
		maven "Maven-3.6.3"
		jdk "Java-11.0.9"
	}
	
	stages {
		stage ("Initialize") {
			steps {
				echo "PATH = "%PATH%
				echo "M2_HOME = "%M2_HOME%
				echo "JAVA_HOME = "%JAVA_HOME%
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