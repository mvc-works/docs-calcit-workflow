
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]
            [shadow.resource :refer [inline]]
            [respo-md.comp.md :refer [comp-md-block]]
            ["highlight.js" :as hljs]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/fullscreen ui/row {:justify-content :center})}
    (div
     {:style {:max-width 800,
              :width "60%",
              :border (str "1px solid " (hsl 0 0 90)),
              :padding 16,
              :padding-bottom 200,
              :overflow :auto}}
     (comp-md-block
      (inline "guide.md")
      {:class-name "markdown-body",
       :highlight (fn [code lang] (.-value (.highlight hljs lang code)))}))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
