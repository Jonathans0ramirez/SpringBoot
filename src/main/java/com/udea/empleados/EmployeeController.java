package com.udea.empleados;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin("*")
@RequestMapping("/empleados")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/")
    String home() {
        return "Bienvenidos a la UdeA ";
    }

    @ApiOperation(value = "Add an employee")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employee create(@ApiParam(value = "Employee object store in database table", required = true) @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Delete an employee")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public void deleteById(@ApiParam(value = "Employee object delete from database table", 
            required = true) @PathVariable String employeeId) throws Exception {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (!emp.isPresent()) {
            throw new Exception("No se pudo encontrar empleado con el id- " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }

    @ApiOperation(value = "Update an employee")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    public Employee update(@ApiParam(value = "Employee object update from database table", 
            required = true) @RequestBody Employee employee, @PathVariable String employeeId) throws Exception {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        if (!emp.isPresent()) {
            throw new Exception("No se pudo encontrar empleado con el id- " + employeeId);
        }if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            employee.setEmail(emp.get().getEmail());
        }if (employee.getFullName() == null || employee.getFullName().isEmpty()) {
            employee.setFullName(emp.get().getFullName());
        }if (employee.getManagerEmail() == null || employee.getManagerEmail().isEmpty()) {
            employee.setManagerEmail(emp.get().getManagerEmail());
        }if (employee.getSalario() == null || employee.getSalario().isEmpty()) {
            employee.setSalario(emp.get().getSalario());
        }if (employee.getCargo() == null || employee.getCargo().isEmpty()) {
            employee.setCargo(emp.get().getCargo());
        }if (employee.getDireccion() == null || employee.getDireccion().isEmpty()) {
            employee.setDireccion(emp.get().getDireccion());
        }if (employee.getOficina() == null || employee.getOficina().isEmpty()) {
            employee.setOficina(emp.get().getOficina());
        }if (employee.getDependencia() == null || employee.getDependencia().isEmpty()) {
            employee.setDependencia(emp.get().getDependencia());
        }
        employee.setId(employeeId);
        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Get an employee by Id")
    @RequestMapping(method = RequestMethod.GET, value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Employee> get(@ApiParam(value = "Employee id from which employee object will retrieve", 
            required = true) @PathVariable String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list")
        ,
    @ApiResponse(code = 401, message = "You are not authorized to view the resource")
        ,
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
        ,
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Employee> empleados() {
        return employeeRepository.findAll();
    }

    @GetMapping("/findAll")
    public List<Employee> retrieveAllEmployees() {
        return employeeRepository.findAll();
    }
}
