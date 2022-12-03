(ns day3.core
  (:require
   [clojure.string :as str]
   [clojure.set :as set]))

(def rucksacks (str/split-lines (slurp "input.txt")))

(defn first-comp [s]
    (subs s 0 (/ (count s) 2)))

(defn second-comp [s]
  (subs s (/ (count s) 2)))

(defn split-string [s]
  [(first-comp s) (second-comp s)])

(def pairs (map #(split-string %) rucksacks))
pairs
(defn item-intersect [set1 set2]
  (set/intersection set1 set2))

(defn comp-compartments [[s1 s2]]
  (first (item-intersect (set s1) (set s2))))

(defn char-val [char]
  (if (re-matches #"[a-z]" (str char)) (- (int char) 96) (- (int char) 38)))

(defn puzzle-1 [split-strings]
  (let [shared-chars (map #(comp-compartments %) split-strings)
        char-vals (map #(char-val %) shared-chars)]
    (reduce + 0 char-vals)))

(puzzle-1 pairs)


