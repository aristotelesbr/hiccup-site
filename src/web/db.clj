(ns web.db
  (:require [next.jdbc.sql :as sql]))

(def db {:dbtype "h2" :dbname "./my-db"})

(defn add-post
  [title body]
  (let [results (sql/insert! db :posts {:title title :body body})]
    (assert (and (map? results) (:POSTS/ID results)))))

(defn posts
  []
  (sql/query db ["select * from posts"]))

(comment 
  (posts)
  ;; => [#:POSTS{:ID 1, :TITLE "Hello" "World"}]
)