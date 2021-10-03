pipeline {
  agent any
  stages {
    stage('Dev Clone') {
      steps {
        git(url: 'https://github.com/Haja49/WebApp.git', branch: 'master')
      }
    }

    stage('Dev Build') {
      steps {
        bat 'start /min StopApp.bat'
        bat 'mvn clean install'
        bat 'set JENKINS_NODE_COOKIE=dontkillMe && start /min StartApp.bat'
      }
    }

    stage('UI Test') {
      parallel {
        stage('UI Test') {
          steps {
            git(url: 'https://github.com/Haja49/WebAppUI.git', branch: 'master')
            sleep 10
            bat 'mvn test'
          }
        }

        stage('API Test') {
          steps {
            git(url: 'https://github.com/Haja49/WebAPI.git', branch: 'master')
            sleep 10
            bat 'mvn test'
          }
        }

      }
    }

    stage('UAT Certification') {
      steps {
        input 'Do you want to Deploy in Prod?'
      }
    }

    stage('Prod Deploy') {
      steps {
        echo 'Deployed to Prod'
      }
    }

  }
}