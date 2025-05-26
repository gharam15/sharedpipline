def call(String imageName) {
    stage("Build Docker Image ${imageName}") {
        echo "Building Docker image ${imageName}"
        sh "docker build -t ${imageName} ."
    }
}
