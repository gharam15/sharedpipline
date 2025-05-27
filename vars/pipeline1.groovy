def call() {
    pipeline {
        agent { 
        label 'java' 
       }

        environment {
            IMAGE_NAME = 'gharam/java2'
        }

       stages {
        stage('Build Java & Docker') {
            steps {
                echo 'Building Java app and Docker image...'
                buildJavaApp(env.IMAGE_NAME)
            }
        }

        }
    }
}