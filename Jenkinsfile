pipeline {
  agent any
  stages {
    stage('Setting up Hub') {
      steps {
        sh './gradlew regressionSuite -Dcucumber.tags="@regression" -Dcucumber.glue="steps"'
      }
    }
  }
}