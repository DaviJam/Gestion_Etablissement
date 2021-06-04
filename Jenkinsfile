pipeline {
	agent any
	tools {
		maven "Maven-3.6.3"
		jdk "Java-11.0.9"
	}
	
	stages {
		stage ("Git checkout") {
			steps {
				echo "Checking out branch..."
				checkout([$class: 'GitSCM', branches: [[name: '*/job9']], extensions: [], userRemoteConfigs: [[url: 'C:\\Users\\daori\\Documents\\ECOLE\\Dada\\Job7\\Gestion_Etablissement\\.git']]])
			}
		}
		stage("Initialize") {
			steps {
				echo "Cleaning up..."
				bat "mvn clean"
			}
		}
		
		stage("Build") {
			steps {
				echo "Building..."
				bat "mvn install"
			}
		}
		stage("Test") {
			steps {
				echo "Testing and reporting..."
				bat "mvn test"
			}
			post {
				success {
					junit 'testReports/**/*.xml'
				}
			}
		}	
		stage("Deploy") {
			steps {
				echo "Deploying..."
				script {
					try {
						deploy adapters: [tomcat7(credentialsId: 'e8677a13-83bc-4756-8dc9-c76e332cb99b', path: '', url: 'http:\\localhost:8080\')], contextPath: '//etablissement', war: '**/*.war'
					} catch (err) {
						echo "Error deploying war file..."
					}
				}
			}
		}
	}
}
