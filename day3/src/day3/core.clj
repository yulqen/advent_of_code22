(ns day3.core
  (:require
   [clojure.string :as str]
   [clojure.data :as data]))

(def rucksacks (str/split-lines (slurp "input.txt")))

(defn first-comp [s]
    [(subs s 0 (/ (count s) 2))])

(defn second-comp [s]
  [(subs s (/ (count s) 2))])

(defn split-string [s]
  [(first-comp s) (second-comp s)])

(def t (map #(split-string %) rucksacks))

