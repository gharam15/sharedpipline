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
        context.echo "Building Python project..."
        context.sh 'pip install -r requirements.txt'
    }

    def testPython(context) {
        context.echo "Testing Python project..."
        context.sh 'pytest'
    }
}
