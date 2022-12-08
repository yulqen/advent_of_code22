(ns day3.core-test
  (:require [clojure.test :refer :all]
            [day3.core :refer :all]
            [clojure.set :as set]))

(deftest test-intersect
  (testing "Get the intersection between two sets"
    (is (= #{\d} (item-intersect (set "abcd") (set "defg"))))))

(deftest test-diff-compartment-contents
  (testing "Get difference between compartments in bag"
    (is (= \h (comp-compartments ["Cjh" "TTh"])))))

(deftest test-split-str-in-half
  (testing "Can split even string to vector of two strings"
    (is (= ["AAA" "BBB"] (split-string "AAABBB")))))

(deftest test-get-char-numeric
  (testing "Returns the number from a char"
    (is (= 1 (char-val \a)))
    (is (= 2 (char-val \b)))
    (is (= 27 (char-val \A)))))

(deftest intersect-sets
  (let [s1 (set "Djr")
        s2 (set "Dr")
        s3 (set "Djr")]
    (is (= #{\r} (set/intersection s1 s2 s3))))
 )

(deftest getting-unique
  (let [data-first ["ABCD" "ABEFG" "HBIJA"]]
    (is (= 27 (get-unique-chars-each-group data-first)))))

(deftest part2-solution
  (let [data-first ["vJrwpWtwJgWrhcsFMMfFFhFp" "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL" "PmmdzqPrVvPwwTWBwg"]
        data-second ["wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn" "ttgJtRGJQctTZtZT" "CrZsJsPPZsGzwwsLwLmpwMDw"]]
    (is (= 18 (get-unique-chars-each-group data-first)))
    (is (= 52 (get-unique-chars-each-group data-second)))))

