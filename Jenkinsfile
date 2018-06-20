pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
		sh '''
		    echo "Multiline Shell steps works too"
		    ls -alh
		'''
            }
        }
    }
}
