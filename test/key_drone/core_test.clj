(ns key-drone.core-test
  (:require [clojure.test :refer :all]
            [key-drone.core :refer :all]))

(deftest runs-main
  (testing "runs main"
    (is (= 0 (key-drone)))))

