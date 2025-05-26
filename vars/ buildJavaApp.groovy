def call() {
    stage('Build Java App') {
        sh 'mvn clean install'
    }
}
