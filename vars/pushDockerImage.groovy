def call(String imageName) {
    echo 'Pushing Docker image to DockerHub'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USER --password-stdin"
        sh "docker push ${imageName}"
    }
}
