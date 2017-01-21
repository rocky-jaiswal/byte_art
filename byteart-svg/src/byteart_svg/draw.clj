(ns byteart-svg.draw
  (:require [dali.io :as io]))

(defn draw-triangle [triangle-edges colors]
  [:polygon
    {:stroke "#B1B1B1" :stroke-width 0 :fill (nth (shuffle colors) 1)}
    (nth triangle-edges 0) (nth triangle-edges 1) (nth triangle-edges 2)])

(defn create-document [triangles colors]
  [:dali/page
    (map (fn [triangle] (draw-triangle triangle colors)) triangles)])

(defn create-svg [triangles colors]
  (let [imageName (str (System/getenv "IMAGE_PATH") "/triangles-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (create-document triangles colors) imageName)
    imageName))
