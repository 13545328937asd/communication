package com.wzx.message;

import com.wzx.message.builder.CommunicationMessageBuilder;

public class ObjectInfoBook {
    public  static class Order{
        public static class OrderManager{
            public static CommunicationMessage getOrder(String orderId){
                return new ResponseMessage(new CommunicationMessageBuilder());
            }
        }
    }
    public
}
