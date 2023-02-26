package com.example.encompasseshandling.service;

import com.example.encompasseshandling.dao.StudentRepo;
import com.example.encompasseshandling.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public int saveStudent(Student student){
        Student studentObj = studentRepo.save(student);
        return Integer.valueOf(studentObj.getStudentId());
    }

    public JSONArray getStudent(String studentId) {

        JSONArray studentArray = new JSONArray();

        if(null != studentId && studentRepo.findById(String.valueOf(studentId)).isPresent()){

            Student student = studentRepo.findById(String.valueOf(studentId)).get();
            JSONObject studentObj = setStudent(student);
            studentArray.put(studentObj);
        }else {
            List<Student> userList = studentRepo.findAll();

            for (Student student : userList){
                JSONObject studentObj = setStudent(student);
                studentArray.put(studentObj);
            }
        }
        return studentArray;
    }

    private JSONObject setStudent(Student student){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("studentId", student.getStudentId());
        jsonObject.put("studentName", student.getStudentName());
        jsonObject.put("age", student.getAge());
        jsonObject.put("branch", student.getBranch());
        jsonObject.put("department", student.getDepartment());
        jsonObject.put("phoneNum", student.getPhoneNumber());
        jsonObject.put("address",student.getAddress());

        return jsonObject;
    }

    public void updateStudent(Student newStudent, String studentId) {
        if(studentRepo.findById(String.valueOf(studentId)).isPresent()){
            Student student = studentRepo.findById(String.valueOf(studentId)).get();
            newStudent.setStudentId(student.getStudentId());
            studentRepo.save(newStudent);
        }
    }

    public Student findByStudent(String studentID) {
    }
}
