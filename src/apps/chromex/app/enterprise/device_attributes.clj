(ns chromex.app.enterprise.device-attributes
  "Use the chrome.enterprise.deviceAttributes API to read device
   attributes.
   Note: This API is only available to extensions force-installed by enterprise policy.

     * available since Chrome 46
     * https://developer.chrome.com/apps/enterprise.deviceAttributes"

  (:refer-clojure :only [defmacro defn apply declare meta let partial])
  (:require [chromex.wrapgen :refer [gen-wrap-helper]]
            [chromex.callgen :refer [gen-call-helper gen-tap-all-events-call]]))

(declare api-table)
(declare gen-call)

; -- functions --------------------------------------------------------------------------------------------------------------

(defmacro get-directory-device-id
  "Fetches the value of the device identifier of the directory API, that is generated by the server and identifies the cloud
   record of the device for querying in the cloud directory API. If the current user is not affiliated, returns an empty
   string.

   This function returns a core.async channel of type `promise-chan` which eventually receives a result value.
   Signature of the result value put on the channel is [device-id] where:

     |device-id| - https://developer.chrome.com/apps/enterprise.deviceAttributes#property-callback-deviceId.

   In case of an error the channel closes without receiving any value and relevant error object can be obtained via
   chromex.error/get-last-error.

   https://developer.chrome.com/apps/enterprise.deviceAttributes#method-getDirectoryDeviceId."
  ([] (gen-call :function ::get-directory-device-id &form)))

(defmacro get-device-serial-number
  "Fetches the device's serial number. Please note the purpose of this API is to administrate the device (e.g. generating
   Certificate Sign Requests for device-wide certificates). This API may not be used for tracking devices without the consent
   of the device's administrator. If the current user is not affiliated, returns an empty string.

   This function returns a core.async channel of type `promise-chan` which eventually receives a result value.
   Signature of the result value put on the channel is [serial-number] where:

     |serial-number| - https://developer.chrome.com/apps/enterprise.deviceAttributes#property-callback-serialNumber.

   In case of an error the channel closes without receiving any value and relevant error object can be obtained via
   chromex.error/get-last-error.

   https://developer.chrome.com/apps/enterprise.deviceAttributes#method-getDeviceSerialNumber."
  ([] (gen-call :function ::get-device-serial-number &form)))

(defmacro get-device-asset-id
  "Fetches the administrator-annotated Asset Id. If the current user is not affiliated or no Asset Id has been set by the
   administrator, returns an empty string.

   This function returns a core.async channel of type `promise-chan` which eventually receives a result value.
   Signature of the result value put on the channel is [asset-id] where:

     |asset-id| - https://developer.chrome.com/apps/enterprise.deviceAttributes#property-callback-assetId.

   In case of an error the channel closes without receiving any value and relevant error object can be obtained via
   chromex.error/get-last-error.

   https://developer.chrome.com/apps/enterprise.deviceAttributes#method-getDeviceAssetId."
  ([] (gen-call :function ::get-device-asset-id &form)))

(defmacro get-device-annotated-location
  "Fetches the administrator-annotated Location. If the current user is not affiliated or no Annotated Location has been set
   by the administrator, returns an empty string.

   This function returns a core.async channel of type `promise-chan` which eventually receives a result value.
   Signature of the result value put on the channel is [annotated-location] where:

     |annotated-location| - https://developer.chrome.com/apps/enterprise.deviceAttributes#property-callback-annotatedLocation.

   In case of an error the channel closes without receiving any value and relevant error object can be obtained via
   chromex.error/get-last-error.

   https://developer.chrome.com/apps/enterprise.deviceAttributes#method-getDeviceAnnotatedLocation."
  ([] (gen-call :function ::get-device-annotated-location &form)))

(defmacro get-device-hostname
  "Fetches the device's hostname as set by DeviceHostnameTemplate policy. If the current user is not affiliated or no hostname
   has been set by the the enterprise policy, returns an empty string.

   This function returns a core.async channel of type `promise-chan` which eventually receives a result value.
   Signature of the result value put on the channel is [hostname] where:

     |hostname| - https://developer.chrome.com/apps/enterprise.deviceAttributes#property-callback-hostname.

   In case of an error the channel closes without receiving any value and relevant error object can be obtained via
   chromex.error/get-last-error.

   https://developer.chrome.com/apps/enterprise.deviceAttributes#method-getDeviceHostname."
  ([] (gen-call :function ::get-device-hostname &form)))

; -- convenience ------------------------------------------------------------------------------------------------------------

(defmacro tap-all-events
  "Taps all valid non-deprecated events in chromex.app.enterprise.device-attributes namespace."
  [chan]
  (gen-tap-all-events-call api-table (meta &form) chan))

; ---------------------------------------------------------------------------------------------------------------------------
; -- API TABLE --------------------------------------------------------------------------------------------------------------
; ---------------------------------------------------------------------------------------------------------------------------

(def api-table
  {:namespace "chrome.enterprise.deviceAttributes",
   :since "46",
   :functions
   [{:id ::get-directory-device-id,
     :name "getDirectoryDeviceId",
     :callback? true,
     :params [{:name "callback", :type :callback, :callback {:params [{:name "device-id", :type "string"}]}}]}
    {:id ::get-device-serial-number,
     :name "getDeviceSerialNumber",
     :since "66",
     :callback? true,
     :params [{:name "callback", :type :callback, :callback {:params [{:name "serial-number", :type "string"}]}}]}
    {:id ::get-device-asset-id,
     :name "getDeviceAssetId",
     :since "66",
     :callback? true,
     :params [{:name "callback", :type :callback, :callback {:params [{:name "asset-id", :type "string"}]}}]}
    {:id ::get-device-annotated-location,
     :name "getDeviceAnnotatedLocation",
     :since "66",
     :callback? true,
     :params [{:name "callback", :type :callback, :callback {:params [{:name "annotated-location", :type "string"}]}}]}
    {:id ::get-device-hostname,
     :name "getDeviceHostname",
     :since "82",
     :callback? true,
     :params [{:name "callback", :type :callback, :callback {:params [{:name "hostname", :type "string"}]}}]}]})

; -- helpers ----------------------------------------------------------------------------------------------------------------

; code generation for native API wrapper
(defmacro gen-wrap [kind item-id config & args]
  (apply gen-wrap-helper api-table kind item-id config args))

; code generation for API call-site
(def gen-call (partial gen-call-helper api-table))