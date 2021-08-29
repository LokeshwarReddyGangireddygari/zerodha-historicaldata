package com.lokesh.history.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@ConfigurationProperties
@Data
public class Config {
    private String apiKey;

    private String clientSecret;

    private String userId;

    private Date availableHistoricalDataFrom;
}
