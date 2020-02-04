(ns todolist.core
  (:require [reagent.core :as r]))

(enable-console-print!)

;;(println "This text is printed from src/todolist/core.cljs. Go ahead and edit it and see reloading in action.")

(defonce todoliste (r/atom "en" "to"))
;;(defn lageelementkontroller [element]



(defn visliste [todos]
  [:ul
   (for [[index element] (map-indexed vector @todos)]
     ^{:key index}
     [:li element])
   ])


(defn app []
  [:div
   [visliste @todoliste]
   ]
  )

(r/render [app]
          (.getElementById js/document "app"))
