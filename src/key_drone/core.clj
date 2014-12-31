(ns key-drone.core
  (:use clj-drone.core)
  (:require  
    [clojure.java.io :as io]
    [clojure.string :as string]
    )
  (:import  [jline.console ConsoleReader])
  (:gen-class :main true))

(defn log
  [message]
  (println message)
  )

(defn navigate
  [nav-plan]
  (try
    (drone nav-plan)
    (catch java.io.IOException e  
      (log (str "caught exception: "  (.getMessage e)))))
  )

(defn navigate-takeoff
  []
  (log "Drone taking off")
  (navigate :take-off)
  true
  )

(defn navigate-land
  []
  (log "Drone landing")
  (navigate :land)
  true
  )

(defn invalid-key
  []
  (log "Invalid key pressed")
  true
  )

(defn quit
  []
  (log "Closing down")
  false
  )

;input: ascii code of key
;transform: apply function associsated with key
;output: true/false for quit key pressed
;implements interfaces:
; - control handler (output true/false)
; - key press handler (input asciiCode, output: true/false)
(defn key-handler
  [asciiCode]

  (let [keypressed (string/upper-case (char asciiCode))]
    (cond
      (= keypressed "T") (navigate-takeoff)
      (= keypressed "L") (navigate-land)
      (= keypressed "Q") (quit)
      :else (invalid-key)
      )    
    )
  )

;input: key press handler
;transform: input key strokes
;output; true/false from handler
;requires interface:
; - key press handler
(defn pressed-keys
  "generates keystrokes"
  [key-press-handler]
  (let [reader (ConsoleReader.) 
        asciiCode (.readCharacter reader)]
    (key-press-handler asciiCode)
    )
  )

;input: control handler
;transform: call handler until false
;output: false
;requires interface:
; - control handler
(defn control-loop
  [control-handler]
  (while (pressed-keys control-handler))
  )

;input: none
;transform: started application into drone control
;output: exit code 0 for success else failure
(defn key-drone
  "Key drone startup"
  []
  (log "Starting Key Drone (q to quit)")

  (drone-initialize)

  (control-loop key-handler)

  (int 0))

(defn -main
  "Command  line entry point for key-drone"
  [& args]
  (key-drone))

