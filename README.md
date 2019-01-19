# api-gateway
SpringBoot 2.1.2-release + zuul as api-gateway. Basic usage.

## zuul configurations

``` 
server.port=9000
spring.application.name=api-gateway
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

#增加路由规则的配置
#通过zuul.routes.<route>.path和zuul.routes.<route>.url进行配置，<route>为路由的名字，可以任意指定，但是一组path和url的路由名要相同
#如下面的例子：所有满足/hello/** 规则的访问都会被路由转发到//localhost:9001的地址
#也就是说，我们访问http://localhost:9000/hello/hello的时候，API网关服务就会将该请#求路由到 http://localhost:9001/hello提供的微服务接口上
#stripPrefix是前缀开关，true忽略前缀，false必须写前缀。

#第一种形式，命名id，指定path，路由到service-id指定的eureka中的服务名hello-service
zuul.routes.hello-api.path=/hello/**
zuul.routes.hello-api.service-id=hello-service
#zuul.routes.hello-api.url=http://localhost:9001
zuul.routes.hello-api.stripPrefix=true

#第二种形式，命名id，指定path，路由到url指定的地址。此时，stripPrefix固定为false，人工设置无效。
zuul.routes.world-api.path=/world-api/**
#zuul.routes.world-api.service-id=world-service
zuul.routes.world-api.url=http://localhost:9002
zuul.routes.world-api.stripPrefix=true

#第三种形式，当id,path,service-id相同时，zuul默认配置了如下形式，因此可以省略配置。
#zuul.routes.consumer.path=/consumer/**
#zuul.routes.consumer.service-id=consumer
#zuul.routes.consumer.url=http://localhost:9003
#zuul.routes.consumer.stripPrefix=true

#第四种形式，使用url做路由时，不去注册中心寻找服务，只做简单的网关。这种情形下，不能做负载均衡。
zuul.routes.baidu.path=/baidu/**
zuul.routes.baidu.url=https://www.baidu.com
zuul.routes.baidu.stripPrefix=false

zuul.routes.github.path=/github/**
zuul.routes.github.url=https://github.com
zuul.routes.github.stripPrefix=false

zuul.routes.sitexa.path=/sitexa/**
zuul.routes.sitexa.url=http://www.sitexa.cn
zuul.routes.sitexa.stripPrefix=false
```
