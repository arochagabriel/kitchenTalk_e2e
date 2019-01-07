pipeline {
  agent any
  stages {
    stage('Setting up Selenium Grid') {
      parallel {
        stage('Setting up Selenium Grid') {
          steps {
            sh '''if [[ -n $(docker ps -aqf "name=selenium-hub") ]]; then docker stop selenium-hub && docker rm selenium-hub; fi
if [[ -n $(docker ps -aqf "name=chrome") ]]; then docker stop chrome && docker rm chrome; fi
if [[ -n $(docker network inspect grid) ]]; then docker network rm grid; fi '''
            sh '''docker network create grid
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub
docker run -d --net grid --name chrome -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome'''
          }
        }
        stage('test') {
          steps {
            echo 'heloo'
          }
        }
      }
    }
    stage('Test') {
      steps {
        sh './gradlew regressionSuite -Dcucumber.tags="@regression" -Dcucumber.glue="steps"'
      }
    }
    stage('Report') {
      steps {
        cucumber(fileIncludePattern: '**/build/cucumber-report/cucumber.json', sortingMethod: 'ALPHABETICAL')
      }
    }
  }
}