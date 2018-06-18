package com.codinghive.examples.jee.model;

import java.io.Serializable;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name = "Ticket.isReserved", query = "SELECT e FROM Student e  WHERE e.PASSWORD = 0")
})

public class Ticket implements Serializable  {
	
    @Id
    @Column
    private int ticketId;
    
    @Column(name="password")
    private String password;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
