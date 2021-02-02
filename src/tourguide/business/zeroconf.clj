(ns tourguide.business.zeroconf
  (:require [tourguide.core :as core])
  (:import (javax.jmdns JmDNS ServiceInfo)
           (java.net InetAddress)
           (java.util Collections Arrays)))

(defn get-jmdns [] (JmDNS/create (InetAddress/getLocalHost)))

(defn ServiceInfoProperties->Map [^ServiceInfo info]
  (let [props (.getPropertyNames info)]
    (reduce
      (fn [map prop]
        (assoc map (keyword prop) (.getPropertyString info prop)))
      {}
      (Collections/list props))))

(defn ServiceInfo->Service
  "converts a Service info to a Service record."
  [^ServiceInfo info]
  (core/->Service
    (.getType info)
    (.getName info)
    (.getDomain info)
    (Arrays/asList (.getHostAddresses info))
    (.getPort info)
    (ServiceInfoProperties->Map info)))
