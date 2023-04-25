
package java_jpa_libreria.persistencia;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("libreriaPU");
    protected EntityManager em = EMF.createEntityManager();
    
    protected void conectar() throws ClassNotFoundException {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }
    
    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    protected void guardar(T objeto) throws ClassNotFoundException{
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto) throws ClassNotFoundException{
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void eliminar(T objeto) throws ClassNotFoundException{
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
}
