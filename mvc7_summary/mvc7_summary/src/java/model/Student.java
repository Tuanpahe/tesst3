package model;

public class Student {
  private String rollno,name;
  private float mark;

    public Student() {
    }

    public Student(String rollno, String name, float mark) {
        this.rollno = rollno;
        this.name = name;
        this.mark = mark;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public float getMark() {
        return mark;
    }
  
}
