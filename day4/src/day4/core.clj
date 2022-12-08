(ns day4.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def pairs (str/split-lines (slurp "input.txt")))

(defn pair-to-vec [p]
  (let [v (map #(Integer/parseInt %) (str/split p #"-"))]
    (vec (range (first v) (+ (last v) 1)))))

(defn parse-pair [s]
  (let [[a b] (str/split s #",")
        x (pair-to-vec a)
        y (pair-to-vec b)]
    [x y]
    ))

(defn vec-fits [[v1 v2]]
  (let [a (set v1)
        b (set v2)
        ix (count (set/intersection a b))]
    (if (= ix 0) false 
        (if (or (< ix (count a)) (< ix (count b))) true false))))

(defn part-1 [v]
  (->> v
       (map parse-pair)
       (map vec-fits)))

(count (filter #(true? %) (part-1 pairs)))










