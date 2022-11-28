package ru.nerzon.alcoholics.telegrambot.config;


import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class HibernateConfig {
    private final Properties hibernateProperties = new Properties();

    public HibernateConfig(){
        hibernateProperties.setProperty("connection.url", "jdbc:postgresql://localhost:5432/localBot");
        hibernateProperties.setProperty("connection.driver_class", "org.postgresql.Driver");
        hibernateProperties.setProperty("connection.username", System.getenv("CONNECTION_USERNAME"));
        hibernateProperties.setProperty("connection.password", System.getenv("CONNCETION_PASSWORD"));
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hbm2ddl.auto", "update");
        hibernateProperties.setProperty("show_sql", "true");
        hibernateProperties.setProperty("format_sql", "true");
    }

    public Properties getHibernateProperties(){
        return this.hibernateProperties;
    }
}
