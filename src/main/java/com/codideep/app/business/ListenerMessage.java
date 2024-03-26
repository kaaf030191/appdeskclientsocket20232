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
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author KAAF0
 */
public class ListenerMessage extends Thread {

    List<String> listMessage = new ArrayList<>();
    private DefaultListModel<String> modelListContentMessage;
    private JList listContentMessage;

    public ListenerMessage(DefaultListModel<String> modelListContentMessage, JList listContentMessage) {
        this.modelListContentMessage = modelListContentMessage;
        this.listContentMessage = listContentMessage;
    }

    @Override
    public void run() {
        String host = "127.0.0.1";
        int port = 7777;
        Socket socket;
        String[] message;
        boolean existsMessage;

        try {
            while (true) {
                socket = new Socket(host, port);

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                writer.println("listenerMessageXyz_");

                message = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine().split("_MessageXYZMessage_");

                if (!message[0].isEmpty()) {
                    for (String element : message) {
                        existsMessage = false;

                        for (String item : listMessage) {
                            if (element.split("__SEPID__")[0].equals(item.split("__SEPID__")[0])) {
                                existsMessage = true;
                            }
                        }

                        if (!existsMessage) {
                            listMessage.add(element);
                            modelListContentMessage.addElement(element.split("__SEPID__")[1]);

                            listContentMessage.ensureIndexIsVisible((listMessage.isEmpty() ? 1 : listMessage.size()) - 1);
                        }
                    }
                }

                socket.close();

                sleep(100);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ListenerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
