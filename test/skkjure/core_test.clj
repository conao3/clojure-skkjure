(ns skkjure.core-test
  (:require
   [clojure.test :as t]
   [skkjure.core :as c.core]))

(t/deftest add-test
  (t/testing "Adding 2 positive numbers"
    (t/is (= 3 (c.core/add 1 2)))))
