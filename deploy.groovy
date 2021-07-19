
pipeline {

    /* Specify where entire pipeline will execute */
    // agent any
    agent {
      label 'master'
    }
    stages {
        stage('Checkout SCM') {

            steps {
                echo "tttttttttttttttt"
            }
        }
    }
}
