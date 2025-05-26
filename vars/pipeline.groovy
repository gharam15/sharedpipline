def call() {
    pipeline {
        agent {
            label "java"
        }
        environment {
            IMAGE_NAME = 'gharam/java-iti'
        }
        stages {
            stage('Build Java & Docker') {
                steps {
                    echo 'Building Java app and Docker image'
                    buildJavaApp(env.IMAGE_NAME)
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
