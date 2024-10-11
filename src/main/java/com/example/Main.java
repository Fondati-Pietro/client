package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownError, UnknownHostException, IOException{
        System.out.println("Client partito");

        Socket server = new Socket("localhost", 3000);

        System.out.println("Client collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        out.writeBytes("ciao" + '\n');

        String stringaRicevuta = in.readLine();
        System.out.println("Stringa ricevuta: " + stringaRicevuta);

        server.close();
    }
}