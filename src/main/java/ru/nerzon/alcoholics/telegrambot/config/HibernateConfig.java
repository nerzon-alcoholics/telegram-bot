package ru.nerzon.alcoholics.telegrambot.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@ConfigurationProperties(prefix = "hibernate.connection")
public class HibernateConfig {

    private String url;

    private String driver;

    private String username;

    private String password;

    private String dialect;

    private String hbm2ddl;

    private String showSql;

    private String formatSql;


    private final Properties hibernateProperties = new Properties();
    public HibernateConfig(){
        hibernateProperties.setProperty("connection.url", url);
        hibernateProperties.setProperty("connection.driver_class", driver);
        hibernateProperties.setProperty("connection.username", username);
        hibernateProperties.setProperty("connection.password", password);
        hibernateProperties.setProperty("dialect", dialect);
        hibernateProperties.setProperty("hbm2ddl.auto", hbm2ddl);
        hibernateProperties.setProperty("show_sql", showSql);
        hibernateProperties.setProperty("format_sql", formatSql);
    }

    public Properties getHibernateProperties(){
        return this.hibernateProperties;
    }
}
