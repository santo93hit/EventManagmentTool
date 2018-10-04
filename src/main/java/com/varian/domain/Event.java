package com.varian.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1031627252510916883L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id", unique = true, updatable=false)
	private Long id;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "booking_from_date")
	private Date bookingFromDate;
	
	@Column(name = "booking_to_date")
	private Date bookingToDate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@Column(name = "no_of_person")
	private Long noOfPerson;
	
	public Event() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(Date bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	public Date getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(Date bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(Long noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	
	

}
