def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Build') {
                steps {
                    script {
                        echo "Building Python project with virtual environment..."
                        sh '''
                            python3 -m venv venv
                            ./venv/bin/pip install --upgrade pip
                            if [ -f requirements.txt ]; then
                              ./venv/bin/pip install -r requirements.txt
                            else
                              echo "requirements.txt not found, skipping install."
                            fi
                        '''
                    }
                }
            }

            stage('Test') {
                steps {
                    script {
                        echo "Running tests..."
                        sh '''
                            if [ -f pytest.ini ] || [ -d tests ]; then
                                ./venv/bin/pytest
                            else
                                echo "No tests found, skipping test stage."
                            fi
                        '''
                    }
                }
            }
        }

        post {
            always {
                echo 'Cleaning up...'
                sh 'rm -rf venv'
            }
            success {
                echo 'Pipeline succeeded!'
            }
            failure {
                echo 'Pipeline failed!'
            }
        }
    }
}
