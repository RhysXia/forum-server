package site.rhys.forum.service.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:44
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = {"site.rhys.forum"})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("site.rhys.forum.service.auth.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
