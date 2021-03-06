/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import entity.Questions;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author giap
 */
public class QuestionDAO {
    
    public List<Questions> findAll(){
        List<Questions> list = null;
        Session ss = HiberUp.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from Questions";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    
    
     public Questions findOne(String id){
        Session ss = HiberUp.getSessionFactory().openSession();
        ss.beginTransaction();
        Questions e = (Questions)ss.get(Questions.class, id);
        ss.close();
        return e;   
     }
    public boolean save(Questions q){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(q);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            return false;
        }
        finally{
            ss.close();
        }
    }
    public boolean delete(Questions q){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(q);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            return false;
        }
        finally{
            ss.close();
        }
    }
    
    public boolean update(Questions q){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(q);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            return false;
        }
        finally{
            ss.close();
        }
    }
}
