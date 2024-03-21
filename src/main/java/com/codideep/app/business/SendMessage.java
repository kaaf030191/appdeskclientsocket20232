/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author KAAF0
 */
public class SendMessage {

    public static void writeMessage(String message) {
        String host = "127.0.0.1";
        int port = 7777;
        Socket socket;

        try {
            socket = new Socket(host, port);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("sendMessageXyz_:" + message);

            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
