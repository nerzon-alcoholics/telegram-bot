package ru.nerzon.alcoholics.telegrambot.config;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "datasource")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersistenceConfigurationProperties {

    private String url;

    private String userName;

    private String password;

    private String driver;

    private String dialect;

    private String[] basePackages;

}
