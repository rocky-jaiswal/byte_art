(ns byteart-svg.colors-test
  (:require [clojure.test :refer :all]
            [byteart-svg.colors :refer :all]))

(deftest valid-colors
  (testing "returns a valid color"
    (is (not (nil? (re-matches #"^#(\d|[A-Z]){6}" (colors)))))))
