(ns web.handler
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [web.views :as views]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/"
    []
    (views/home-page))

  (GET "/posts"
    []
    (views/posts))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults #'app-routes site-defaults))

(defn -main 
  []
  (jetty/run-jetty #'app {:port 3000}))
