/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import projetoav1.Entities.SellerRepo;
import projetoav1.Entities.Seller;
import projetoav2.Comunicacao.ComunicacaoSeller;
import java.io.IOException;
import java.net.Socket;


public class SellerServerThread extends Thread {
    
    
    private ComunicacaoSeller ctrl;
    private Socket s;
    private SellerRepo repo= new SellerRepo();
    
    public SellerServerThread(Socket s){
        try{
            this.s=s;
            ctrl = new ComunicacaoSeller(s);
            
        }catch (IOException ex){
            System.out.println("Erro"+ex.getMessage());
        }
    }
    
    @Override
    public void run(){
        String oper="";
        while(!oper.equals("S")){
            try{
                oper = ctrl.receberTexto();
                if("LEIC".contains(oper)){
                    switch(oper){
                        case "L" -> ctrl.enviar(repo.obterTodosSeller());
                        case "E" -> repo.excluir(ctrl.receberInteiro());
                        case "I" -> repo.incluir(ctrl.receberSeller());
                        case "C" -> {
                            Seller p = repo.obter(ctrl.receberInteiro());
                            ctrl.enviar(p);
                        }
                    }
                }
            }catch (IOException | ClassNotFoundException ex){
                System.out.println("Erro"+ex.getMessage());
                oper="S";
            }
        }
        try{
            s.close();
        }catch (IOException ex){
            System.out.println("Erro"+ex.getMessage());
        }
    }
    
    
}


