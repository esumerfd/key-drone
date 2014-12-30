(ns key-drone.core
  (:require  [clojure.java.io :as io])
  (:gen-class :main true))

(defn key-drone
  "Key drone startup"
  []
  (println "Starting Key Drone")
  (int 0))

(defn -main
  "Command  line entry point for key-drone"
  [& args]
  (key-drone))
