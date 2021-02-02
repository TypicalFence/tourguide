(ns tourguide.business.zeroconf-test
  (:require [clojure.test :refer :all]
            [tourguide.business.zeroconf :refer :all])
  (:import (javax.jmdns ServiceInfo)))

(def aServiceInfo (ServiceInfo/create "_mpd" "MPD Server"
                                      80 10 15
                                      {"path" "/my/path" "signature" "cool signature"}))

(deftest ServiceInfoProperties->Map-test
  (testing "should work"
    (let [map (ServiceInfoProperties->Map aServiceInfo)]
      (is (= (:path map) "/my/path"))
      (is (= (:signature map) "cool signature")))))

(deftest ServiceInfo->Service-test
  (let [service (ServiceInfo->Service aServiceInfo)]
    (testing "has correct type"
      (is (= "_mpd._tcp.local." (:type service))))
    (testing "has correct name"
      (is (= "MPD Server" (:name service))))
    (testing "has correct domain"
      (is (= "local" (:domain service))))
    (testing "has correct host"
      (is (= [] (:host service))))
    (testing "has correct port"
      (is (= (:port "service"))))
    (testing "has correct txt"
      (is (= (-> service :txt :path) "/my/path"))
      (is (= (-> service :txt :signature) "cool signature")))))
