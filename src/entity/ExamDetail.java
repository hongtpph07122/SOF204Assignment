package entity;
// Generated Mar 16, 2020 2:43:58 PM by Hibernate Tools 4.3.1



/**
 * ExamDetail generated by hbm2java
 */
public class ExamDetail  implements java.io.Serializable {


     private int id;
     private Exam exam;
     private Questions questions;

    public ExamDetail() {
    }

    public ExamDetail(int id, Exam exam, Questions questions) {
       this.id = id;
       this.exam = exam;
       this.questions = questions;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Exam getExam() {
        return this.exam;
    }
    
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public Questions getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Questions questions) {
        this.questions = questions;
    }




}

