(ns day5.core
  (:require [clojure.string :as str]))

(def data (str/split-lines (slurp "input.txt")))

(first data)
