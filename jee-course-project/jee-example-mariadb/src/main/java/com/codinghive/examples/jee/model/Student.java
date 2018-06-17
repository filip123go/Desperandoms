package com.codinghive.examples.jee.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NamedQueries({
	
	@NamedQuery(name = "Student.getAll", query = "SELECT e FROM Student e") , @NamedQuery(name = "login", query = "SELECT e FROM Student e") 
	
})
public class Student implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="yearLevel")
    private int yearLevel;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name="password")
    private String password;
        
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
    	return userName;
    }
    
    public void seUserName(String userName) {
        this.userName = userName;
    }
    
    

    public int getStudentId() {
        return studentId;
    }

//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Student(int studentId , String firstname , String lastname , String userName , String password , int yearLevel) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userName = userName;
        this.password = password;
        this.yearLevel = yearLevel;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\''
                + ", yearLevel=" + yearLevel + '}';
    }
}
