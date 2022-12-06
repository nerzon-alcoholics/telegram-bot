package ru.nerzon.alcoholics.telegrambot.config;





import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "hibernate")
public class HibernateConfig {
    String connectionUrl;
    String connectionDriver;
    String connectionUsername;
    String connectionPassword;
    String dialect;
    String hbm2ddl;
    String showSql;
    String formatSql;
    public Properties getProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", this.connectionUrl);
        properties.setProperty("hibernate.connection.driver", this.connectionDriver);
        properties.setProperty("hibernate.connection.username", this.connectionUsername);
        properties.setProperty("hibernate.connection.password", this.connectionPassword);
        properties.setProperty("hibernate.dialect", this.dialect);
        properties.setProperty("hibernate.hbm2ddl", this.hbm2ddl);
        properties.setProperty("hibernate.show_sql", this.showSql);
        properties.setProperty("hibernate.format_sql", this.formatSql);
        return properties;
    }

}
