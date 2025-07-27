(ns user
  (:require
   [com.stuartsierra.component.user-helpers :as component.user-helpers]))

(set! *warn-on-reflection* true)

(def dev component.user-helpers/dev)
(def go component.user-helpers/go)
