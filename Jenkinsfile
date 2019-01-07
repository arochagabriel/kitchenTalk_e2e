pipeline {
  agent {
    dockerfile {
      filename 'docker-compose.yml'
    }

  }
  stages {
    stage('Setting Up Selenium Grid') {
      steps {
        sh 'sh "docker network create ${network}"'
      }
    }
  }
}