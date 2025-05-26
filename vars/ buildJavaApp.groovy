def call(String imageName) {
    echo 'Building Java app and Docker image...'
    sh 'mvn clean package'
    sh "docker build -t ${imageName} ."
}
