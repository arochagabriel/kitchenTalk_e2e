pipeline {
  agent any
  stages {
    stage('Setting up Hub') {
      steps {
        sh '''docker network create grid
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-dubnium'''
      }
    }
    stage('Test') {
      steps {
        sh './gradlew regressionSuite -Dcucumber.tags="@regression" -Dcucumber.glue="steps"'
      }
    }
  }
}