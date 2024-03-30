pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building Spring Boot Application...'
                bat 'mvn clean package' // You can use 'bat' for Windows
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running Tests...'
                bat 'mvn test' // You can use 'bat' for Windows
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying Spring Boot Application...'
                sh 'java -jar target/sample-0.0.1-SNAPSHOT.jar' // Replace 'your-application.jar' with your actual jar file name
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}
