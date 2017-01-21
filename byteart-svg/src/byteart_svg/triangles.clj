(ns byteart-svg.triangles
  (:require [byteart-svg.draw :as txdraw]
            [ring.util.response :refer [response]]))

(defn create [req]
  (response {:path (txdraw/create-svg (get req :body))}))