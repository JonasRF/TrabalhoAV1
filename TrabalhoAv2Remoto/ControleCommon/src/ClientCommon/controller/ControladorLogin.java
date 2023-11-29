/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientCommon.controller;

import ClientCommon.entities.Usuario;

/**
 *
 * @author denis.cople
 */
public class ControladorLogin {
    
    private static Usuario usuario = null;
    
    public void signOut(){
        usuario = null;
    }
    
    public boolean signIn(String login, String senha){
        signOut();
        if(login.equals("admin")&&senha.equals("123"))
           usuario = new Usuario("XPTO",login,senha);
        return isLogado();
    }
    
    public boolean isLogado(){
        return usuario != null;
    } 
    
    
}
