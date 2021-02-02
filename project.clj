(defproject tourguide "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [org.jmdns/jmdns "3.5.6"]
                 [org.slf4j/slf4j-simple "1t.7.9"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler tourguide.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
