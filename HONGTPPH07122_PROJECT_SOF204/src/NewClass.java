
import DAO.AccountDAO;
import DAO.ExamDAO;
import DAO.ExamDetailDAO;
import DAO.ExamResultDAO;
import DAO.HiberUp;
import DAO.QuestionDAO;
import entity.Accounts;
import entity.Exam;
import entity.ExamDetail;
import entity.ExamResult;
import entity.Questions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author giap
 */
public class NewClass {
    public static void main(String[] args) {
       
//        List<Questions> list = new QuestionDAO().findAll();
//        for( Questions q : list){
//            System.out.println(q.toString());
//        }
//        List<Exam> list = new ExamDAO().findAll();
//        for( Exam e : list){
//            System.out.println(e.getId()+"   "+e.getTestDay()+"  ");
//        }
//           
//           Exam e = new Exam("EXAM2", "2-2-2020");
//           if(new ExamDAO().save(e)){
//               System.out.println("E");
//           }else{
//               System.out.println("C");
//           }
//           Exam e1 = new ExamDAO().findOne("Exam1");
//           if(new ExamDAO().delete(e1)){
//               System.out.println("PO");
//           }else{
//               System.out.println("KO");
//           }
//               List<Exam> listAa = new ExamDAO().search("2020");
//               for(Exam e : listAa){
//                   System.out.println(e.getId());
//               }

//        List<Questions> list = new ExamDAO().getExamQuestion("EXAM1");
//        for(Questions q : list ){
//            System.out.println(q.getQ()+" "+q.getAa()+" "+q.getAb()+" "+q.getAc()+" "+q.getAd());
//        }
//            List<Exam> list = new ExamDAO().sort();
//        for( Exam e : list){
//            System.out.println(e.getId()+"   "+e.getTestDay()+"  ");
//        }
//        Exam e = new ExamDAO().findOne("EXAM2");
//        Accounts a = new AccountDAO().findOne("HS1");
//        ExamResult eR = new ExamResult(1, a, e, 7);
//        if(new ExamResultDAO().save(eR)){
//            System.out.println("yyyyyyyy");
//            
//        }else{
//            System.out.println("xxxxxxx");
//        }
           File file = new File("C:\\Users\\giap\\Desktop\\Book1.xls");
           Workbook workbook;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
           int row = sheet.getRows();
           int col = sheet.getColumns();
           for(int i = 1;i<row;i++){
               for(int j = 0; j <col ;j++){
                   Cell cell = sheet.getCell(j, i);
                   System.out.print("__"+cell.getContents());
               }
               System.out.println("");
           }
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           

    }
}
