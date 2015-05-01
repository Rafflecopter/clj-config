(ns yanatan.config.core-test
  (:require [clojure.test :refer :all]
            [yanatan.config.core :refer :all]))

(deftest config-test
  (testing "throws before being setup"
    (config "")
    (is (= {} (config))))
  (testing "reads base fine"
    (is (= {:foo "bar" :bar 5 :baz {:moo "foo" :koo 1} :environ "test-val"}
           (config "base.json"))))
  (testing "returns base after"
    (is (= {:foo "bar" :bar 5 :baz {:moo "foo" :koo 1} :environ "test-val"}
           (config))))
  (testing "reads base and extend"
    (is (= {:foo "foobar" :bar 5 :baz {:moo "foo" :koo 10} :environ "test-val" :bug "bugz"}
           (config "base.json" "extend.json")))))
