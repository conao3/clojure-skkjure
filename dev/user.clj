(ns user
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))

(set! *warn-on-reflection* true)

(defn load-tests []
  (doseq [test-file (->> (file-seq (io/file "test"))
                         (filter #(.isFile ^java.io.File %))
                         (filter #(str/ends-with? (.getName ^java.io.File %) "_test.clj")))]
    (println (format "loading %s..." (.getPath ^java.io.File test-file)))
    (load-file (.getPath ^java.io.File test-file))))

(load-tests)
