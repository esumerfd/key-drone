#!/bin/bash
# #################################################################################
# key-drone
#
# Keyboard control of an AR Drone.
#
# Build using: lein uberjar
# #################################################################################

if [[ -z $CLOJURE_HOME ]]; then
  echo "Must set CLOJURE_HOME environment variable"
  exit 1
fi

KEY_DRONE_HOME=$(cd `dirname $0`/..; echo $PWD)

java -cp $CLOJURE_HOME/target/clojure-1.6.0.jar -jar $KEY_DRONE_HOME/target/key-drone*standalone.jar 

