(defproject key-drone "0.1.0-SNAPSHOT"
  :description "Keyboard Driven Drone"
  :url "https://github.com/esumerfd/key-drone"
  :license {:name "MIT License" :url "http://opensource.org/licenses/MIT"}
  :main key-drone.core
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [jline/jline "2.12"]
                 [clj-drone "0.1.8"]]

  ;; Profiles
  ;; Each active profile gets merged into the project map. The :dev
  ;; and :user profiles are active by default, but the latter should be
  ;; looked up in ~/.lein/profiles.clj rather than set in project.clj.
  ;; Use the with-profiles higher-order task to run a task with a
  ;; different set of active profiles.
  ;; See `lein help profiles` for a detailed explanation.
  :profiles  {
              ;; activated automatically during uberjar
              :uberjar  {:aot :all}
              }
  )

