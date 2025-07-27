(ns skkjure.serve
  (:require
   [org.httpkit.server :as httpkit.server]))

(defn app [req]
  ((requiring-resolve clojure.pprint/pprint) req)
  {:status 200
   :body "Hello HTTP!"})

(defn start []
  (httpkit.server/run-server app))
