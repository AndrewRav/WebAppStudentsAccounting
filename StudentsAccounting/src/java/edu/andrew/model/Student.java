package edu.andrew.model;

import java.util.Objects;

/**
 *
 * @author Andrew
 */
public class Student {
    private int id, userId, course;
    private String lastName, firstName, middleName, phoneNumber, birthDate, group, faculty;

    public Student(int id, int userId, String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String faculty, int course, String group) {
        this.id = id;
        this.userId = userId;
        this.course = course;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.group = group;
        this.faculty = faculty;
    }

    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return this.id == other.id;
    }
    
    
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", userId=" + userId + ", course=" + course + ", lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", group=" + group + ", faculty=" + faculty + '}';
    }
}