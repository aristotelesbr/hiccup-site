(ns web.views
  (:require [hiccup.page :as page]
            [web.db :as db]))

(defn gen-page-head
  [title]
  [:head
   [:title (str "Blog " title)]
   (page/include-css "/css/styles.css")])

(def header-links
  [:div#header-links
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/add-post"} "Add a new post"]
   " | "
   [:a {:href "/posts"} "View all posts"]])

(defn home-page
  []
  (page/html5
   (gen-page-head "Home")
   header-links
   [:h1 "Home"]
   [:p "Welcome to the home page!"]))

(defn posts
  []
  (let [posts (db/posts)]
    (page/html5
     (gen-page-head "All Posts")
     header-links
     [:h1 "📚 All Posts"]
     [:table
      [:tr [:th "ID"] [:th "Title"]]
      (for [post posts]
        [:tr
         [:td (:POSTS/ID post)]
         [:td (:POSTS/TITLE post)]])])))