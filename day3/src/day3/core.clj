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

(defn get-three-groups [coll]
  (partition 3 1 coll))

;; loop
;; (defn get-three-groups [coll]
;;   (loop [i (/ (count coll) 3)
;;          res []]
;;     (if (= i (count coll))
;;       res
;;       (recur
;;        (inc i)
;;        (conj res (take 3 coll))))))

(def three-groups (get-three-groups rucksacks))
(nth three-groups 2)

(defn mapv2 [f coll]
  (mapv (fn [x] (mapv f x)) coll))

(defn get-unique [[s1 s2 s3]]
  (set/intersection s1 s2 s3))

(defn make-threegroup-into-sets [coll]
  (let [sets (mapv2 set coll)
        uniques (map get-unique sets)]
    uniques))

(defn create-sets [coll]
  (map set coll))

(make-threegroup-into-sets three-groups)

(def t (get-three-groups pairs))

(defn item-intersect [set1 set2]
  (set/intersection set1 set2))

(defn comp-compartments [[s1 s2]]
  (first (item-intersect (set s1) (set s2))))

(defn char-val [char]
  (if (re-matches #"[a-z]" (str char))
    (- (int char) 96)
    (- (int char) 38)))

(defn puzzle-1 [split-strings]
  (let [shared-chars (map comp-compartments split-strings) ; strangely do not have to use reader macro here!
        char-vals (map char-val shared-chars)]
    (reduce + 0 char-vals)))

(puzzle-1 pairs)


