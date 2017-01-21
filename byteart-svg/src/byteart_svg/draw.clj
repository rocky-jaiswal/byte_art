(ns byteart-svg.draw
  (:require [dali.io :as io]
            [byteart-svg.colors :as txcolors]))

(def randomColors
  (txcolors/get-colors 4))

(defn draw-triangle [triangle-edges]
  [:polygon
    {:stroke "#B1B1B1" :stroke-width 0 :fill (nth (shuffle randomColors) 1)}
    (nth triangle-edges 0) (nth triangle-edges 1) (nth triangle-edges 2)])

(defn create-document [triangles]
  [:dali/page
    (map draw-triangle triangles)])

(defn create-svg [triangles]
  (let [imageName (str (System/getenv "IMAGE_PATH") "/triangles-" (System/currentTimeMillis) ".svg")]
    (io/render-svg (create-document triangles) imageName)
    imageName))
