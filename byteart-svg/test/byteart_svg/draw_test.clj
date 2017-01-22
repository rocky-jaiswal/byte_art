(ns byteart-svg.draw-test
  (:require [clojure.test :refer :all]
            [byteart-svg.colors :as txcolors]
            [byteart-svg.draw :refer :all]))

(def triangles
  [ [ [ 3, 1 ], [ 6, 2 ], [ 7, 1 ] ],
    [ [ 2, 5 ], [ 6, 2 ], [ 3, 1 ] ],
    [ [ 1, 3 ], [ 2, 5 ], [ 3, 1]]])

(defn circle []
  {:center [(rand-int 20) (rand-int 20)], :radius (rand-int 20)})

(def circles
  (repeatedly 2 circle))

(def some-colors
  (txcolors/get-colors (+ 2 (rand-int 6))))

(deftest valid-triangles
  (testing "creates triangles"
    (is (not (nil? (create-triangles triangles some-colors))))))

(deftest valid-circles
  (testing "creates circles"
    (is (not (nil? (create-circles circles some-colors))))))
