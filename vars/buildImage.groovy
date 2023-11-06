#!/usr/bin/env groovy

import Jenkins_shared_library.src.com.example.Docker

def call(String imageName){
return new Docker(this).buildDockerImage(imageName)
}
