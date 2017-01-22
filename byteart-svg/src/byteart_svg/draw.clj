(ns byteart-svg.draw
  (:require
    [byteart-svg.colors :as txcolors]
    [dali.io :as io]))

(defn draw-triangle [triangle-edges colors]
  [:polygon
    {:stroke "#B1B1B1" :stroke-width 0 :fill (first (shuffle colors))}
    (nth triangle-edges 0) (nth triangle-edges 1) (nth triangle-edges 2)])

;; For now a ring since fill is none
(defn draw-circle [center radius stroke-color stroke-width fill-color]
  [:circle
    {:stroke stroke-color :stroke-width stroke-width :fill :none}
    center radius])

(defn draw-triangles [triangles colors]
  [:dali/page
    (map (fn [triangle] (draw-triangle triangle colors)) triangles)])

(defn draw-circles [circles colors]
  [:dali/page
    (map (fn [circle] (draw-circle
                        (:center circle)
                        (:radius circle)
                        (first (shuffle colors))
                        (rand-int 20)
                        (first (shuffle colors))))
        circles)])

(defn create-triangles [triangles colors]
  (let [imageName (str (or (System/getenv "IMAGE_PATH") ".") "/triangles-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (draw-triangles triangles colors) imageName)
    imageName))

(defn create-circles [circles colors]
  (let [imageName (str (or (System/getenv "IMAGE_PATH") ".") "/circles-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (draw-circles circles colors) imageName)
    imageName))
