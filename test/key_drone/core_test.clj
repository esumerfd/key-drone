(ns key-drone.core-test
  (:require [clojure.test :refer :all]
            [key-drone.core :refer :all]))

(deftest key-handler-test

  (def navigation-keymap 
    {
     \h :tilt-left      
     \H :tilt-left      
     \l :tilt-right
     \L :tilt-right
     \u :up
     \U :up
     \d :down
     \D :down
     \j :tilt-back
     \J :tilt-back
     \k :tilt-front
     \K :tilt-front
     \t :take-off
     \T :take-off
     \g :land
     \G :land
     }
    )

  (doseq [keymap navigation-keymap] 
    (let [
          key-char (first keymap)
          expected-nav-plan (second keymap)
          ]
      (testing (str "should navigate " expected-nav-plan " with " key-char)
        (with-redefs [navigate (fn [actual-nav-plan] (is (= expected-nav-plan actual-nav-plan)))]
          (key-handler (int key-char))
          )
        )
      )
    )

  (testing "should quit program"
    (is (= false (key-handler (int \q))))
    (is (= false (key-handler (int \Q))))
    )

  (testing "should handle invalid keystroke"
    (is (= true (key-handler (int \e))))
    )   
  )

(deftest control-loop-test
  (testing "exit after false is returned"
    (with-redefs  [pressed-keys (fn [key-press-handler] (key-press-handler "ignored") )]
      (control-loop (fn [ignored] false))
      )
    )
  )

