package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
