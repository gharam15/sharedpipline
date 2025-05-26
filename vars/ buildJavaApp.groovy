def call() {
    stage('Build Java App') {
        echo "Building Java App"
        sh 'mvn clean install'
    }
}
