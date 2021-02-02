(ns tourguide.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [tourguide.routes :refer [app-routes]]))

(def app
  (wrap-defaults app-routes site-defaults))
