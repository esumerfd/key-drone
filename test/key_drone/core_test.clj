(ns key-drone.core-test
  (:require [clojure.test :refer :all]
            [key-drone.core :refer :all]))

(deftest key-handler-test

  (testing "takeoff condition"
    (with-redefs [navigate-takeoff (fn [] "takeoff")]
      (is (= "takeoff" (key-handler (int \t))))
      (is (= "takeoff" (key-handler (int \T))))
      )
    )

  (testing "land condition"
    (with-redefs [navigate-land (fn [] "land")]
      (is (= "land" (key-handler (int \l))))
      (is (= "land" (key-handler (int \L))))
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

