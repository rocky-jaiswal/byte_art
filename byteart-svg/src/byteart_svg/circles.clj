(ns byteart-svg.circles
  (:require [byteart-svg.draw :as txdraw]
            [byteart-svg.colors :as txcolors]
            [ring.util.response :refer [response]]))

(defn random-circle []
  {:center [(rand-int 400) (rand-int 400)], :radius (rand-int 200)})

(def some-circles
  (repeatedly 800 random-circle))

(defn create [req]
  (response {:path (txdraw/create-circles some-circles (txcolors/get-colors (+ 2 (rand-int 50))))}))
