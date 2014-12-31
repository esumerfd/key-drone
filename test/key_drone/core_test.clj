(ns key-drone.core-test
  (:require [clojure.test :refer :all]
            [key-drone.core :refer :all]))

(deftest key-handler-test

  (testing "navigation character"
    (is (= true (key-handler 101)))
    )   

  (testing "lower case quit character"
    (is (= false (key-handler 113)))
    )

  (testing "upper case quit character"
    (is (= false (key-handler 81)))
    )
  )

(deftest control-loop-test
  (testing "exit after false is returned"
    (with-redefs  [pressed-keys (fn [key-press-handler] (key-press-handler "ignored") )]
      (control-loop (fn [ignored] false))
      )
    )
  )

