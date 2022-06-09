pipeline {
    agent any
		triggers {
        pollSCM '* * * * *'
    }
    environment {
        app_name = "rajuchigicherla/forecast-server:latest"
    }
    stages {
    	stage('Maven Build') {
    		def dockerHome = tool name: 'docker', type: 'dockerTool'
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
               sh "${dockerHome} build -t ${env.app_name} ."
           }
        }
        stage('Docker Push') {
           agent any
           steps {
           	withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
           		sh "${dockerHome} login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
           		sh "${dockerHome} push ${env.app_name}"
			}
           }
        }
    }
}
