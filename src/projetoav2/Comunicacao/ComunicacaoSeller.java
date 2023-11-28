/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoav2.Comunicacao;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import projetoav1.Entities.Seller;




public class ComunicacaoSeller extends Comunicacao {
     public ComunicacaoSeller(Socket s)throws IOException{
        super(s);
    }
    
    public Seller receberSeller() throws IOException, ClassNotFoundException{
        return (Seller) receber();
    }
           
    public List<Seller> receberSellers() throws IOException, ClassNotFoundException{
        return(List<Seller>) receber();
}
}