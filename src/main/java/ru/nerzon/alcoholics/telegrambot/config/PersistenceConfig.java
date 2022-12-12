package ru.nerzon.alcoholics.telegrambot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {
    private final PersistenceConfigurationProperties configurationProperties;

    @Autowired
    public PersistenceConfig(PersistenceConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    @Bean
    public DataSource dataSource() {
        // Создаем DataSource (описание источника данных, в нашем случае - реляционную БД)
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(configurationProperties.getDriver());
        dataSource.setUsername(configurationProperties.getUserName());
        dataSource.setPassword(configurationProperties.getPassword());
        dataSource.setUrl(configurationProperties.getUrl());

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // Создаем FactoryBean для EntityManagerFactory
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(configurationProperties.getBasePackages());

        // Делаем VendorAdapter JPA в виде Hibernate
        var vendorAdapter = new HibernateJpaVendorAdapter();
        // Устанавливаем диалект
        vendorAdapter.setDatabasePlatform(configurationProperties.getDialect());

        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // Делаем TransactionManager для поддержки JTA @Transactional аннотации
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        // Делаем TransactionalPostProcessor для поддержки JTA
        return new PersistenceExceptionTranslationPostProcessor();
    }
}