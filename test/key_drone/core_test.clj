(ns key-drone.core-test
  (:require [clojure.test :refer :all]
            [key-drone.core :refer :all]))

(deftest key-handler-test

  (testing "left condition"
    (with-redefs [navigate-left (fn [] "left")]
      (is (= "left" (key-handler (int \h))))
      (is (= "left" (key-handler (int \H))))
      )
    )

  (testing "right condition"
    (with-redefs [navigate-right (fn [] "right")]
      (is (= "right" (key-handler (int \l))))
      (is (= "right" (key-handler (int \L))))
      )
    )

  (testing "forward condition"
    (with-redefs [navigate-forward (fn [] "forward")]
      (is (= "forward" (key-handler (int \k))))
      (is (= "forward" (key-handler (int \K))))
      )
    )

  (testing "backward condition"
    (with-redefs [navigate-backward (fn [] "backward")]
      (is (= "backward" (key-handler (int \j))))
      (is (= "backward" (key-handler (int \J))))
      )
    )

  (testing "up condition"
    (with-redefs [navigate-up (fn [] "up")]
      (is (= "up" (key-handler (int \u))))
      (is (= "up" (key-handler (int \U))))
      )
    )

  (testing "down condition"
    (with-redefs [navigate-down (fn [] "down")]
      (is (= "down" (key-handler (int \d))))
      (is (= "down" (key-handler (int \D))))
      )
    )

  (testing "takeoff condition"
    (with-redefs [navigate-takeoff (fn [] "takeoff")]
      (is (= "takeoff" (key-handler (int \t))))
      (is (= "takeoff" (key-handler (int \T))))
      )
    )

  (testing "land condition"
    (with-redefs [navigate-land (fn [] "land")]
      (is (= "land" (key-handler (int \g))))
      (is (= "land" (key-handler (int \G))))
      )
    )

  (testing "quit character"
    (is (= false (key-handler (int \q))))
    (is (= false (key-handler (int \Q))))
    )

  (testing "invalid keystroke"
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

