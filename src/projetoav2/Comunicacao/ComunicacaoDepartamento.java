/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoav2.Comunicacao;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import projetoav1.Entities.Departamento;


public class ComunicacaoDepartamento extends Comunicacao {
   
    public ComunicacaoDepartamento(Socket s)throws IOException{
        super(s);
    }
    
    public Departamento receberDepartamento() throws IOException, ClassNotFoundException{
        return (Departamento) receber();
    }
           
    public List<Departamento> receberDepartamentos() throws IOException, ClassNotFoundException{
        return(List<Departamento>) receber();
    }

   
}
