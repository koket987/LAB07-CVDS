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


    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        //employeeService.createEmployee(id,name);

        model.addAttribute("employeeList", employeeList);
        return "employees";
    }
    @PostMapping("/employees/create")
    public String createEmployee(@RequestParam Long employeeId, String firstName,String lastName,String role ,String salary){
        employeeService.createEmployee(employeeId, firstName, lastName, role, salary);
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la creación.
    }

    @PostMapping("/employees/update")
    public String updateEmployee(@RequestParam Long employeeId, String firstName,String lastName,String role ,String salary){
        employeeService.updateEmployee(employeeId, firstName, lastName, role, salary);
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la actualización.
    }

    @PostMapping("/employees/delete")
    public String deleteEmployee(@RequestParam Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees"; // Redirige a la página de lista de empleados después de la actualización.
    }


}
