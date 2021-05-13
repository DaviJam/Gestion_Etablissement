pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
                withMaven(globalMavenSettingsFilePath: ' ${user.home}/.m2/settings.xml', mavenSettingsFilePath: ' ${user.home}/.m2/settings.xml', options: [junitPublisher(disabled: true, healthScaleFactor: 1.0), pipelineGraphPublisher(includeScopeTest: true, lifecycleThreshold: 'install')]) {
                   mvn clean install -Pclient
                }
            }
        }
    }
}