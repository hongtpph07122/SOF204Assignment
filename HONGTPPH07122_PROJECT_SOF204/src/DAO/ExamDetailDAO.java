/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.ExamDetail;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author giap
 */
public class ExamDetailDAO {
    public List<ExamDetail> findAll(){
        List<ExamDetail> list = null;
        Session ss = HiberUp.getSessionFactory().getCurrentSession();
        ss.getTransaction().begin();
        String sql = "from ExamDetail";
        Query query = ss.createQuery(sql);
        list = query.list();
        ss.close();
        return list;
    }
    
    public ExamDetail findOne(String id){
       Session ss = HiberUp.getSessionFactory().openSession();
       ss.beginTransaction();
       ExamDetail e = (ExamDetail)ss.get(ExamDetail.class, id);
       ss.close();
       return e;   
    }
    public boolean save(ExamDetail examDetail){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(examDetail);
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
    public boolean delete(ExamDetail examDetail){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.delete(examDetail);
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
    
    public boolean update(ExamDetail examDetail){
        Session ss = HiberUp.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.update(examDetail);
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
