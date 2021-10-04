pipeline {
  agent any
  stages {
    stage('dev-git-clone') {
      steps {
        git 'https://github.com/TestLeafInc/WebApp.git'
      }
    }

    stage('dev-build') {
      steps {
        bat 'start /min StopApp.bat'
        bat 'mvn clean install'
        bat 'set JENKINS_NODE_COOKIE=dontkillMe && start /min StartApp.bat'
      }
    }

    stage('tests') {
      parallel {
        stage('qa-git-clone-test') {
          agent any
          steps {
            git 'https://github.com/TestLeafInc/WebAppApiAutomation'
            script {
              try {
                sleep(time:10, unit:'SECONDS')
                bat 'mvn test'
              } catch (Exception e){
                echo 'API Failed'
                currentBuild.result='UNSTABLE'
              }
            }

          }
        }

        stage('qa-api-git-clone-test') {
          agent any
          steps {
            git 'https://github.com/TestLeafInc/WebAppUiAutomation'
            sleep(time: 10, unit: 'SECONDS')
            retry(count: 2) {
              bat 'mvn test'
            }

          }
        }

      }
    }

  }
  tools {
    maven 'MAVEN_HOME'
  }
  post {
    always {
      echo 'Always'
    }

    success {
      echo 'Success'
    }

    failure {
      echo 'failure'
    }

    unstable {
      echo 'unstable'
    }

    changed {
      echo 'chnaged'
    }

    regression {
      echo 'regression'
    }

    unsuccessful {
      echo 'unsuccessful'
    }

  }
  triggers {
    cron('50 14 * * 0')
  }
}