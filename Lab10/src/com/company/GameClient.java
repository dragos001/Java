package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        while(true) {
            System.out.println(">");
            String command = keyboard.readLine();
            out.println(command);
            if(command.equals("exit")) {
                System.out.println("Client stopped");
                break;}
            if(command.equals("stop")) {
                System.out.println("Server stopped");
                break;}
            String serverResponse = input.readLine();
            System.out.println("[Client]" + serverResponse);
        }
        socket.close();
        System.exit(0);
    }


}
