node('windows && Java-11.0.9 && Maven-3.6.3') {
	tools {
		maven "Maven-3.6.3"
		jdk "Java-11.0.9"
	}
	
	stages {
		stage ("Git checkout") {
			echo "Checking out branch..."
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/job9']], extensions: [], userRemoteConfigs: [[url: 'C:\\Users\\daori\\Documents\\ECOLE\\Dada\\Job7\\Gestion_Etablissement\\.git']]])
			}
		}
		stage("Initialize") {
			echo "Cleaning up..."
			steps {
				bat "mvn clean"
			}
		}
		
		stage("Build") {
			echo "Building..."
			steps {
				bat "mvn install"
			}
		}
		stage("Test") {
			echo "Testing and reporting..."
			steps {
				bat "mvn test"
			}
			post {
				success {
					junit 'testReports/**/*.xml'
				}
			}
		}	
		stage("Deploy") {
			echo "Deploying..."
			steps {
				//bat "mvn clean test"
			}
		}
	}
}
