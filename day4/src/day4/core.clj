(ns day4.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def pairs (str/split-lines (slurp "input.txt")))


; 5 7 7 9 - x is greater than a
; 2 8 3 7 - x is greater than a
; 6 6 4 6 - 
(defn separate? [[a b x y]]
  (or
   (< b x)
   (< y a)))

(defn fully-contains? [[a b x y]]
  (or (<= a x y b)
      (<= x a b y)))

(defn range-pair [s]
  (for [[_ & abxy] (re-seq #"(\d+)-(\d+),(\d+)-(\d+)" s)]
    (mapv #(Integer/parseInt %) abxy)))


(defn part-1 []
  (->> (mapv range-pair pairs)
       (map first)
       (map fully-contains?)
       (filter true?)
       count))

(defn part-2 []
  (->> (mapv range-pair pairs)
       (map first)
       (map separate?)
       (filter false?)
       count))

(part-1)
(part-2)



