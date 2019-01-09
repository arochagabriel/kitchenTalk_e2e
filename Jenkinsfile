def seleniumHub = 'selenium-hub-${BUILD_NUMBER}'

pipeline {
    agent any
    stages {
        stage('Setting up Selenium Grid') {
            steps {
                sh '''if [[ -n $(docker ps -aqf "name= ${seleniumHub}") ]]; then docker stop ${seleniumHub} && docker rm ${seleniumHub}; fi
    if [[ -n $(docker ps -aqf "name=chrome") ]]; then docker stop chrome && docker rm chrome; fi
    if [[ -n $(docker network inspect grid) ]]; then docker network rm grid; fi'''
                sh '''docker network create grid
    docker run -d -p 4444:4444 --net grid --name ${seleniumHub} selenium/hub
    docker run -d --net grid --name chrome -e HUB_HOST=${seleniumHub} -v /dev/shm:/dev/shm selenium/node-chrome'''
            }
        }
        stage('Test') {
            steps {
                sh './gradlew regressionSuite -Dcucumber.tags="@regression" -Dcucumber.glue="steps"'
            }
            post {
                always {
                    junit 'build/cucumber-report/*.xml'
                    cucumber fileIncludePattern: '**/*.json', jsonReportDirectory: 'build/cucumber-report', sortingMethod: 'ALPHABETICAL'
                }

            }
        }
    }
        post {
            always {
                node('master') {
                    sh 'docker rm -vf chrome'
                    sh 'docker rm -vf ${seleniumHub}'
                    sh 'docker network rm grid'
                }


            }

        }
    }

