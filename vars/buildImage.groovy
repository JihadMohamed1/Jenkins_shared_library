#!/usr/bin/env groovy

def call(){
  echo 'build Image stage'
  withCredentials(
    [usernamePassword(
      credentialsId : 'nexus_cred',
      passwordVariable : 'PASS',
      usernameVariable : 'USER'
    )]
  ){
    echo "$USER $PASS"
    sh 'ls'
    sh 'docker build -t 67.205.176.30:8083/java-app:jma-2.0 MCS1/.'
      echo "after build"
    sh "echo $PASS | docker login -u $USER --password-stdin 67.205.176.30:8083"
     echo "after login"
    sh 'docker push  67.205.176.30:8083/java-app:jma-2.0'
     echo "after push"
  }
}
