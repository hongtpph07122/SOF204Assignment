/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.AccountDAO;
import DAO.ClassDAO;
import DAO.ExamDAO;
import DAO.ExamDetailDAO;
import DAO.ExamResultDAO;
import DAO.QuestionDAO;
import entity.*;
import entity.Exam;
import entity.ExamResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author giap
 */
public class NewClass {
    public static void main(String[] args) {
        List<Accounts> list = new AccountDAO().search("", "L", true);
        for(Accounts a : list){
            System.out.println(a.getFullname());
        }
        
        
    }
}
