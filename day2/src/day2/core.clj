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

(def pairs (map #(str/split % #" ")(str/split-lines(slurp "input.txt"))))

(def score-map
  {"X" 1
   "Y" 2
   "Z" 3})

(defn calc [[opponent-choice required]]
  (cond
    (= required "X") (to-loose opponent-choice)
    (= required "Y") (to-draw opponent-choice)
    (= required "Z") (to-win opponent-choice)))

(defn to-win [opponent-choice]
  (cond
    (= opponent-choice "A") (+ 6 (get score-map "Y"))
    (= opponent-choice "B") (+ 6 (get score-map "Z"))
    (= opponent-choice "C") (+ 6 (get score-map "X"))))

(defn to-draw [opponent-choice]
  (cond
    (= opponent-choice "A") (+ 3 (get score-map "X"))
    (= opponent-choice "B") (+ 3 (get score-map "Y"))
    (= opponent-choice "C") (+ 3 (get score-map "Z"))))

(defn to-loose [opponent-choice]
  (cond
    (= opponent-choice "A") (get score-map "Z")
    (= opponent-choice "B") (get score-map "X")
    (= opponent-choice "C") (get score-map "Y")))

(defn puzzle-2 [v]
  (reduce + 0 (map #(calc %) v)))

(puzzle-2 pairs)

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

(defn eval-game [v]
  (let [[theirs ours] v
        result (game theirs ours)
        result-score (evaluate-result result)
        choice-score (get-score ours)]
          (+ result-score choice-score)))

(comment 
  (eval-game ["A" "Y"])
  (eval-game ["B" "X"])
  (eval-game ["C" "Y"]))

(defn puzzle-1 [v]
  (reduce + 0 (map #(eval-game %) v)))

(puzzle-1 pairs)
