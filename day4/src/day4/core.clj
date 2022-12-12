(ns day4.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def pairs (str/split-lines (slurp "input.txt")))

(defn range-pair [s]
  (for [[_ & abxy] (re-seq #"(\d+)-(\d+),(\d+)-(\d+)" s)]
    (mapv #(Integer/parseInt %) abxy)))




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
  (if (= (count v1) (count v2)) false
      (let [len-v1 (count v1)
            len-v2 (count v2)
            longest-v (first (filter #(= (count %) (apply max (map count [v1 v2]))) [v1 v2]))
            shortest-v (first (filter #(not (= (count %) (apply max (map count [v1 v2])))) [v1 v2]))
            first-v1 (first v1)
            last-v1 (first (reverse v1))
            first-v2 (first v2)
            last-v2 (first (reverse v2))]
        (cond
          (= (first v1) (first v2)) false
          (<= (count longest-v) 2) (do println "False because length of longest-v is <=2" false)
          (= len-v1 len-v2) (do println "False because len-v1 == len-v2" false)
          (and (>= (first shortest-v) (first longest-v))
               (< (first (reverse shortest-v)) (first (reverse longest-v)))) true
          :else false
          ))))

(defn part-1 [v]
  (->> v
       (map parse-pair)
       (map vec-fits)))

(count (filter #(true? %) (part-1 pairs)))










