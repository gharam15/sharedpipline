def call() {
    def utils = new org.example.PipelineUtils()

    pipeline {
        agent any

        stages {
            stage('Build') {
                steps {
                    script {
                        utils.buildJava(this)
                    }
                }
            }
            stage('Test') {
                steps {
                    script {
                        utils.testJava(this)
                    }
                }
            }
        }
    }
}
