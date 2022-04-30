package com.adam.journals.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Please include your first name")
    @Size(min=1, max=255, message="Please include your first name")
    private String firstName;
    
    @NotEmpty(message="Please include your last name")
    @Size(min=1, max=255, message="Please include your last name")
    private String lastName;
    
    @NotEmpty(message="Please include a user name")
    @Size(min=1, max=255, message="Please include a user name")
    private String userName;
    
    @NotEmpty(message="Please include an email address")
    @Email(message="Please include a valid email address")
    private String email;
    
    @NotEmpty(message="Please include a new pasword")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Please include a matching password")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    public User() {	
	}
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Entry> entries;
    
//    Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
    
    
    
    
    
}
