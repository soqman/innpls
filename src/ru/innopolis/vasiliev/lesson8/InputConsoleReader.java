package ru.innopolis.vasiliev.lesson8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class InputConsoleReader implements Runnable {
    Socket socket;
    String message;
    Scanner scanner =new Scanner(System.in);

    public InputConsoleReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStreamWriter serverOutput = new OutputStreamWriter((socket.getOutputStream()));
            while((message=scanner.nextLine())!=null){
                BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
