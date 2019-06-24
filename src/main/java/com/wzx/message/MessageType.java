package com.wzx.message;

public enum MessageType {
    REQUEST("request"),TELL("tell"),SPEAK("speak"),RESPONSE("response");
    private String type;
    MessageType(String type){
        this.type=type;
    }
}
