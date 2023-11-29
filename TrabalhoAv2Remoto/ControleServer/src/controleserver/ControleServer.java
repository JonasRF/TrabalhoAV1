 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controleserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

/**
 *
 * @author jonas
 */
public class ControleServer {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException {
        ServerSocket s0 = new ServerSocket(332);
        System.out.println("Servidor na porta 332");
        while (true) {
            try {
                new DepartamentoServerThread(s0.accept()).start();
                System.out.println("Nova conexao em " + new Date());
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
    
}
