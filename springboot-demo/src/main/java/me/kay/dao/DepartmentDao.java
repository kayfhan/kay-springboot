package me.kay.dao;

import me.kay.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

//	private static Map<Integer, Department> departments = null;
//
//	static{
//		departments = new HashMap<Integer, Department>();
//
//		departments.put(101, new Department(101, "D-AA"));
//		departments.put(102, new Department(102, "D-BB"));
//		departments.put(103, new Department(103, "D-CC"));
//		departments.put(104, new Department(104, "D-DD"));
//		departments.put(105, new Department(105, "D-EE"));
//	}
//
//	public Collection<Department> getDepartments(){
//		return departments.values();
//	}
//
//	public Department getDepartment(Integer id){
//		return departments.get(id);
//	}
	
}
