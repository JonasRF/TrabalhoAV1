

package projetoav1.Entities;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import projetoav1.Entities.Departamento;
import projetoav1.View.DepartamentForm;
import projetoav1.View.MainView;


public class DepartamentoRepo extends Departamento {
    private String arquivo = "departamentos.dat";

    public DepartamentoRepo(int id, String nome) {
        super(id, nome);
    }

    public void salvarDepartamento(Departamento departamento) {
        List<Departamento> departamentos = listarDepartamentos();
        departamentos.add(departamento);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            output.writeObject(departamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Departamento> listarDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo))) {
            departamentos = (List<Departamento>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Arquivo ainda não existe ou está vazio
        }

        return departamentos;
    }
    
      
    
}



