/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.AccountDAO;
import DAO.ClassDAO;
import DAO.ExamDAO;
import DAO.ExamResultDAO;
import entity.*;
import entity.Exam;
import entity.ExamResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giap
 */
public class NewClass {
    public static void main(String[] args) {
        String dS = new AccountDAO().findOne("GV06").getBirthday();
        System.out.println(dS);
        String MM = dS.substring(5, 7);
        System.out.println(MM);
        String dd = dS.substring(8, 10);
        System.out.println(dd);
    }
}
