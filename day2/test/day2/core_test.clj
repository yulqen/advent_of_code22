(ns day2.core-test
  (:require [clojure.test :refer :all]
            [day2.core :refer :all]))

(deftest game-win-loss
  (testing "Paper rock scissors tests"
    (is (= (game "A" "Y") :win))
    (is (= (game "A" "Z") :loss))
    (is (= (game "A" "X") :draw))
    (is (= (game "B" "Y") :draw))
    (is (= (game "B" "Z") :win))
    (is (= (game "B" "X") :loss))
    (is (= (game "C" "Y") :loss))
    (is (= (game "C" "Z") :draw))
    (is (= (game "C" "X") :win))
    )
  )

(deftest eval-result
  (testing "Assign a score to a result"
    (is (= (evaluate-result :win) 6))
    (is (= (evaluate-result :draw) 3))
    (is (= (evaluate-result :loss) 0))))

(deftest my-choice-score
  (testing "Testing getting a score from my choice"
    (is (= (get-score "X") 1))
    (is (= (get-score "Y") 2))
    (is (= (get-score "Z") 3))
    ))

(deftest test-eval-game
  (is (= (eval-game ["A" "Y"]) 8))
  (is (= (eval-game ["B" "X"]) 1))
  )

(deftest test-puzzle-1
  (testing "The final solution"
    (is (= (puzzle-1 (lazy-seq ["A" "Y"] ["A" "Y"] ["A" "Y"])) 24))))

