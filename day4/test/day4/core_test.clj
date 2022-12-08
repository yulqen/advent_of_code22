(ns day4.core-test
  (:require [clojure.test :refer :all]
            [day4.core :refer :all]))

(def input "2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8")

(deftest parse-single-pair-to-vector
  (testing "2-4 to become [2 3 4]")
  (is (= [2 3 4] (pair-to-vec "2-4"))))

(deftest parse-input-to-vectors
  (testing "2-4,6-8 to become [[2 3 4] [6 7 8]]"
    (is (= [[2 3 4] [6 7 8]] (parse-pair "2-4,6-8")))
    (is (= [[1 2 3 4] [3 4 5 6 7]] (parse-pair "1-4,3-7")))))

(deftest set-inside-the-other
  (is (vec-fits [[1 2 3 4 5 6] [2 3 4 5]]))
  (is (vec-fits [[3 4] [2 3 4 5]]))
  (is (vec-fits [[1] [1 2]]))
  (is (vec-fits [[8 9 10] [1 2]])))
