package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownError, UnknownHostException, IOException{
        System.out.println("Client partito");

        Socket server = new Socket("localhost", 3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        System.out.println("Client collegato");

        String stringaRicevuta;
        String stringaMaiuscola;
        
        do {
            System.out.println("Scrivi qualcosa");
            Scanner myScan = new Scanner(System.in);
            stringaMaiuscola = myScan.nextLine();

            out.writeBytes("ciao" + '\n');
    
            if(stringaMaiuscola.equals("!")){
                System.out.println("STOP");
                break;
            }

            System.out.println("Stringa ricevuta: " + stringaMaiuscola);
            
            stringaRicevuta = in.readLine();
            System.out.println(stringaRicevuta);

        } while (stringaRicevuta.equals("!"));
        
        server.close();
    }
}