package model;
import java.util.*;
import java.sql.*;

public class StudentDAO extends MyDAO {

  public List<Student> getStudents() {
    List<Student> t = new ArrayList<>();
    xSql = "select * from Student";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xRollno,xName; float xMark;
      Student x;
      while(rs.next()) {
        xRollno = rs.getString("rollno");  
        xName = rs.getString("name");  
        xMark = rs.getFloat("mark");
        x = new Student(xRollno,xName,xMark);
        t.add(x);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(t);
  }
  public Student getStudent(String xRollno) {
     Student x = null;
     String xName; float xMark;
     xSql = "select * from Student where rollno=?"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, xRollno);
      rs = ps.executeQuery();
      if(rs.next()) {
        xName = rs.getString("name");
        xMark = rs.getFloat("mark");
        x = new Student(xRollno,xName,xMark);
      }
      rs.close();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
     return(x);
  }
  public List<Student> getStudents(String xxName) {
    List<Student> t = new ArrayList<>();
    xSql = "select * from Student WHERE name like '%" + xxName + "%'";
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xRollno,xName; float xMark;
      Student x;
      while(rs.next()) {
        xRollno = rs.getString("rollno");  
        xName = rs.getString("name");  
        xMark = rs.getFloat("mark");
        x = new Student(xRollno,xName,xMark);
        t.add(x);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(t);
  }
  public void insert(Student x) {
     xSql = "insert into Student values (?,?,?)"; 
     try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, x.getRollno());
      ps.setString(2, x.getName());
      ps.setFloat(3, x.getMark());
      ps.executeUpdate();
      ps.close();
     }     
     catch(Exception e) {
        e.printStackTrace();
     }
  }
  public void delete(String xRollno) {
     xSql = "delete from Student where rollno=?";
     try {
        ps = con.prepareStatement(xSql);
        ps.setString(1, xRollno);
        ps.executeUpdate();
        //con.commit();
        ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
  public void update(String xRollno, Student x) {
     xSql = "update Student set name=?, mark=? where rollno=?";
     try {      
        ps = con.prepareStatement(xSql);
        ps.setString(1, x.getName());
        ps.setFloat(2, x.getMark());
        ps.setString(3, xRollno);
        ps.executeUpdate();
        ps.close();
     }
      catch(Exception e) {
        e.printStackTrace();
      }
     return;
  }
  public String [] getColNames(String xTable) {
    String [] a = new String[30];
    int i = 0; int n;
    xSql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
    try {
      ps = con.prepareStatement(xSql);
      ps.setString(1, xTable);
      rs = ps.executeQuery();
      String xColName;
      i=0;
      while(rs.next()) {
        xColName = rs.getString("COLUMN_NAME");
        a[i++] = xColName;
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    n = i;
    String [] b = new String[n];
    for(i=0;i<n;i++) b[i] = a[i];
    return(b);
  }

  public List<Student> getStudents(String xSortColName, String xSortType) {
    List<Student> t = new ArrayList<>();
    xSql = "select * from Student order by " + xSortColName + " " + xSortType;
    try {
      ps = con.prepareStatement(xSql);
      rs = ps.executeQuery();
      String xRollno,xName; float xMark;
      Student x;
      while(rs.next()) {
        xRollno = rs.getString("rollno");  
        xName = rs.getString("name");  
        xMark = rs.getFloat("mark");
        x = new Student(xRollno,xName,xMark);
        t.add(x);
      }
      rs.close();
      ps.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
    return(t);
  }

  
}
