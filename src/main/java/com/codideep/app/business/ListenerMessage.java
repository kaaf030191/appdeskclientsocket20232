/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author KAAF0
 */
public class ListenerMessage extends Thread {

    private DefaultListModel<String> modelListContentMessage;

    public ListenerMessage(DefaultListModel<String> modelListContentMessage) {
        this.modelListContentMessage = modelListContentMessage;
    }

    @Override
    public void run() {
        String host = "127.0.0.1";
        int port = 7777;
        Socket socket;
        String[] message;

        try {
            while(true) {
                socket = new Socket(host, port);

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                writer.println("listenerMessageXyz_:");

                message = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine().split("_MessageXYZMessage_");

                for (String element : message) {
                    modelListContentMessage.addElement(element);
                }

                socket.close();
                
                sleep(500);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ListenerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
