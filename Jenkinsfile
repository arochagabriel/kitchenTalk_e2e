pipeline {
  agent any
  stages {
    stage('Setting Up Selenium Grid') {
      steps {
        sh 'sh "docker network create ${network}"'
      }
    }
  }
}