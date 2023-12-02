/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleserver;
import ClientCommon.net.ComunicacaoDepartamento;
import controleserver.controller.DepartamentoRepo;
import java.io.IOException;
import java.net.Socket;
import ClientCommon.entities.Departamento;


public class DepartamentoServerThread extends Thread{
    
    private ComunicacaoDepartamento ctrl;
    private Socket s;
    private DepartamentoRepo repo = new DepartamentoRepo();
    
    
    public DepartamentoServerThread(Socket s){
        try{
            this.s = s;
            ctrl = new ComunicacaoDepartamento(s);
        }catch (IOException ex){
            System.out.println("Erro"+ex.getMessage());
        }
    }
    
    @Override
    public void run(){
        String oper ="";
        while(!oper.equals("S")){
            try{
                oper = ctrl.receberTexto();
                if("LEIC".contains(oper)){
                    switch(oper){
                        case "L" -> ctrl.enviar(repo.obterTodos());
                        case "E" -> repo.excluir(ctrl.receberInteiro());
                        case "I" -> repo.incluir(ctrl.receberDepartamento());
                        case "C" -> {
                            Departamento p = repo.obter(ctrl.receberInteiro());
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
            System.out.println("Erro:"+ex.getMessage());
        }
    }
    
}
