def seleniumHub = 'selenium-hub-${BUILD_NUMBER}'
def chromeNode = 'chrome-node-${BUILD_NUMBER}'
def network = 'grid-${BUILD_NUMBER}'

pipeline {
    agent any
    stages {
        stage('Setting up Selenium Grid') {
            steps {
                sh """
                    if [[ -n \$(docker ps -aqf "name=${seleniumHub}") ]]; 
                     then docker stop ${seleniumHub} && docker rm ${seleniumHub}; fi
                    if [[ -n \$(docker ps -aqf "name=${chromeNode}") ]]; 
                    then docker stop ${chromeNode} && docker rm ${chromeNode}; fi
                    if [[ -n \$(docker network inspect ${network}) ]]; 
                    then docker network rm ${network}; fi"""

                sh """docker network create ${network}
                    docker run -d -p 4444:4444 --net ${network} --name ${seleniumHub} selenium/hub
                    docker run -d --net ${network} --name ${chromeNode} -e HUB_HOST=${
                    seleniumHub
                } -v /dev/shm:/dev/shm selenium/node-chrome"""
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
                   // archiveArtifacts artifacts: 'build/courgette-report/*', caseSensitive: false, defaultExcludes: false
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, escapeUnderscores: false, includes: 'build/courgette-report/*', keepAll: true, reportDir: 'build/courgette-report', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])

                }

            }
        }
    }
    post {
        always {
            node('master') {
                sh "docker rm -vf ${chromeNode}"
                sh "docker rm -vf ${seleniumHub}"
                sh "docker network rm ${network}"
            }


        }

    }
}

