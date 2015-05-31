(ns get-size.core
  (:gen-class)
  (require [clojure.java.io :as io]))

(defn size-entry
  [f]
  (if (.isDirectory f)
    (reduce + (map #(size-entry %) (.listFiles f)))
    (.length f)))

(defn -main
  [& args]
  (println (size-entry (io/file (or (first args) ".")))))
