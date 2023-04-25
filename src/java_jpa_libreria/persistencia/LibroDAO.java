/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria.persistencia;

import java.util.List;
import java_jpa_libreria.entidades.Libro;

/**
 *
 * @author NICO
 */
public class LibroDAO extends DAO<Libro>{
 
    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l ").getResultList();
        desconectar();
        return libros;
    }  
    
    public Libro buscarPorId(long id) throws Exception {
        conectar();
        try {
            Libro libro = em.find(Libro.class, id);
            desconectar();
            return libro;
        } catch (Exception e) {
            desconectar();
            return null;
        }

    }    

    public List<Libro> buscarPorTitulo(String titulo) throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :tit").setParameter("tit", "%" + titulo + "%").getResultList();
        desconectar();
        return libros;
    }    
    
    public List<Libro> buscarPorAutor(String autor) throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :tit").setParameter("tit", "%" + autor + "%").getResultList();
        desconectar();
        return libros;
    }    
    
    public List<Libro> buscarPorEditorial(String editorial) throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :tit").setParameter("tit", "%" + editorial + "%").getResultList();
        desconectar();
        return libros;
    }    
    
    
    
    
    
    
    
    
    @Override
    public void eliminar(Libro libro) throws ClassNotFoundException {
        super.eliminar(libro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Libro libro) throws ClassNotFoundException {
        super.editar(libro); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Libro libro) throws ClassNotFoundException {
        super.guardar(libro); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
