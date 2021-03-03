package com.wzx.message;

public enum MessageType {
    REQUEST("request"),RETRY("retry"),REDIRECT("redirect"),RESPONSE("response");
    private String type;
    MessageType(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
