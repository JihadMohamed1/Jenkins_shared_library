#!/usr/bin/env groovy

def call(){
   echo 'build jar stage'
  sh 'ls'
  sh ' cd MCS1'
  sh 'ls'
  sh 'mvn package -f MCS1/pom.xml'
}
