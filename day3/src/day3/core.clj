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

(defn mapv2 [f coll]
  (map (fn [x] (map f x)) coll))

(defn get-unique-chars-each-group [sacks]
  (->> (get-three-groups sacks)
       (mapv2 set)
       (map
        #(apply set/intersection %))
       (mapv2 char-val)
       flatten
       (reduce + 0)
       ))

(get-unique-chars-each-group rucksacks)

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


