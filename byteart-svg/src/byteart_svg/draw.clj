(ns byteart-svg.draw
  (:require [dali.io :as io]
            [byteart-svg.colors :as txcolors]))

(defn draw-triangle [triangle-edges]
  [:polygon
    {:stroke "#B1B1B1" :stroke-width 0 :fill (txcolors/get-colors)}
    (nth triangle-edges 0) (nth triangle-edges 1) (nth triangle-edges 2)])

(defn create-document [triangles]
  [:dali/page
    (map draw-triangle triangles)])

(defn create-svg [triangles]
  (let [imageName (str "triangles-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (create-document triangles) imageName)
    imageName))
