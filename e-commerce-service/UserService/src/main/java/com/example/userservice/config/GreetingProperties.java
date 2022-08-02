package com.example.userservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
//@RequiredArgsConstructor /* 불변일 경우, 적용 */
//@ConstructorBinding
@ConfigurationProperties(prefix = "greeting")
public class GreetingProperties {

    private String message;

}
