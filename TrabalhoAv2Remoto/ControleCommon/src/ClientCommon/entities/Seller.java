/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientCommon.entities;

import java.io.Serializable;


/**
 *
 * @author jonas
 */
public class Seller implements Serializable{
    public Integer idS;
    public String nomeS;
    public String email;
    public String birth;
    public Integer salary;
    
    public Seller (Integer idS, String nomeS, String email, String birth, Integer salary){
        this.idS = idS;
        this.nomeS = nomeS;
        this.email = email;
        this.birth = birth;
        this.salary = salary;
    }
    
}

