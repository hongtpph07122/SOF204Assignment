package entity;
// Generated Mar 16, 2020 2:43:58 PM by Hibernate Tools 4.3.1



/**
 * ExamResult generated by hbm2java
 */
public class ExamResult  implements java.io.Serializable {


     private int id;
     private Accounts accounts;
     private Exam exam;
     private Double score;
     private String examday;

    public ExamResult() {
    }

	
    public ExamResult(int id, Accounts accounts, Exam exam) {
        this.id = id;
        this.accounts = accounts;
        this.exam = exam;
    }
    public ExamResult(int id, Accounts accounts, Exam exam, Double score,String examday) {
       this.id = id;
       this.accounts = accounts;
       this.exam = exam;
       this.score = score;
       this.examday = examday;
    }

    public String getExamday() {
        return examday;
    }

    public void setExamday(String examday) {
        this.examday = examday;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Accounts getAccounts() {
        return this.accounts;
    }
    
    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }
    public Exam getExam() {
        return this.exam;
    }
    
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }




}


