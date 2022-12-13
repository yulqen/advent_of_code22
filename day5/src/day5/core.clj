(ns day5.core
  (:require [clojure.string :as str]))

(def data (str/split-lines (slurp "input.txt")))

(defn parse-data-line [line]
  (for [x [1 5 9 13 17 21 25 29 33]]
    (nth line x)))

(defn parse-instruction-line [line]
  (let [[_ q s d] (first (re-seq #"move (\d+) from (\d+) to (\d+)" line))]
    {:quant (Integer/parseInt q) :source (Integer/parseInt s) :dest (Integer/parseInt d)}))

(def instruction-map (map parse-instruction-line (first (rest (split-at 10 data)))))

(def initial-stack-rows (map parse-data-line (take 8 data)))

(defn create-stacks [data]
  (for [s [0 1 2 3 4 5 6 7 8]]
    (map (fn [x] (nth x s)) data)))

(def stacks (create-stacks initial-stack-rows))

(defn take-replace-with-space [q stack]
  )


(defn run-instruction []
  (for [x instruction-map]
    (let [q (:quant x)
          s (:source x)
          d (:dest x)
          idx (- s 1)
          stack (nth stacks idx)
          content (filter (fn [x] (not= x \space)) stack)
          cargo (take q content)]
      #_(println "Taking " cargo " from " content)
      stack)))










