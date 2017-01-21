(ns byteart-svg.colors
  (:require [clojure.string :as str]))

(def hexcodes
  (str/split "ABCDEF01234567890" #""))

(defn colors []
  (str "#" (str/join (take 6 (shuffle hexcodes)))))

(defn get-colors []
  (nth (repeatedly 6 colors) 1))
