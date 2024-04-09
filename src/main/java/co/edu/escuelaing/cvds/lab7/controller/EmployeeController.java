package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("api/employees")
    @ResponseBody
    public List<Employee> employeesApi(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        //employeeService.createEmployee(id,name);

        model.addAttribute("employeeList", employeeList);
        return employeeList;
    }
    @GetMapping("api/employees/{employeeId}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
    @GetMapping("api/employees/main")
    public String employees(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        //employeeService.createEmployee(id,name);

        model.addAttribute("employeeList", employeeList);
        return "employees";
    }
    @PostMapping("api/employees")
    @ResponseBody
    public List<Employee> createEmployee(@RequestBody Employee request){
        employeeService.createEmployee(request.getEmployeeId(), request.getFirstName(),
                request.getLastName(), request.getRole(), request.getSalary());
        return employeeService.getAll();
    }

    @PutMapping("api/employees/{employeeId}")
    @ResponseBody
    public List<Employee> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee request){
        employeeService.updateEmployee(employeeId, request.getFirstName(),
                request.getLastName(), request.getRole(), request.getSalary());
        return employeeService.getAll();
    }

    @DeleteMapping("/api/employees/{employeeId}")
    @ResponseBody
    public List<Employee> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return employeeService.getAll();
    }


}
