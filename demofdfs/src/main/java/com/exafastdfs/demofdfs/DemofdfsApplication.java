package com.exafastdfs.demofdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Import;

import javax.servlet.MultipartConfigElement;

@MapperScan(value = "com.exafastdfs.demofdfs.Mapper")
@Import(FdfsClientConfig.class)
@SpringBootApplication
public class DemofdfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemofdfsApplication.class, args);
    }

}
