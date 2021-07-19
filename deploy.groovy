
pipeline {

    /* Specify where entire pipeline will execute */
    // agent any
    agent {
      label 'master'
    }
    stages {
         stage('Checkout Code Angular') {

            steps {
                git branch: 'master',
                credentialsId: 'a2432c58-e773-4594-a45f-e6ddd1d60e41',
                url: 'https://github.com/fotopieces/myweb.git'
            }
        }
         stage('Build Angular') {

            steps {
                sh """
                    cd myweb &&
                    npm install &&
                    ng build --prod &&
                 """
            }
        }
        stage('Push to registry') {
            steps {
                docker.withRegistry( 'https://hub.docker.com/repository/docker/fotopiece/myweb', '9f98c373-03dd-4eb5-bf0d-411f57a59033' ) {
                    dockerImage.push()
                    if (pushLatest){
                        newImage.push("latest")
                    }
                } 
        }
        
        stage('Clear') {
            steps {
                sh """
                    cd .. &&
                    rm -rf myweb
                """
            }
        }
    }
}
