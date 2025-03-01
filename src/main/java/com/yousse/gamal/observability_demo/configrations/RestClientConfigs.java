package com.yousse.gamal.observability_demo.configrations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.yousse.gamal.observability_demo.integrations.JsonPlaceHolderRestClient;



@Configuration
public class RestClientConfigs {


    @Bean
    public JsonPlaceHolderRestClient jsonPlaceHolderRestClient(@Value("${integrations.jsonplaceholder.base-url}") String baseUrl) {
        RestClient restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();
        
        return httpServiceProxyFactory.createClient(JsonPlaceHolderRestClient.class);
    }
}
