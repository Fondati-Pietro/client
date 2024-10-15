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
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);

        System.out.println("Client collegato");

        String stringaRicevuta;
        String stringaFrase;
        String stringaScelta;
        boolean x;
        
        do {
            System.out.println("Scrivi qualcosa: ");
            stringaFrase = myScan.nextLine();
            out.writeBytes(stringaFrase + '\n');;

            while (x != true) {
                System.out.println('\n' + "Scrivi: " + '\n' + "-'M' per trasformare la parola in maiuscolo " + 
                '\n' + "-'m' per trasformare la parola in minuscolo " + '\n' + "-'rib' per ribaltare la stringa " + 
                '\n' + "-'count' per contare il nuemro dei caratteri " + '\n' + "-'esc' per chiudere" + '\n');
                stringaScelta = myScan2.nextLine();
                if (!stringaScelta.equals('M') || !stringaScelta.equals('m') || !stringaScelta.equals('rib') || !stringaScelta.equals('count') || !stringaScelta.equals('esc')) {
                    System.out.println("scelta errata, riprova" + '\n');
                    x = false;
                }else{
                    x = true;
                }
            }
            out.writeBytes(stringaScelta + '\n');

            stringaRicevuta = in.readLine();
            System.out.println("Stringa ricevuta: " + stringaRicevuta);
    
            if(stringaScelta.equals("!")){
                System.out.println("STOP");
                break;
            }
    
        } while (!stringaScelta.equals("esc"));
        
        server.close();
        out.close();
        in.close();
        myScan.close();
        myScan.close();
        myScan2.close();
    }
}