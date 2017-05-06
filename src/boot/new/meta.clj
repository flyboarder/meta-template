(ns boot.new.meta
  (:require [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "meta"))

(defn meta
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println "Generating fresh 'boot new' meta project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
