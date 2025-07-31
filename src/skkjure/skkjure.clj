(ns skkjure.skkjure
  (:gen-class)
  (:require
   [clojure.tools.logging :as log]
   [com.stuartsierra.component :as component]
   [skkjure.core :as c.core]))

(declare commands)

(defn add [a b]
  (+ a b))

(defn eprintln [& args]
  (binding [*out* *err*]
    (apply println args)))

(defn cmd-serve
  "Serve skkjure server"
  [& _args]
  (let [system (-> (c.core/new-system)
                   component/start-system)]
    (-> (Runtime/getRuntime)
        (.addShutdownHook (Thread. (fn []
                                     (log/info "Shutdown signal received")
                                     (component/stop-system system)
                                     (log/info "Shutdown hook completed")))))
    (Thread/sleep Long/MAX_VALUE)))

(defn cmd-help
  "Help"
  [& _args]
  (eprintln "Available commands:")
  (doseq [[k v] commands]
    (-> (format "  %s - %s" (name k) (:doc (meta v)))
        eprintln)))

(def commands {:serve #'cmd-serve
               :help #'cmd-help})

(defn -main [& args]
  (if-let [command (get commands (keyword (first args)))]
    (apply command args)
    (do (when (first args)
          (eprintln (format "`%s' is not a skkjure command." (first args))))
        (apply cmd-help args))))
