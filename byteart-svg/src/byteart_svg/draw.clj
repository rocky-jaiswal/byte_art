(ns byteart-svg.draw
  (:require [dali.io :as io]))

(defn draw-triangle [triangle-edges colors]
  [:polygon
    {:stroke "#B1B1B1" :stroke-width 0 :fill (first (shuffle colors))}
    (nth triangle-edges 0) (nth triangle-edges 1) (nth triangle-edges 2)])

(defn create-document [triangles colors]
  [:dali/page
    (map (fn [triangle] (draw-triangle triangle colors)) triangles)])

(defn create-triangles [triangles colors]
  (let [imageName (str (or (System/getenv "IMAGE_PATH") ".") "/triangles-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (create-document triangles colors) imageName)
    imageName))
