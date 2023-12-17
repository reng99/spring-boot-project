package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.bean.Person;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  private DepartmentService departmentService;

  // Build Add department REST API
  @PostMapping
  public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
    DepartmentDto saveDepartmentDto = departmentService.createDepartmentService(departmentDto);
    return new ResponseEntity<>(saveDepartmentDto, HttpStatus.CREATED);
  }

  // Build Get department REST API
  @GetMapping("{id}")
  public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
    DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
    return ResponseEntity.ok(departmentDto);
  }

  // Build Get all departments REST API
  @GetMapping
  public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
    List<DepartmentDto> departmentsDto = departmentService.getAllDepartments();

    return ResponseEntity.ok(departmentsDto);
  }

  // Build Update department REST API
  @PutMapping("{id}")
  public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto updatedDepartmentDto) {
    DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartmentDto);
    return ResponseEntity.ok(departmentDto);
  }

  // Build Delete department REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
    departmentService.deleteDepartment(departmentId);
    return ResponseEntity.ok("Department deleted successfully!");
  }

  @RequestMapping("/request-body")
  public String requestBodyDemo(@RequestBody Person person) {
    return "Hello, " + person.getUsername() + "!";
  }
  

}
