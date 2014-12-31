(ns key-drone.core-test
  (:require [clojure.test :refer :all]
            [key-drone.core :refer :all]))

(deftest pressed-keys-test
  ;(testing "pressed-keys"
  ;(is (= 13 (pressed-keys #(+ 0 %)))))
  )

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

