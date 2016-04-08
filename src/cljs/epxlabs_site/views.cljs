(ns epxlabs-site.views
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]))


;; picture
(defn home-image []
  [re-com/box
   :child
   [:img {:src "/../images/EPX_logo_outline.png"}]
   :max-width "100%"
   :height "auto"
   ])

(defn home-page []
  [re-com/v-box
   :children [[home-image]]
   :size "auto"
   :align :center
   :padding "2em"
   ])

(defn link-to-about-page []
  [re-com/hyperlink-href
   :label "go to About Page"
   :href "#/about"])

#_(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :height "100"
   :children [[home-image] [link-to-about-page]]])


;; about

(defn about-title []
  [re-com/title
   :label "This is the About Page."
   :level :level1])

(defn link-to-home-page []
  [re-com/hyperlink-href
   :label "go to Home Page"
   :href "#/"])

(defn about-panel []
  [re-com/v-box
   :gap "1em"
   :children [[about-title] [link-to-home-page]]])




;; main

(defmulti panels identity)
(defmethod panels :home-panel [] [home-page])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [re-com/v-box
       :height "100%"
       :children [(panels @active-panel)]])))
