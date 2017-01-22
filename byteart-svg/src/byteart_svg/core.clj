(ns byteart-svg.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.adapter.jetty :as jetty]
            [byteart-svg.triangles :as triangles]
            [byteart-svg.circles :as circles]))

(defn handle-json [handler]
  (-> handler
    wrap-json-body
    wrap-json-response))

(defroutes app
  (POST "/triangles" [] (handle-json triangles/create))
  (POST "/circles" [] (handle-json circles/create)))

(defn -main [& args]
  (jetty/run-jetty app {:port 3000}))
