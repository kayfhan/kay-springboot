package me.kay.controller;

import me.kay.dao.DepartmentDao;
import me.kay.dao.EmployeeDao;
import me.kay.entities.Department;
import me.kay.entities.Employee;
import me.kay.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String employees(Model model) {
        Collection<Employee> employees = employeeDao.findAll();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping(value = "/emp")
    public String beforeAddEmployee(Model model) {
        Collection<Department> departments = departmentDao.findAll();
        model.addAttribute("departments", departments);
        return "employeeEdit";
    }

    @PostMapping(value = "/emp")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//    @ResponseBody
    @GetMapping(value = "/emp/{id}")
    public String beforeUpdateEmployee(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.findById(id).orElse(null);
        if (employee == null){
            throw new UserNotFoundException();
        }
        model.addAttribute("employee", employee);

        Collection<Department> departments = departmentDao.findAll();
        model.addAttribute("departments", departments);
        return "employeeEdit";
    }

    @PutMapping(value = "/emp")
    public String updateEmployee(Employee employee) {
        System.out.println(employee.toString());
        Employee result = employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }
}
