package org.example

class PipelineUtils implements Serializable {

    def buildJava(context) {
        context.echo "Building Java project..."
        context.sh 'mvn clean install'
    }

    def testJava(context) {
        context.echo "Testing Java project..."
        context.sh 'mvn test'
    }

    def buildPython(context) {
        context.echo "Building Python project with virtual environment..."
        context.sh '''
            python3 -m venv venv
            ./venv/bin/pip install --upgrade pip
            ./venv/bin/pip install -r requirements.txt
        '''
    }

    def testPython(context) {
        context.echo "Testing Python project inside virtual environment..."
        context.sh '''
            if [ -f pytest.ini ] || [ -d tests ]; then
                ./venv/bin/pytest
            else
                echo "No tests found, skipping test stage."
            fi
        '''
    }
}
