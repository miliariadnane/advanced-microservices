## 1. Self-Preservation in Service Discovery Pattern 
- 
- Eureka use `self-preservation` mode to protect itself from the network failure (avoid traps in the network). When the network is unstable, the heartbeat will be failed and Eureka server will mark the instance as DOWN. 
- Self-preservation refers to the ability of a **single service** to continue functioning even in the face of failures or disruptions. This can be achieved through various strategies such as load balancing, failover, and replication 
- If the Eureka server is in the self-preservation mode, it will not mark the instance as DOWN, and the client will not be able to get the instance information (will not send requests to the instance), which will reduce the pressure on the instance. 
- ALso, if a service becomes unavailable, self-preservation mechanisms can be used to redirect traffic to a replica of the service or to a backup service that can take over its responsibilities. This helps to maintain the availability and reliability of the overall system. 

````yaml
#Eureka-Client
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
    fetch-registry: true
    register-with-eureka: true
  #self-preservation
  instance:
    lease-renewal-interval-in-seconds: 30 # default 30 ms
    # indicates the frequency (in seconds) at which the client sends heartbeats to the server indicating that it's still alive
    lease-expiration-duration-in-seconds: 90 # default 90 ms
    # indicates the duration that the server waits for a heartbeat before it removes this instance from its view of the registry
  server:
    eviction-interval-timer-in-ms: 60000 # 60 seconds (60 * 1000)
    # indicates the frequency (in milliseconds) at which the server checks for instances that have not renewed their leases and removes them from the registry
    renewal-percent-threshold: 0.85 # default 0.85
    # this value is used to calculate the expected % of heartbeats per minute eureka expects from all clients
    renewal-threshold-update-interval-ms: 900000 # 900 seconds (15 * 60 * 1000)
    # A scheduled task runs every 900 seconds to update the threshold
    enable-self-preservation: true # default true
````

`Note:` The self-preservation mode is triggered when the number of available instances is less than 85% of the total number of instances, and it will be turned off when the number of available instances is greater than 95% of the total number of instances. 

- resources : 
  * [link1](https://medium.com/javarevisited/the-mystery-of-eureka-self-preservation-f2db91454f2d) 
  * [link2](https://www.baeldung.com/eureka-self-preservation-renewal)
