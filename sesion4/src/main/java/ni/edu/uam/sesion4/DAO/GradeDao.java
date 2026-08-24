package ni.edu.uam.sesion4.DAO;

import ni.edu.uam.sesion4.models.Student;

import java.util.ArrayList;
import java.util.List;

public class GradeDao {
    List<Student> grades;

    public GradeDao(){
        grades = new ArrayList<>();
    }

    public void addGrade(Student student){
        grades.add(student);
    }

    public List<Student> getGrades(){
        return grades;
    }

    public Student getGradeForName(String name){
        for(Student student : grades){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
}
