#!/usr/bin/env groovy
package src.com.example
class Docker implements Serializable{
  def script
  Docker(script){
    this.script=script
  }
  def buildDockerImage(String imageName){
    script.echo "building the docker image..."
     script.withCredentials(
    [script.usernamePassword(
      credentialsId : 'nexus_cred',
      passwordVariable : 'PASS',
      usernameVariable : 'USER'
    )]
  ){
    script.echo "$script.USER $script.PASS"
    script.sh 'ls'
    script.sh "docker build -t $imageName MCS1/. "
      script.echo "after build"
    script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin 67.205.176.30:8083"
     script.echo "after login"
    script.sh "docker push  $imageName"
     script.echo "after push"
  }
  }
 
}
