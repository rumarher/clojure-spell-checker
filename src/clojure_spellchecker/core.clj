(ns clojure-spellchecker.core
  (:gen-class)
  (:require [clojure.string :as str])
  (:import (org.apache.commons.lang3 StringUtils)))

(def words
    (set (map str/trim (str/split-lines (slurp "resources/wordsEn.txt")))))

(defn distance [word1 word2]
  (StringUtils/getLevenshteinDistance word1 word2))

(defn min-distance [word]
  (apply min-key (partial distance word) words))

(defn correct? [word]
  (contains? words word))

(defn askIfCorrect [word]
  (if (correct? word)
    (println "The word: " word " is well written.")
    (println word " incorrect. Did you mean?" (min-distance word))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [word (first args)] 
    (askIfCorrect word))
)
