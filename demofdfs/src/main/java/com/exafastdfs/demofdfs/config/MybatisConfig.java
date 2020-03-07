package com.exafastdfs.demofdfs.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//作用：mybatis对注解方式的sql语句,驼峰命名法自动匹配，比如Bean中字段名是sonName,数据库中的名字可以是son_name，查询出来以后可以自动匹配到bean中
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {

            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
