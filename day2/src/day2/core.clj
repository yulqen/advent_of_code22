(ns day2.core
  (:require [clojure.string :as str]))

;; Reference
;; ---------
;; theirs  mine value  type
;; A       X    1      Rock
;; B       Y    2      Paper
;; C       Z    3      Scissors

;; Round scores
;; 0 loss
;; 3 draw
;; 6 win

(def pairs (map vector (str/split-lines(slurp "input.txt"))))

(defn game [theirs ours]
  (cond
    (and (= theirs "A") (= ours "Y")) :win
    (and (= theirs "A") (= ours "Z")) :loss
    (and (= theirs "A") (= ours "X")) :draw
    (and (= theirs "B") (= ours "Y")) :draw
    (and (= theirs "B") (= ours "Z")) :win
    (and (= theirs "B") (= ours "X")) :loss
    (and (= theirs "C") (= ours "Y")) :loss
    (and (= theirs "C") (= ours "Z")) :draw
    (and (= theirs "C") (= ours "X")) :win
    ))

(defn evaluate-result [result]
  (cond
    (= result :win) 6
    (= result :draw) 3
    (= result :loss) 0))

(defn get-score [choice]
  (cond
    (= choice "X") 1
    (= choice "Y") 2
    (= choice "Z") 3))

(defn eval-game [[theirs ours]]
  (let [result (game theirs ours)
        result-score (evaluate-result result)
        choice-score (get-score ours)]
    (+ result-score choice-score)))
(comment 
  (eval-game ["A" "Y"])
  (eval-game ["B" "X"])
  (eval-game ["C" "X"]))


(defn puzzle-1 [v]
  (prn (type v))
  (reduce + 0 (map eval-game v)))

(comment (reduce + 0 (map eval-game [["A" "Y"] ["B" "X"]])))

(puzzle-1 pairs)
