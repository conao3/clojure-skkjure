(ns skkjure.serve
  (:require
   [lsp4clj.io-server :as lsp.io-server]))

(defn app [req]
  ((requiring-resolve 'clojure.pprint/pprint) req)
  {:status 200
   :body "Hello HTTP!"})

(defn start []
  (lsp.io-server/stdio-server))
