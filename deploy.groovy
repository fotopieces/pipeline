
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
                sh "chmod 777"
            }
        }
    }
}