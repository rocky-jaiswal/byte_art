(ns byteart-svg.rings
  (:require [byteart-svg.draw :as txdraw]
            [byteart-svg.colors :as txcolors]
            [ring.util.response :refer [response]]))

(defn random-ring []
  {:center [(rand-int 400) (rand-int 400)], :radius (rand-int 200)})

(def some-rings
  (repeatedly 800 random-ring))

(defn create [req]
  (response {:path (txdraw/create-rings some-rings (txcolors/get-colors (+ 2 (rand-int 50))))}))
