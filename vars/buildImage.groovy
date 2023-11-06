#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName){
  echo "hello"
return new Docker(this).buildDockerImage(imageName)
}
