(ns config.core
  (:require [clojure.data.json :as json]
            [clojure.contrib.map-utils :as mapu]
            [clojure.java.io :as io]
            [config.environ :as cfgenv]))

(defn read-json [file]
  (try (-> file
           io/resource
           slurp
           (json/read-str :key-fn keyword))
       (catch Exception e {})))

(defn deep-merge [& maps]
  (apply mapu/deep-merge-with (fn [x y] y) maps))

(defonce ^:private cfg (atom {}))

(defn config
  ([] @cfg)
  ([& files]
    (let [c (apply deep-merge (map (comp cfgenv/walk read-json) files))]
      (reset! cfg c)
      c)))
