
(ns app.config (:require [app.util :refer [get-env!]]))

(def bundle-builds #{"release" "local-bundle"})

(def dev?
  (if (exists? js/window)
    (do ^boolean js/goog.DEBUG)
    (not (contains? bundle-builds (get-env! "mode")))))

(def site
  {:storage "cumulo-org",
   :dev-ui "http://localhost:8100/main.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main.css",
   :cdn-url "http://cdn.tiye.me/cumulo-org/",
   :cdn-folder "tiye.me:cdn/cumulo-org",
   :title "Cumulo",
   :icon "http://cdn.tiye.me/logo/cumulo.png",
   :upload-folder "tiye.me:repo/Cumulo/cumulo.org/"})
