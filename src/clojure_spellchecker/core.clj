(ns clojure-spellchecker.core
  (:gen-class)
  (:require [clojure.string :as str]))

(def words
    (set (map str/trim (str/split-lines (slurp "resources/wordsEn.txt")))))


(defn correct? [word]
  (contains? words word))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
)
