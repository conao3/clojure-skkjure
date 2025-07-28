(ns skkjure.skkjure-test
  (:require
   [clojure.test :as t]
   [skkjure.skkjure :as c.skkjure]))

(t/deftest add-test
  (t/testing "Adding 2 positive numbers"
    (t/is (= 3 (c.skkjure/add 1 2)))))
