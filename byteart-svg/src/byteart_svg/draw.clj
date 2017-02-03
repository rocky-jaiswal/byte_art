(ns byteart-svg.draw
  (:require
    [byteart-svg.colors :as txcolors]
    [dali.io :as io]))

(defn draw-triangle [triangle-edges colors]
  [:polygon
    {:stroke "#B1B1B1" :stroke-width 0 :fill (first (shuffle colors))}
    (nth triangle-edges 0) (nth triangle-edges 1) (nth triangle-edges 2)])

(defn draw-ring [center radius stroke-color stroke-width fill-color]
  [:circle
    {:stroke stroke-color :stroke-width stroke-width :fill :none}
    center radius])

(defn draw-circle [center radius color]
  [:circle
    {:stroke color :stroke-width 0 :fill color}
    center radius])

(defn draw-triangles [triangles colors]
  [:dali/page
    (map (fn [triangle] (draw-triangle triangle colors)) triangles)])

(defn draw-rings [rings colors]
  [:dali/page
    (map (fn [circle] (draw-ring
                        (:center circle)
                        (:radius circle)
                        (first (shuffle colors))
                        (rand-int 20)
                        (first (shuffle colors))))
        rings)])

(defn draw-circles [circles colors]
  [:dali/page
    (map (fn [circle] (draw-circle
                        (:center circle)
                        (:radius circle)
                        (first (shuffle colors))))
        circles)])

(defn create-shapes [drawfn shapes colors]
  (let [imageName (str (or (System/getenv "IMAGE_PATH") ".") "/byteart-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (drawfn shapes colors) imageName)
    imageName))

(defn create-triangles [triangles colors]
  (create-shapes draw-triangles triangles colors))

(defn create-rings [rings colors]
  (create-shapes draw-rings rings colors))

(defn create-circles [circles colors]
  (create-shapes draw-circles circles colors))
