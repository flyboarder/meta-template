(ns boot.new.meta
  (:refer-clojure :exclude [meta])
  (:require [boot.util :as util]
            [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "meta"))

(defn meta
  "Genrate an empty [meta] project."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (util/info "Generating an empty [meta] project...\n")
    (->files data
             ["build.boot"                    (render "build.boot"   data)]
             ["src/.gitkeep"                  (render ".gitkeep"     data)]
             ["assets/.gitkeep"               (render ".gitkeep"     data)]
             ["resources/favicon.ico"         (render "favicon.ico"  data)]
             ["resources/config/default.json" (render "default.json" data)])))
