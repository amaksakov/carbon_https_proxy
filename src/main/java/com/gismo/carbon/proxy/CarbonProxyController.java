package com.gismo.carbon.proxy;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.gismo.carbon.proxy.model.CarbonMessage;
import com.gismo.carbon.proxy.model.CarbonRequest;
import com.gismo.carbon.proxy.utils.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

@RestController
public class CarbonProxyController {

    @Autowired
    private AppConfig appConfig;

    private Graphite graphite;

    @PostConstruct
    public void init() {
        graphite = new Graphite(new InetSocketAddress(appConfig.getCarbonHost(),
                appConfig.getCarbonPort()));

    }

    @RequestMapping(
            value = "/proxy",
            method = {RequestMethod.POST},
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {"application/json"}
    )
    public String sendMetric(@RequestBody CarbonRequest request) throws IOException {
        if (!graphite.isConnected()) {
            graphite.connect();
        }
        for (CarbonMessage carbonMessage: request.getMessages()) {
            graphite.send(carbonMessage.getName(), carbonMessage.getValue(), carbonMessage.getTimestamp());
        }
        graphite.flush();
        return "{\"message\": \"OK\"}";
    }
    
}
