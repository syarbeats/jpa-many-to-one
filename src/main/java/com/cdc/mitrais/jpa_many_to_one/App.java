package com.cdc.mitrais.jpa_many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cdc.mitrais.jpa_many_to_one.entity.Department;
import com.cdc.mitrais.jpa_many_to_one.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	EntityManager entitymanager = emFactory.createEntityManager();
    	
    	entitymanager.getTransaction().begin();
    	
    	Department department = new Department();
    	department.setName("Development");
    	
    	entitymanager.persist(department);
    	
    	Employee employee1 = new Employee();
    	employee1.setEname("Satish");
    	employee1.setSalary(45000);
    	employee1.setDeg("Technical Writer");
    	employee1.setDepartment(department);
    	
    	Employee employee2 = new Employee();
    	employee2.setEname("Krisna");
    	employee2.setSalary(45000);
    	employee2.setDeg("Technical Writer");
    	employee2.setDepartment(department);
    	
    	Employee employee3 = new Employee();
    	employee3.setEname("Masthanvali");
    	employee3.setSalary(50000);
    	employee3.setDeg("Technical Writer");
    	employee3.setDepartment(department);
    	
    	entitymanager.persist(employee1);
    	entitymanager.persist(employee2);
    	entitymanager.persist(employee3);
    	
    	entitymanager.getTransaction().commit();
    	entitymanager.close();
    	emFactory.close();
    }
}
