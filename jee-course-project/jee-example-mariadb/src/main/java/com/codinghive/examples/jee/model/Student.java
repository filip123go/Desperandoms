package com.codinghive.examples.jee.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NamedQueries({
	
	@NamedQuery(name = "Student.getAll", query = "SELECT e FROM Student e"),
	@NamedQuery(name = "Student.isReserved", query = "SELECT e FROM Student e  WHERE e.password = 0")
	
})
public class Student implements Serializable {

    @Id
    @Column
    private int ticketId;

    @Column(name="eventName")
    private String eventName;

    @Column(name="location")
    private String location;

    @Column(name="yearLevel")
    private int yearLevel;
    
    @Column(name="price")
    private String price;
    
    @Column(name="password")
    private String password;
        
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getprice() {
    	return price;
    }
    
    public void seprice(String price) {
        this.price = price;
    }
    
    

    public int getticketId() {
        return ticketId;
    }

    public void setticketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String geteventName() {
        return eventName;
    }

    public void seteventName(String eventName) {
        this.eventName = eventName;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public Student(int ticketId , String eventName , String location , String price , String password , int yearLevel) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.location = location;
        this.price = price;
        this.password = password;
        this.yearLevel = yearLevel;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "ticketId=" + ticketId + ", eventName='" + eventName + '\'' + ", location='" + location + '\''
                + ", yearLevel=" + yearLevel + '}';
    }
}
