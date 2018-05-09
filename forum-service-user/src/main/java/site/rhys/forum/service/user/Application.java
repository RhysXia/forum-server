package site.rhys.forum.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import site.rhys.forum.service.user.api.model.User;
import site.rhys.forum.service.user.mapper.UserMapper;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/09 16:44
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("site.rhys.forum.service.user.mapper")
@RestController
public class Application {
    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userMapper.selectById(id);
    }
}
