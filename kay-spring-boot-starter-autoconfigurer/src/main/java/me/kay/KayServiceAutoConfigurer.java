package me.kay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(KayProperties.class)
public class KayServiceAutoConfigurer {

    @Autowired
    KayProperties kayProperties;

    @Bean
    public KayService kayService(){
        KayService kayService = new KayService();
        kayService.setKayProperties(kayProperties);
        return kayService;
    }
}
