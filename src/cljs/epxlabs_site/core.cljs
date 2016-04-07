(ns epxlabs-site.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [epxlabs-site.handlers]
              [epxlabs-site.subs]
              [epxlabs-site.routes :as routes]
              [epxlabs-site.views :as views]
              [epxlabs-site.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
