package org.tyndalebt.spadv.model.messaging;

/**
 * Created by annmcostantino on 4/7/2018.
 */

public class Message {
    private boolean fromPhone;
    private String message;

    public Message(boolean b, String m){
        fromPhone = b;
        message = m;
    }

    public boolean isFromPhone(){
        return fromPhone;
    }

    public String getMessage(){
        return message;
    }
}
