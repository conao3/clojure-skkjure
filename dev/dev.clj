(ns dev
  (:require
   [com.stuartsierra.component.repl :as component.repl]
   [skkjure.system :as c.system]))

(component.repl/set-init (fn [_old-system] (c.system/new-system)))
(def system component.repl/system)
(def start component.repl/start)
(def stop component.repl/stop)
(def reset component.repl/reset)
