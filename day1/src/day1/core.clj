(ns day1.core
  (:require [clojure.string :as str]))

(defn split-to-vecs [raw]
  (mapv str/split-lines (str/split raw #"\n\n")))

(defn conv-vec-nums-to-string [v]
  (mapv #(Integer/parseInt %) v))

(defn puzzle-1 [fn]
  (let [raw (slurp fn)
        vecs (mapv str/split-lines (str/split raw #"\n\n"))
        vec-numbers (mapv conv-vec-nums-to-string d)
        reduc (reverse (vec (map #(reduce + %) (mapv conv-vec-nums-to-string d))))]
        (apply max reduc)))

(defn puzzle-2 [fn]
  (let [raw (slurp fn)
        vecs (mapv str/split-lines (str/split raw #"\n\n"))
        vec-numbers (mapv conv-vec-nums-to-string d)
        reduc (reduce + (take 3 (reverse (sort (vec (map #(reduce + %) (mapv conv-vec-nums-to-string d)))))))]
    reduc))


;;; (def puzzle-2 (reduce + (take 3 (reverse (reduc "input.txt")))))

(puzzle-2 "input.txt")

(puzzle-1 "input.txt") ;; answer for first => 65912
