package com.pradeepjoam.jpaquery.dao;

import org.springframework.data.repository.CrudRepository;

import com.pradeepjoam.jpaquery.entities.Employee;

public interface MysqlJpaRepoInterface  extends CrudRepository<Employee, Integer>{

}
