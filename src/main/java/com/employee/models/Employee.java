package com.employee.models;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column @Size(min=4,max=20,message = "Name should be of 4-10 characters")@NotNull
	private String name;
	
	@Column @Email @NotNull
	private String email;
	
	@Column @NotNull  @Size(min=10,max=10)
	private String phone;
	
	@Column @NotNull
	private String password;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<Account> account;
	
	@ManyToMany(mappedBy = "employee")
	private List<Project> project;
}
