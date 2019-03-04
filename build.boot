(set-env! :resource-paths #{"resources" "src"}
          :dependencies   '[[org.clojure/clojure "1.9.0"]
                            [boot/core "2.8.2"]
                            [boot/new "0.5.3"]
                            [degree9/boot-semver "1.7.0" :scope "test"]])

(require '[degree9.boot-semver :refer :all]
         '[boot.new :refer [new]])

(task-options!
 pom {:project 'degree9/meta-template})

(deftask develop
  ""
  []
  (comp (version
          :develop true
          :minor 'inc
          :pre-release 'snapshot)
        (watch)
        (build-jar)))
