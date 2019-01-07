pipeline {
  agent {
    docker {
      image 'selenium/hub'
    }

  }
  stages {
    stage('Setting up Hub') {
      steps {
        sh '\'docker run -d -p 4444:4444 --name selenium-hub selenium/hub\''
      }
    }
  }
}