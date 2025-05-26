def call() {
    pipeline {
        agent any

        environment {
            IMAGE_NAME = 'gharam/python-task'
        }

        stages {
            stage('Build & Dockerize') {
                steps {
                    echo 'Building Docker image for Python app...'
                    sh 'docker build -t haneentharwat/jenkins .'
                }
            }

            stage('Push Docker Image') {
                steps {
                    echo 'Pushing Docker image to DockerHub'
                    pushDockerImage(env.IMAGE_NAME)
                }
            }
        }
    }
}
