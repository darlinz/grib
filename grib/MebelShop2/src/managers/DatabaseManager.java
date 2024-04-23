/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.History;
import entity.Sofa;
import entity.User;
import java.util.List;

public class DatabaseManager {
    private EntityManager em;

    public DatabaseManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mebel2PU");
        this.em = emf.createEntityManager();
    }
    public void saveSofa(Sofa sofa){
        try {
            em.getTransaction().begin();
            if(sofa.getId() == null){
                em.persist(sofa);
            }else{
                em.merge(sofa);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public void saveUser(User user){
        try {
            em.getTransaction().begin();
                if(user.getBuyer().getId() == null){
                    em.persist(user.getBuyer());
                }else{
                    em.merge(user.getBuyer());
                }
            if(user.getId() == null){
                em.persist(user);
            }else{
                em.merge(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Пользователь не сохранен: "+e);
        }
    }

    public List<Sofa> getListSofas() {
        return em.createQuery("SELECT book FROM Book book").getResultList();
    }

    List<User> getListUsers() {
        return em.createQuery("SELECT user FROM User user").getResultList();
    }
  
    public User authorization(String login, String password) {
        try {
            return (User) em.createQuery("SELECT user FROM User user WHERE user.login = :login AND user.password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Sofa getSofa(Long id) {
        try {
            return em.find(Sofa.class, id);
        } catch (Exception e) {
            return null;
        }
    }
    public User getUser(Long id) {
        try {
            return em.find(User.class,id);
        } catch (Exception e) {
            return null;
        }
    }

    public void saveHistory(History history) {
        try {
            em.getTransaction().begin();
            if(history.getId() == null){
                em.persist(history);
            }else{
                em.merge(history);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    History getHistory(Long id) {
        try {
            return em.find(History.class,id);
        } catch (Exception e) {
            return null;
        }
    }

    List<History> getListHistories() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }

    
}
