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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true) @Size(min=4,max=20,message = "title should be of 4-10 characters")@NotNull
	private String title;
	
	@Column @Size(min=4,max=20,message = "duration should be of 4-10 characters")@NotNull
	private String duration;
	
	@ManyToMany
	@JoinTable(name= "employee_project",joinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id")
	)
	private List<Employee> employee;
}
