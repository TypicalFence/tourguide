(ns tourguide.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(defroutes app-routes
           (GET "/" [] "Hello World")
           (route/not-found "Not Found"))
