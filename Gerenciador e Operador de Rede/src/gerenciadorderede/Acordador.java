/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorderede;

import java.io.*;
import java.net.*;

/**
 *
 * @author u14189
 */

public class Acordador {
    public static final int PORT = 9;  //Porta padrão
    
    public void acordar(String strIp, String strMac) { 
        
        try {
           //Cria um vetor com o endereço broadcast e 16 vezes o endereço mac
           byte[] macBytes = getMacBytes(strMac);     
            byte[] bytes = new byte[6 + 16 * macBytes.length];  
            for (int i = 0; i < 6; i++) {                   
                bytes[i] = (byte) 0xff;        
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);   
            }                                                               
            
            InetAddress address = InetAddress.getByName(strIp);            
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, PORT); 
            DatagramSocket socket = new DatagramSocket();   
            socket.send(packet); 
            socket.close(); 
            
            System.out.println("Acordador acionado com sucesso no ip: "+strIp);
        }
        catch (Exception e) {
            System.out.println("Falha ao acionar: + e");
            System.exit(1);
        }
        
    }
    
    private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
        byte[] bytes = new byte[6];
        String[] hex = macStr.split("(\\:|\\-)");
        if (hex.length != 6) {
            throw new IllegalArgumentException("Enedereço MAC inválido");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dígito hexa inválido em endereço MAC");
        }
        return bytes;
    }
}
