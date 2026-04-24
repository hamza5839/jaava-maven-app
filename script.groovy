def buildJar() {
    echo 'Building the jar file...'
                sh 'mvn package' // Add your build commands here
}
def buildImage() {
    echo 'Building the Docker image...'
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'   
                }
                sh 'docker build -t devhamzaops/my-app:latest .' // Add your build commands here
                sh 'docker push devhamzaops/my-app:latest' // Add your push commands,
}

def deployApp() {
    echo 'Deploying...'
                // Add your deploy commands here
}
return this
