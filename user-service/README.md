## 1. eureka client server 설정

- service discovery 에 등록하기 위한 설정


### (1) dependencies (maven)
```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>user-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>user-service</name>
    <description>user-service</description>
    <properties>
        <java.version>11</java.version>
        <spring-cloud.version>2021.0.3</spring-cloud.version>
    </properties>
    <dependencies>
    
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
    
    </dependencies>

```

1. `spring-cloud-starter-netflix-eureka-client`

   - Eureka Server Discovery 에 등록할 클라이언트 서버로 등록하기 위한 의존성.
   - 각 서버가 등록된 서비스에 대한 상태를 다른 서버에 복제하여 서버를 고가용성으로 구성 및 배포할 수 있는 것이 장점

<br>

### (2) application.yml

```yaml
server:
  port: 9001

spring:
  application:
    name: user-service

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka
```

`eureka.service-url.defaultZone`

- service discovery server 에 등록할 서버의 URL을 설정
- `defaultZone` 속성은 대소문자를 구분하고 작성 시 **카멜케이스로 명시**하는 것이 좋다. EurekaClientConfigBean 에서 service-url을 설정할 때,
    Map<String, String> 형태로 저장하기 때문이다.
  - `EurekaClientConfigBean` 
    ```java
    import com.netflix.discovery.EurekaClientConfig;
    import org.springframework.core.Ordered;
    import org.springframework.boot.context.properties.ConfigurationProperties;
  
    import static org.springframework.cloud.netflix.eureka.EurekaConstants.DEFAULT_PREFIX;
  
    @ConfigurationProperties(EurekaClientConfigBean.PREFIX)
    public class EurekaClientConfigBean implements EurekaClientConfig, Ordered {
    
      private Map<String, String> serviceUrl = new HashMap<>();
  
      public void setServiceUrl(Map<String, String> serviceUrl) {
            this.serviceUrl = serviceUrl;
      }
    }
    ```

### Reference

- [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
