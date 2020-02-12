(ns todolist.core
  (:require [reagent.core :as r]))

;;(enable-console-print!)
;;(println "This text is printed from src/todolist/core.cljs. Go ahead and edit it and see reloading in action.")

(defonce todoliste (r/atom nil))

(defn visliste [todos]
  (prn todos)
  [:div "foo"
    (map (fn [val] [:div val] ) todos)
   ])

(defn leggtilkontroller [todoliste]
  #_(let [tekst (r/atom "")]
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
  (reset! todoliste ["Spise mat" "Rydde kjøkkenet"])
  [:div
   [visliste @todoliste]
   [leggtilkontroller @todoliste]
   ]
  )

(r/render [app]
          (.getElementById js/document "app"))
