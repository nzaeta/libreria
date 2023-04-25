/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria.persistencia;

import java.util.List;
import java_jpa_libreria.entidades.Prestamo;

/**
 *
 * @author NICO
 */
public class PrestamoDAO extends DAO<Prestamo>{

    public List<Prestamo> listarPorCliente(String cli) throws Exception {
        conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.nombre LIKE :name").setParameter("name","%" + cli + "%").getResultList();
        desconectar();
        return prestamos;
    }  
      
    
    @Override
    public void eliminar(Prestamo prestamo) throws ClassNotFoundException {
        super.eliminar(prestamo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Prestamo prestamo) throws ClassNotFoundException {
        super.editar(prestamo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Prestamo prestamo) throws ClassNotFoundException {
        super.guardar(prestamo); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
}
