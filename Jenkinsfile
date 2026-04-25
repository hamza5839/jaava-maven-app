pipeline {
    agent any
    tools {
        maven 'maven-3.9' // Define any tools you need here, e.g., JDK, Maven, etc.
    }
    triggers {
        // Tells Jenkins to listen for the GitHub Webhook
        githubPush() 
    }
    stages {
        stage('Build jar') {
            steps {
                echo 'Building the jar file...'
                sh 'mvn package' // Add your build commands here
            }
        }

        stage('Build image') {
            steps {
                echo 'Building the Docker image...'
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                }
                sh 'docker build -t devhamzaops/my-app:last .' // Add your build commands here
                sh 'docker push devhamzaops/my-app:last' // Add your push commands here
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy commands here
            }
        }
    }
    post {
        success {
            echo 'This will run only if the pipeline succeeds.'
        }
        failure {
            echo 'This will run only if the pipeline fails.'
        }
    }
}
