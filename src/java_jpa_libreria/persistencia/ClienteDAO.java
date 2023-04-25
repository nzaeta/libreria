/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_jpa_libreria.persistencia;

import java.util.List;
import java_jpa_libreria.entidades.Cliente;

/**
 *
 * @author NICO
 */
public class ClienteDAO extends DAO<Cliente>{

    public List<Cliente> listarTodos() throws Exception {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a ").getResultList();
        desconectar();
        return clientes;
    }  
       
    
    public Cliente buscarPorId(int id) throws Exception {
        conectar();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            desconectar();
            return cliente;
        } catch (Exception e) {
            desconectar();
            return null;
        }
    }     
    
    
    @Override
    public  void eliminar(Cliente cliente) throws ClassNotFoundException {
        super.eliminar(cliente); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  void editar(Cliente cliente) throws ClassNotFoundException {
        super.editar(cliente); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  void guardar(Cliente cliente) throws ClassNotFoundException {
        super.guardar(cliente); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
