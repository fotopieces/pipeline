docker container run -d -p 8082:8080 --name ci jenkins/jenkins:lts
docker container exec -it ci  cat /var/jenkins_home/secrets/initialAdminPassword