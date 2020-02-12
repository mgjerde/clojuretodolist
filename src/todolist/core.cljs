(ns todolist.core
  (:require [reagent.core :as r]))

;;(enable-console-print!)
;;(println "This text is printed from src/todolist/core.cljs. Go ahead and edit it and see reloading in action.")

(defonce todoliste (new r/atom))
(defn visliste [todos]
  [:ol
   (for [element todos]
     [:li element
      ])])

(defn leggtilkontroller [todoliste]
  (let [tekst (r/atom "")]
  [:div
   [:input
    {:type "text"
     :value @tekst
      :on-change #(swap! tekst %)
     }
    ]
   [:input
   { :type "button"
    :on-click (do
                 (swap! todoliste #(conj % @tekst))
                )
    }
    ]
   ]
  ))



(defn app []
  [:div
   [visliste @todoliste]
   [leggtilkontroller @todoliste]
   ]
  )

(r/render [app]
          (.getElementById js/document "app"))
