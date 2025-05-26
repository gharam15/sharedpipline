def call(String imageName) {
    echo 'Building Python Docker image...'
    sh "docker build -t ${imageName} ."
}
