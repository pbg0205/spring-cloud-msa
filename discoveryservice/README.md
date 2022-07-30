## 1. Spring Cloud Netfilx Eureka

`Service Discovery`
  - 네트워크에서 서비스와 디바이스를 자동적으로 찾아주는 프로세스
  - 각각의 MicroService에 누가 저장되어 있고 특정 요청에 대해서 응답할 서비스 위치를 알려주는 역할

`API-Gateway`

- 다양한 소프트웨어 사이에서 발생하는 모든 요청을 해석하고 프로토콜(protocol)을 처리하는 역할
- 애플리케이션 및 마이크로서비스와 관련하여 다양한 요청들이 들어오는 진입점(연결지점) 역할
- MSA 에서 단일 엔드포인트를 해당 앱에 노출하여 개발자가 클라이언트 애플리케이션(Web, Mobile) 영역에 필요한 서비스를 쉽게 사용할 
  수 있도록 한다.
- API Gateway 의 접근성은 애플리케이션 접근성에 매우 중요한다.(e.g. 버전 관리, 동적 조정, DDos 보호, 트랜잭션 로그)

`Load Balancer`

- 서버를 수평 확장(scale out) 형태의 서비스에서 요청을 분산하는데 사용한다.

## 2. Eureka Service config

### (1) pom.xml

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>discoveryservice</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>discoveryservice</name>
    <properties>
        <java.version>11</java.version>
        <spring-cloud.version>2021.0.3</spring-cloud.version> <!-- spring boot 2.7.2에 맞는 설정 -->
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>
```

### (2) application.yml

``` yaml
# 1. 실행할 서버 설정포트
# 설정 패키지: org.springframework.boot.autoconfigure.web.ServerProperties
server:
  port: 8761 # 

# 2. springboot에서 서비스의 고유한 ID를 설정하는 부분
# - org.springframework.boot.context.ContextIdApplicationContextInitializer 에서 적용됨

spring:
  application:
    name: discoveryservice

# 3. eureka client 설정
# - client 설정하는 이유 : eureka library 포함된 채 springboot가 기동이 되면
#   eureka client 역할로서 서비스를 등록하는 작업이 시작된다.

# eureka.client.register-with-eureka (default value = true)
# - 해당 인스턴스가 다른 사용자가 검색할 수 있도록 해당 정보를 유레카 서버에 등록해야 하는지 여부를 나타내는 플래그 변수
# - org.springframework.cloud.netflix.eureka.EurekaClientConfigBean 에서 설정

# eureka.client.fetch-registry (default value = true)
# - 해당 인스턴스가 다른 사용자가 검색할 수 있도록 해당 정보를 유레카 서버에 등록해야 하는지 여부를 나타내는 플래그 변수
# - org.springframework.cloud.netflix.eureka.EurekaClientConfigBean 에서 설정

<br>


eureka:
  client:
    register-with-eureka: false 
    fetch-registry: false

```

### Reference

- [[L7 Defense] API Gateway vs Load Balancer](https://www.l7defense.com/cyber-security/api-gateway-vs-load-balancer/)
- [[AVI] Service Discovery Definition](https://avinetworks.com/glossary/service-discovery/)

