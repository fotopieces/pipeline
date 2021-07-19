
pipeline {

    /* Specify where entire pipeline will execute */
    // agent any
    agent {
      label 'my-k8s'
    }
    stages {
        stage('Checkout SCM') {

            steps {
                echo "tttttttttttttttt"
            }
        }
    }
}
