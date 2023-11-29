/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleserver.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ClientCommon.entities.Seller;


public class SellerRepo {
    private static HashMap<Integer, Seller> dados = new HashMap<>();
    
    public void incluir(Seller p){
        dados.put(p.idS,p);
    }
    
    public void incluir(Integer idS, String nomeS, String email, String birth, Integer salary){
        incluir(new Seller(idS, nomeS, email, birth, salary));
    }
    
    public void alterar(Seller p){
        Seller p2 = dados.get(p.idS);
        p2.nomeS = p.nomeS;
        p2.email = p.email;
        p2.birth = p.birth;
        p2.salary = p.salary;
    }
    
    public void alterar(Integer idS, String nomeS, String email, String birth, Integer salary){
        alterar(new Seller(idS, nomeS, email, birth, salary));
    }
    
    public void excluir(Integer idS){
        dados.remove(idS);
    }
    
    public Seller obter(Integer idS){
        return dados.get(idS);
        
    }
    
    public List<Seller> obterTodosSeller(){
        return new ArrayList<>(dados.values());
    }
    
    public void salvarSeller(String nomeArq){
        try(ObjectOutputStream objOut = new ObjectOutputStream(
        new FileOutputStream(nomeArq))){
            objOut.writeObject(dados);
            objOut.flush();
        }catch (IOException e){
            System.out.println("Erro ao salvar arquivo");
        }
    }
    
    @SuppressWarnings("unchecked")
    public void recuperarSeller(String nomeArq){
        try (ObjectInputStream objIn = new ObjectInputStream(
            new FileInputStream(nomeArq))){
            dados = (HashMap<Integer,Seller>)objIn.readObject();
        }catch (ClassNotFoundException | IOException e){
            System.out.println("Erro ao ler o arquivo");
                  
        }
    }

   
}