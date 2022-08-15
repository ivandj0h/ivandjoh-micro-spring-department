package ivandjoh.online.department.service;

import ivandjoh.online.department.entity.Department;

public interface DepartmentService {
    Department addNewDepartment(Department department);

    Department getDepartmentById(Long id);
}
