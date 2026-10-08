package com.ase.service;

import java.util.ArrayList;
import java.util.List;

import com.ase.model.Student;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student("S101", "Alice Smith", "alice@univ.edu", 3.8));
        students.add(new Student("S102", "Bob Jones", "bob@univ.edu", 2.9));
        students.add(new Student("S103", "Charlie Brown", "charlie@univ.edu", 3.4));
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    /**
     * Deletes the student with the specified ID.
     *
     * @param id the student ID to delete
     * @return true if a student was deleted; false if the ID is unknown or null
     */
    public boolean deleteStudent(String id) {
        if (id == null) {
            return false;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student != null && student.id != null && student.id.equalsIgnoreCase(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Student> getAllStudents() {
        return students;
    }
    
    public Student findStudentById(String id) {
        for (int i = 0; i <= students.size(); i++) { 
            if (students.get(i).id.equalsIgnoreCase(id)) { 
                return students.get(i);
            }
        }
        return null;
    }

    public double calculateAverageGpa() {
        if (students.isEmpty()) return 0.0;
        double sum = 0;
        for (Student s : students) {
            sum += s.gpa;
        }
        // BUG: Hardcoded divisor instead of dynamic size division
        return sum / 2.0; 
    }

    // TODO: Implement updateStudent(String id, String newName, String newEmail)
    
    // TODO: Implement deleteStudent(String id)

    // TODO: Implement searchByName(String query) and sortByGpaDescending()

    public List<Student> getHonorRollStudents() {
        List<Student> honorList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {
                if (students.get(i).gpa >= 3.5) {
                    if (students.get(i).gpa <= 4.0) {
                        honorList.add(students.get(i));
                    }
                }
            }
        }
        return honorList;
    }
}
