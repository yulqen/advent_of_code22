(ns day5.core
  (:require [clojure.string :as str]))

(def data (str/split-lines (slurp "input.txt")))

(defn parse-data-line [line]
  (for [x [1 5 9 13 17 21 25 29 33]]
    (nth line x)))

(def initial-stack-rows (map parse-data-line (take 8 data)))

(defn create-stacks [data]
  (for [s [0 1 2 3 4 5 6 7 8]]
    (map (fn [x] (nth x s)) data)))







