(ns byteart-svg.draw-test
  (:require [clojure.test :refer :all]
            [byteart-svg.draw :refer :all]))

(def triangles
  [ [ [ 3, 1 ], [ 6, 2 ], [ 7, 1 ] ],
   [ [ 2, 5 ], [ 6, 2 ], [ 3, 1 ] ],
   [ [ 1, 3 ], [ 2, 5 ], [ 3, 1]]])

(def some-colors
  ["#FF0000", "#00FF00", "0000FF"])

(deftest valid-image
  (testing "creates a valid color"
    (is (not (nil? (create-triangles triangles some-colors))))))
