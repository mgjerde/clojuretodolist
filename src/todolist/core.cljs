(ns todolist.core
  (:require [reagent.core :as r]))

(enable-console-print!)
;;(println "This text is printed from src/todolist/core.cljs. Go ahead and edit it and see reloading in action.")

(def todoliste-global (r/atom ()))

(defn visliste [todos]
  (prn @todos)
  [:div
   (map (fn [val] ^{:key val}[:div val]) @todos)
   ])

(defn leggtilkontroller [todos]
  (let [tekst (r/atom nil)]
    [:div
     [:input {:type "text" :value @tekst :on-change #(reset! tekst %)}]
     [:input {:type "button" :value "legg til" :on-click #(swap! todos conj "fis")}
      ]]))



(defn app []
  (reset! todoliste-global ["Bajse" "Spise mat" "Rydde kjøkkenet"])
  [:div
   [visliste todoliste-global]
   [leggtilkontroller todoliste-global]
   ]
  )

(r/render [app]
          (.getElementById js/document "app"))
