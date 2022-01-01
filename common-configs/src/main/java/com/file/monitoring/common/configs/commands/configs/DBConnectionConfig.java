package com.file.monitoring.common.configs.commands.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConnectionConfig {

    @Bean
    @ConfigurationProperties(prefix = "temp-db1-admin.datasource")
    public DataSource tempDB1AdminDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("tempDB1Admin")
    public JdbcTemplate tempDB1AdminJdbcTemplate(
            @Qualifier("tempDB1AdminDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean
    @ConfigurationProperties(prefix = "temp-db2-admin.datasource")
    public DataSource tempDB2AdminDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("tempDB2Admin")
    public JdbcTemplate tempDB2AdminJdbcTemplate(
            @Qualifier("tempDB2AdminDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
