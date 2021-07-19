
pipeline {

    /* Specify where entire pipeline will execute */
    // agent any
    agent {
      label 'master'
    }
    stages {
         stage('Checkout Code Angular') {

            steps {
                dir ('work') {
                    git branch: 'master',
                    credentialsId: 'a2432c58-e773-4594-a45f-e6ddd1d60e41',
                    url: 'https://github.com/fotopieces/myweb.git'
                }
            }
        }
         stage('Build Angular') {

            steps {
                sh """
                    cd work &&
                    cd myweb &&
                    npm install &&
                    ng build --prod &&
                 """
            }
        }
        
        
        stage('Clear') {
            steps {
                sh """
                    cd .. &&
                    cd .. &&
                    rm -rf work
                """
            }
        }
    }
}