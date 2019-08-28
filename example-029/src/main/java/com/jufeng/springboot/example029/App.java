package com.jufeng.springboot.example029;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Supplier;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private  RestTemplate restTemplate;


    @Bean
    public RestTemplate initRestTemplate(RestTemplateBuilder restTemplateBuilder){
        //HttpComponentsClientHttpRequestFactory
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(4000))
                .requestFactory(SimpleClientHttpRequestFactory.class)  // http 请求工厂
                .errorHandler(new ResponseErrorHandler() {
                    @Override
                    public boolean hasError(ClientHttpResponse response) throws IOException {
                        return true;
                    }

                    @Override
                    public void handleError(ClientHttpResponse response) throws IOException {
                        System.out.println(response.getStatusText());
                    }
                }).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String res = restTemplate.getForObject("http://www.baidu.com/xxx",String.class);
        System.out.println(res);
    }
}