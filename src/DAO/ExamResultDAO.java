/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Accounts;
import entity.Exam;
import entity.ExamResult;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author giap
 */
public class ExamResultDAO {
    public List<ExamResult> findAll(){
        List<ExamResult> list = null;
        Session ss = HiberUp.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from ExamResult";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    
     public ExamResult findOne(String id){
        Session ss = HiberUp.getSessionFactory().openSession();
        ss.beginTransaction();
        ExamResult e = (ExamResult)ss.get(ExamResult.class, id);
        ss.close();
        return e;   
     }
    public boolean save(ExamResult examResult){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(examResult);
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
    public boolean delete(ExamResult examResult){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(examResult);
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
    
    public boolean update(ExamResult examResult){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(examResult);
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
    public  List<ExamResult> search(Accounts acc) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(ExamResult.class);
        if (acc != null) {
            criteria.add(Restrictions.like("accounts", acc));
        }
        List<ExamResult> result = criteria.list();
        //session.close();
        //sessionFactory.close();
        return result;
    }
     public List<ExamResult> sort(Exam exam) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(ExamResult.class);
        if (exam != null) {
            criteria.add(Restrictions.like("exam", exam));
        }
        criteria.addOrder(Order.desc("score"));
        List<ExamResult> result = criteria.list();
        //session.close();
        //sessionFactory.close();
        return result;
    }
}
