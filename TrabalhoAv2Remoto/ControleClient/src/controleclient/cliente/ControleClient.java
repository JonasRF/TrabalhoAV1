/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controleclient.cliente;

import ClientCommon.entities.Departamento;
import ClientCommon.net.ComunicacaoDepartamento;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author jonas
 */
public class ControleClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (Socket s1 = new Socket("127.0.0.1", 332)) {
          
        }
    }
    
}
