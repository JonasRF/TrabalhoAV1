/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientCommon.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;



public class Comunicacao {
    private final ObjectOutputStream saida;
    private final ObjectInputStream entrada;
    
    public Comunicacao(OutputStream out, InputStream in) 
                   throws IOException{
        saida = new ObjectOutputStream(out);
        entrada = new ObjectInputStream(in);
    }
    
    public Comunicacao(Socket s) throws IOException{
        this(s.getOutputStream(),s.getInputStream());
    }
    
    public void enviar(Object obj) throws IOException{
        saida.writeObject(obj);
        saida.flush();
    }
    
    public Object receber() throws IOException, ClassNotFoundException{
        return entrada.readObject();
    }
    
    public void enviarInteiro(int valor) throws IOException{
        enviar(valor);
    }
    
    public int receberInteiro() throws IOException, ClassNotFoundException{
        return (int) receber();
    }
    
    public void enviarTexto(String texto) throws IOException{
        enviar(texto);
    }
    
    public String receberTexto() throws IOException, ClassNotFoundException{
        return (String) receber();
    }
}
