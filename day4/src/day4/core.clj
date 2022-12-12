(ns day4.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def pairs (str/split-lines (slurp "input.txt")))

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

(part-1)



