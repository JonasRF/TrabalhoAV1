/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;



public class DepartamentoServer {
    
    public static void maind(String[] args) throws IOException{
        ServerSocket s0 = new ServerSocket(332);
        System.out.println("Servidor na porta 332");
        while(true){
            try{
                new DepartamentoServerThread(s0.accept()).start();
                System.out.println("Nova conexão em " + new Date());
            } catch(IOException ex) {
                System.out.println("Erro:" + ex.getMessage());
            }
                
        }
    }
    
    
}
