package com.gismo.carbon.proxy.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarbonMessage {
    @JsonProperty("name")
    final String name;
    @JsonProperty("value")
    final String value;
    @JsonProperty("timestamp")
    final long timestamp;

    @JsonCreator
    public CarbonMessage(@JsonProperty("name")String name,
                         @JsonProperty("value") String value,
                         @JsonProperty("timestamp") long timestamp) {
        this.name = name;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }
}