/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.commun;

/**
 *
 * @author abbasturki.elias
 */
public class Message {
    
     private String message;
    //lvl error,success,worning
    private String lvl;
    //code == 200 success,code == 500 error
    private int code;

    public Message(String message, String lvl, int code) {
        this.message = message;
        this.lvl = lvl;
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
