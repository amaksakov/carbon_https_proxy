package com.gismo.carbon.proxy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${carbon.host:}")
    private String graphiteCarbonHost;

    @Value("${carbon.port:443}")
    private String graphiteCarbonPort;

    public String getCarbonHost() { return graphiteCarbonHost; }

    public int getCarbonPort() {
        try {
            return Integer.parseInt(graphiteCarbonPort);
        } catch (Exception ex) {
            return 443;
        }
    }
}