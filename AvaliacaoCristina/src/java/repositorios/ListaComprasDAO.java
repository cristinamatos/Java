package repositorios;

import java.util.*;
import modelos.ListaCompras;
import javax.persistence.*;
import modelos.ListaComprasItem;

public class ListaComprasDAO {

    public void save(ListaCompras o) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction trasaction = em.getTransaction();

        try {
            trasaction.begin();
            em.merge(o);
            trasaction.commit();
        } catch (Exception e) {
            System.out.println("Messagem SAVE " + e.getMessage());
            trasaction.rollback();
        } finally {
            em.close();
        }
    }

     public void excluirLista(Object o) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction trasaction = em.getTransaction();

        try {
            trasaction.begin();
            o = em.merge(o);
            em.remove(o);
 
            trasaction.commit();
        } catch (Exception e) {
            System.out.println("Messagem SAVE " + e.getMessage());
            trasaction.rollback();
        } finally {
            em.close();
        }
    }

    public List<ListaCompras> getAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        List<ListaCompras> listas = null;
        try {
            TypedQuery<ListaCompras> query = em.createQuery("Select o from ListaCompras o", ListaCompras.class);
            listas = query.getResultList();
         
        } catch (Exception e) {
            System.out.println("Messagem GET RELATORIO PEDIDOS --> " + e.getMessage());
        } finally {
            em.close();
        }
        return listas;
    }

}
