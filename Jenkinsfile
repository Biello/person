pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh 'mvn -B -Dmaven.test.skip=true clean package'
            }
        }
    }
}
