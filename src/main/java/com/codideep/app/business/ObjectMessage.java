/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.business;

/**
 *
 * @author KAAF0
 */
public class ObjectMessage {

    private final String idMessage;
    private final String message;

    public ObjectMessage(String idMessage, String message) {
        this.idMessage = idMessage;
        this.message = message;
    }
    
    public String getIdMessage() {
        return idMessage;
    }
    
    public String getMessage() {
        return message;
    }
}
