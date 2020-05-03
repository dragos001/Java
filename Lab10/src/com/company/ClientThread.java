package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread implements Runnable {
    private final Socket client;
    private final BufferedReader in;
    private  static ArrayList<ClientThread> clients;
    private final PrintWriter out;

    public ClientThread(Socket clientSocket, ArrayList<ClientThread> clients ) throws IOException {
        this.client = clientSocket;
        ClientThread.clients =clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(),true);

    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                if (request.equals("stop")) {
                    this.client.close();
                    System.out.println("[SERVER] Server oprit ");
                    try {
                        // closing resources
                        this.in.close();
                        this.out.close();
                    } catch(IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
                System.out.println("[SERVER] Am primit comanda " + request);
                out.println(request);
            }
        } catch (IOException e) {
            System.err.println("IO exception in clientThread");
            e.printStackTrace();
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}