package ru.innopolis.vasiliev.lesson8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Integer SERVER_PORT = 4999;
    private static InputSocketReader inputSocketReader;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket socket = serverSocket.accept();
            inputSocketReader=new InputSocketReader(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class InputSocketReader implements Runnable {
    String message;
    Socket socket;

    public InputSocketReader(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            InputStream fromClient = socket.getInputStream();
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
            while ((message = clientReader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}