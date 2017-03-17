(defproject re-native-playground "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.9.0-alpha10"]
                           [org.clojure/clojurescript "1.9.473"]
                           [reagent "0.6.0" :exclusions [cljsjs/react cljsjs/react-dom cljsjs/react-dom-server]]
                           [re-frame "0.9.1"]
                           [re-native "0.41.2"]
                           [re-native/action-sheet "0.3.0"]
                           [re-native/blur "2.0.0"]
                           [re-native/cachable-image "1.5.1"]
                           [re-native/chart "1.0.8-beta"]
                           [re-native/datepicker "1.4.3"]
                           [re-native/image-picker "0.26.2"]
                           [re-native/navigation "1.0.0-beta.7"]
                           [re-native/progress "3.2.0"]
                           [re-native/splash-screen "2.0.0"]
                           [re-native/svg "5.1.2"]
                           [re-native/swiper "1.5.4"]]
            :plugins [[lein-cljsbuild "1.1.4"]
                      [lein-figwheel "0.5.8"]]
            :clean-targets ["target/" "index.ios.js" "index.android.js"]
            :aliases {"prod-build" ^{:doc "Recompile code with prod profile."}
                                   ["do" "clean"
                                    ["with-profile" "prod" "cljsbuild" "once"]]
                      "dev-build" ^{:doc "Recompile code with dev profile."}
                                  ["do" "clean"
                                   ["with-profile" "dev" "cljsbuild" "once"]]}
            :profiles {:dev {:dependencies [[figwheel-sidecar "0.5.8"]
                                            [com.cemerick/piggieback "0.2.1"]]
                             :source-paths ["src" "env/dev"]
                             :cljsbuild    {:builds [{:id           "ios"
                                                      :source-paths ["src" "env/dev"]
                                                      :figwheel     true
                                                      :compiler     {:output-to     "target/ios/not-used.js"
                                                                     :main          "env.ios.main"
                                                                     :output-dir    "target/ios"
                                                                     :optimizations :none}}
                                                     {:id           "android"
                                                      :source-paths ["src" "env/dev"]
                                                      :figwheel     true
                                                      :compiler     {:output-to     "target/android/not-used.js"
                                                                     :main          "env.android.main"
                                                                     :output-dir    "target/android"
                                                                     :optimizations :none}}]}
                             :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}
                       :prod {:cljsbuild {:builds [{:id           "ios"
                                                    :source-paths ["src" "env/prod"]
                                                    :compiler     {:output-to     "index.ios.js"
                                                                   :main          "env.ios.main"
                                                                   :output-dir    "target/ios"
                                                                   :static-fns    true
                                                                   :optimize-constants true
                                                                   :optimizations :simple
                                                                   :closure-defines {"goog.DEBUG" false}}}
                                                   {:id            "android"
                                                    :source-paths ["src" "env/prod"]
                                                    :compiler     {:output-to     "index.android.js"
                                                                   :main          "env.android.main"
                                                                   :output-dir    "target/android"
                                                                   :static-fns    true
                                                                   :optimize-constants true
                                                                   :optimizations :simple
                                                                   :closure-defines {"goog.DEBUG" false}}}]}}})
