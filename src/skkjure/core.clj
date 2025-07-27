(ns skkjure.core
  (:require
   [com.stuartsierra.component :as component]
   [skkjure.serve :as c.serve]
   [clojure.tools.logging :as log]))

(defrecord Server [server]
  component/Lifecycle
  (start [this]
    (log/info "Starting Server...")
    (let [server (c.serve/start)]
      (log/info "Started Server")
      (assoc this :server server)))

  (stop [this]
    (log/info "Stopping Server...")
    (server :timeout 100)
    (log/info "Stopped Server")
    (assoc this :server nil)))

(defn new-system []
  (component/system-map
   :server (map->Server {})))
