(ns todolist.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            ))

(enable-console-print!)

(rf/reg-event-db :initialize
                 (fn [_ _]
                   {:todos ["Bajse" "Spise mat"]
                    :derp  {}}))

(rf/reg-event-db :add-todo-item
  (fn [db [_ new-todo-item]]
    (prn "skal legge til " new-todo-item)
    (assoc db :todos (conj (:todos db) new-todo-item))))

(rf/reg-sub :todo-items
  (fn [db _]
    (:todos db)))

(defn visliste [todos]
  (prn todos)
  [:div
   (map (fn [val] ^{:key val} [:div val]) todos)])

(defn leggtilkontroller []
  [:div
   [:input {:type "text"
            :on-key-press (fn [e]
                            (if (= 13 (.-charCode e))
                              (do
                                (rf/dispatch [:add-todo-item (-> e .-target .-value)])
                                (set! (-> e .-target .-value) ""))))}]])

(defn app []
  [:div
   [visliste @(rf/subscribe [:todo-items])]
   [leggtilkontroller]])

(r/render [app]
          (.getElementById js/document "app"))

(rf/dispatch [:initialize])
