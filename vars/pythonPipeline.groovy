def call() {
    def utils = new org.example.PipelineUtils()

    pipeline {
        agent any

        stages {
            stage('Build') {
                steps {
                    script {
                        utils.buildPython(this)
                    }
                }
            }
            stage('Test') {
                steps {
                    script {
                        utils.testPython(this)
                    }
                }
            }
        }
    }
}
