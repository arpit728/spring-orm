package com.acecademy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan
@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean("dataSource")
    DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/acecademy", "root", "123456789");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean("hibernateProperties")
    Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernateDialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean("annotedClasses")
    Class<?>[] getAnnotatedClasses() {
        return new Class[]{com.acecademy.entity.Student.class};
    }

    @Bean("sessionFactory")
    LocalSessionFactoryBean getSessionFactory(DataSource dataSource, Properties hibernateProperties, Class<?>[] annotedClasses) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setAnnotatedClasses(annotedClasses);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean;
    }

    @Bean("hibernateTemplate")
    HibernateTemplate getHibernateTemplate(LocalSessionFactoryBean sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory.getObject());
        return hibernateTemplate;
    }

    @Bean("txnManager")
    HibernateTransactionManager getTransactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager txnManager = new HibernateTransactionManager();
        txnManager.setSessionFactory(sessionFactory.getObject());
        return txnManager;
    }
}
