package com.gismo.carbon.proxy.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CarbonRequest {
    @JsonProperty("messages")
    private List<CarbonMessage> messages = null;

    public CarbonRequest() {
    }

    public List<CarbonMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<CarbonMessage> messages) {
        this.messages = messages;
    }
}
