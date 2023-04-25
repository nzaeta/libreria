package java_jpa_libreria.persistencia;

import java.util.List;
import java_jpa_libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial>{
    
    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e ").getResultList();
        desconectar();
        return editoriales;
    }  
    
    public Editorial buscarPorId(int id) throws Exception {
        conectar();
        try {
            Editorial editorial = em.find(Editorial.class, id);
            desconectar();
            return editorial;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }

    @Override
    public void eliminar(Editorial editorial) throws ClassNotFoundException {
        super.eliminar(editorial); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Editorial editorial) throws ClassNotFoundException {
        super.editar(editorial); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Editorial editorial) throws ClassNotFoundException {
        super.guardar(editorial); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}
