def call() {
    stage('Build Python App') {
        echo "Building Python App"
        sh 'python3 setup.py install'  // أو أي أمر بناء بايثون عندك
    }
}
