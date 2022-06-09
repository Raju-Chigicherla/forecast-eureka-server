pipeline {
    agent none
		triggers {
        pollSCM '* * * * *'
    }
    environment {
        app_name = "rajuchigicherla/forecast-server:latest"
    }
    stages {
    	stage('Maven Build') {
	        agent {
	            docker {
	                image 'maven:3.8.5-jdk-11'
	                reuseNode true
	            }
	        }
	        steps {
	        	sh 'mvn --version'
						sh 'mvn clean package'
        	}
        }
        stage('Docker Build') {
           agent any
           steps {
               sh 'docker build -t ${env.app_name} .'
           }
        }
        stage('Docker Push') {
           agent any
           steps {
           	withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
           		sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
           		sh 'docker push ${env.app_name}'
						}
           }
        }
    }
}
