(ns skkjure.serve
  (:require
   [jsonrpc4clj.io-server :as lsp.io-server]))

(defn app [req]
  ((requiring-resolve 'clojure.pprint/pprint) req)
  {:status 200
   :body "Hello HTTP!"})

(defn start []
  (lsp.io-server/stdio-server))
