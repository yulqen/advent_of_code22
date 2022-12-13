(ns day5.core-test
  (:require [clojure.test :refer :all]
            [day5.core :refer :all]))

(deftest data-line
  (is (= (parse-data-line "[Q]         [N]             [N]    ") [\Q \space \space \N \space \space \space \N \space])))

