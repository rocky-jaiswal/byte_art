(ns byteart-svg.triangles
  (:require [byteart-svg.draw :as txdraw]
            [byteart-svg.colors :as txcolors]
            [ring.util.response :refer [response]]))

(defn create [req]
  (response {:path (txdraw/create-svg (get req :body) (txcolors/get-colors (+ 2 (rand-int 6))))}))
