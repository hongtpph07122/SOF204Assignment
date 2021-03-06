/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Accounts;
import entity.Questions;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author giap
 */
public class AccountDAO {
    public List<Accounts> findAll(){
        List<Accounts> list = null;
        Session ss = HiberUp.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from Accounts";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    
    public Accounts findOne(String id){
       Session ss = HiberUp.getSessionFactory().openSession();
       ss.beginTransaction();
       Accounts e = (Accounts)ss.get(Accounts.class, id);
       ss.close();
       return e;   
    }
    public boolean save(Accounts accounts){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(accounts);
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
    public boolean delete(Accounts accounts){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(accounts);
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
    
    public boolean update(Accounts accounts){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(accounts);
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
    public List<Accounts> search(String username,String fullname, boolean type) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Accounts.class);
        if (username != null) {
            criteria.add(Restrictions.like("username", "%" + username + "%"));
        }
        if (fullname != null) {
            criteria.add(Restrictions.like("fullname", "%" + fullname + "%"));
        }
            criteria.add(Restrictions.eq("type",type));
        List<Accounts> result = criteria.list();
        //session.close();
        //sessionFactory.close();
        return result;
    }
}
