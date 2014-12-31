(ns key-drone.core
  (:use clj-drone.core)
  (:require  [clojure.java.io :as io])
  (:gen-class :main true))

(defn key-drone
  "Key drone startup"
  []
  (println "Starting Key Drone")

  (drone-initialize)

  ;Some stuff that will move
  (drone :take-off)
  (println "Waiting for drone to takeoff")
  (Thread/sleep 5000)
  (drone :land)


  (int 0))

(defn -main
  "Command  line entry point for key-drone"
  [& args]
  (key-drone))
