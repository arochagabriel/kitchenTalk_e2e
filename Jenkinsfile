pipeline {
  agent any
  stages {
    stage('Setting up Selenium Grid') {
      steps {
        sh '''docker rm $(docker ps -a -q)
docker network create grid
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub'''
      }
    }
    stage('Test') {
      steps {
        sh './gradlew regressionSuite -Dcucumber.tags="@regression" -Dcucumber.glue="steps"'
      }
    }
  }
}