/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Exam;
import entity.ExamDetail;
import entity.Questions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
public class ExamDAO {
     public List<Exam> findAll(){
        List<Exam> list = null;
        Session ss = HiberUp.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from Exam";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
     public Exam findOne(String id){
        Session ss = HiberUp.getSessionFactory().openSession();
        ss.beginTransaction();
        Exam e = (Exam)ss.get(Exam.class, id);
        ss.close();
        
        return e;   
     }
    public boolean save(Exam exam){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(exam);
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
    public boolean delete(Exam exam){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(exam);
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
    
    public boolean update(Exam exam){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(exam);
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
    
    public static List<Exam> search(String testday) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Exam.class);
        if (testday != null) {
            criteria.add(Restrictions.like("testDay", "%" + testday + "%"));
        }
        List<Exam> result = criteria.list();
        //session.close();
        //sessionFactory.close();
        return result;
    }
    
    public List<Questions> getExamQuestion(String examID){
        List<Questions> list= new ArrayList<>();
        Exam exam = new ExamDAO().findOne(examID);
        Set<ExamDetail> hs = exam.getExamDetails();
        for(ExamDetail e : hs){
            list.add(e.getQuestions());
        }
        return list;
    }
    
    
     public List<Exam> sort() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Exam.class);
        criteria.addOrder(Order.desc("testDay"));
        List<Exam> result = criteria.list();
        //session.close();
        //sessionFactory.close();
        return result;
    }
}
