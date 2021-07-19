#!/usr/bin/env groovy

pipeline {
    stages {
        stage("Checkout") {
            steps {
               echo "HELLO"
            }
        }
        stage("Do Something With Sources") {
            steps {
                echo("TEST");
            }
        }
    }
}