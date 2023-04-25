/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria.persistencia;

import java.util.ArrayList;
import java.util.List;
import java_jpa_libreria.entidades.Autor;

/**
 *
 * @author NICO
 */

public class AutorDAO extends DAO<Autor> {

    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a ").getResultList();
        desconectar();
        return autores;
    }  
    
    public List<Autor> buscarPorNombre(String nombre) throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :name").setParameter("name", "%" + nombre + "%").getResultList();
        desconectar();
        return autores;
    }      
    
    public Autor buscarPorId(int id) throws Exception {
        conectar();
        try {
            Autor autor = em.find(Autor.class, id);
            desconectar();
            return autor;
        } catch (Exception e) {
            desconectar();
            return null;
        }

    }   
    
    
    
    
    @Override
    public void guardar(Autor autor) throws ClassNotFoundException {
        super.guardar(autor);
    }

    @Override
    public void eliminar(Autor autor) throws ClassNotFoundException {
        super.eliminar(autor); 
    }

    @Override
    public void editar(Autor autor) throws ClassNotFoundException {
        super.editar(autor); //To change body of generated methods, choose Tools | Templates.
    }

}    

