package com.zhuoyue.config;

import com.zhuoyue.api.domain.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Tomasz Kucharzyk
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfig {
    @Bean(name = "auditorProvider" )
    public AuditorAware<User> auditorProvider() {
        return () -> null;
    }
}
