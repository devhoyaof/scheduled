package com.thread.scheduled.config;

import com.thread.scheduled.exception.CommonException;
import com.thread.scheduled.log.OmsResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataSourceConfig {

    private final String SEED = "nexgrid";


    @Bean
    public DataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
            dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/board-back");
            dataSource.setUsername("root");
            dataSource.setPassword("autoset");

            return dataSource;
        } catch (Exception e) {
            log.error("☆☆☆☆☆☆☆☆ Datasource Create Error : {} ☆☆☆☆☆☆☆☆", e.getMessage(), e);
            throw new CommonException(OmsResultCode.SERVICE_INTERNAL_ERROR);
        }
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath:mappers/*Mapper.xml");
        factoryBean.setMapperLocations(resources);

        Resource resource = new ClassPathResource("config/mybatis-config.xml");
        factoryBean.setConfigLocation(resource);

        return factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

}
