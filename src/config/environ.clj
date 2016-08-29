(ns config.environ
  (:require [clojure.string :as string]
            [clojure.walk :refer [prewalk]]
            [environ.core :refer [env]]))

(defn getenv [v]
  (-> v
      string/lower-case
      (string/replace "_" "-")
      keyword
      env))

(defn- eval-environ [s]
  (string/replace s #"\{env://([\w_]+)\}"
    (fn [[_ evar]]
      (or (getenv evar) ""))))

(defn walk [obj]
  (prewalk #(if (string? %) (eval-environ %) %) obj))
