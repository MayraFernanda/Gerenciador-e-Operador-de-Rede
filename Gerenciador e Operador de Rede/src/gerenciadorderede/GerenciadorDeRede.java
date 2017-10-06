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
public class GerenciadorDeRede {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
    { 
      DatagramSocket clientSocket = new DatagramSocket(); 
      String adresses[] = new String[6];
      String macAdresses[] = new String[6];
      
      
      adresses[0] = "177.220.18.76"; 
      adresses[1] = "177.220.18.78"; 
      adresses[2] = "177.220.18.80"; 
      adresses[3] = "177.220.18.81"; 
      adresses[4] = "177.220.18.82";
      adresses[5] = "177.220.18.83";
      
      macAdresses[0] = "2C-44-FD-FA-DA-F4";
      macAdresses[1] = "2C-44-FD-FA-EA-FF";
      macAdresses[2] = "2C-44-FD-FA-DA-3B";
      macAdresses[3] = "2C-44-FD-FA-CA-07";
      macAdresses[4] = "2C-44-FD-FA-EA-CF";
      macAdresses[5] = "2C-44-FD-FA-CA-13";
      
       
      for(int i=0; i<adresses.length; i++){
        Acordador acordador = new Acordador();
        acordador.acordar(adresses[i], macAdresses[i]);     
        }
      }    
    }
    
    
}

