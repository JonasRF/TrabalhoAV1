

package controleserver.controller;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ClientCommon.entities.Departamento;


public class DepartamentoRepo{
    
   private static HashMap<Integer, Departamento> dados = new HashMap<>();
   
   
   public void incluir(Departamento p){
       dados.put(p.id,p);
   }
   
   public void incluir(Integer id, String nome){
       incluir(new Departamento(id, nome));
   }
   
   public void alterar(Departamento p){
       Departamento p2 = dados.get(p.id);
       p2.nome = p.nome;
       dados.put(p2.id, p2);
   }
   
   public void alterar(Integer id, String nome){
       alterar(new Departamento(id,nome));
   }
   
   public void excluir(Integer id){
       dados.remove(id);
   }
   
   public Departamento obter(Integer id){
       return dados.get(id);
   }
   
   public List<Departamento> obterTodos(){
       return new ArrayList<>(dados.values());
   }
   
   public void salvar(String nomeArq){
		try(ObjectOutputStream objOut = new ObjectOutputStream(
				                        new FileOutputStream(nomeArq))){
			objOut.writeObject(dados);
			objOut.flush();		
		} catch (IOException e) {
			System.out.println("Erro ao salvar arquivo");
		}
	}
    @SuppressWarnings("unchecked")
   
	public void recuperar(String nomeArq) {
		try (ObjectInputStream objIn = new ObjectInputStream(
				                       new FileInputStream(nomeArq))){
			dados = (HashMap<Integer, Departamento>)objIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Erro ao ler o arquivo");
		}
	}

}





