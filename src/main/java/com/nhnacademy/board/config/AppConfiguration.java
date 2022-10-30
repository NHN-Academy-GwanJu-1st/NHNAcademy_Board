package com.nhnacademy.board.config;


import com.nhnacademy.board.repository.PostRepository;
import com.nhnacademy.board.repository.PostRepositoryImpl;
import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.board")
public class AppConfiguration {

    @Bean(name = "userRepository")
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean(name = "postRepository")
    public PostRepository postRepository() {
        return new PostRepositoryImpl();
    }
}
