package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.DepartmentMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

  private DepartmentRepository departmentRepository;

  @Override
  public DepartmentDto createDepartmentService(DepartmentDto departmentDto) {
    Department department = DepartmentMapper.mapToDepartment(departmentDto);
    Department savedDepartment = departmentRepository.save(department);

    return DepartmentMapper.mapToDepartmentDto(savedDepartment);
  }

  @Override
  public DepartmentDto getDepartmentById(Long departmentId) {
    Department department = departmentRepository.findById(departmentId).orElseThrow(
            () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
    );
    return DepartmentMapper.mapToDepartmentDto(department);
  }

  @Override
  public List<DepartmentDto> getAllDepartments() {
    List<Department> departments = departmentRepository.findAll();
    return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
            .collect(Collectors.toList());
  }

  @Override
  public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment) {

    Department department = departmentRepository.findById(departmentId).orElseThrow(
            () -> new ResourceNotFoundException("Department is not exists withe a given id: " + departmentId)
    );

    department.setDepartmentName(updateDepartment.getDepartmentName());
    department.setDepartmentDescription(updateDepartment.getDepartmentDescription());

    Department updatedDepartment = departmentRepository.save(department);

    return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
  }

  @Override
  public void deleteDepartment(Long departmentId) {
    Department department = departmentRepository.findById(departmentId).orElseThrow(
            () -> new ResourceNotFoundException("Department is not exists withe a given id: " + departmentId)
    );

    departmentRepository.deleteById(departmentId);
  }
}
