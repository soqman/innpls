package ru.innopolis.vasiliev.lesson8;

import java.io.*;
import java.net.Socket;


public class Client {
    private static InputConsoleReader inputConsoleReader;
    private static InputSocketReader inputSocketReader;

    void getConnect(){
        Socket socket=null;
        try {
            socket = new Socket("127.0.0.1",Server.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputConsoleReader=new InputConsoleReader(socket);
        inputSocketReader=new InputSocketReader(socket);
        Thread threadConsole = new Thread(inputConsoleReader);
        threadConsole.start();
        Thread threadSocket = new Thread(inputSocketReader);
        threadSocket.start();
    }
}
