package ivandjoh.online.department.service.impl;

import ivandjoh.online.department.entity.Department;
import ivandjoh.online.department.exception.BadRequestException;
import ivandjoh.online.department.exception.NotFoundException;
import ivandjoh.online.department.repository.DepartmentRepository;
import ivandjoh.online.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addNewDepartment(Department department) {
        try {
            if (department == null) {
                throw new NotFoundException("Department is empty!");
            }
            log.info("Add New Department - {}", department);
            return departmentRepository.save(department);
        } catch (Exception e) {
            throw new BadRequestException("Bad Request!");
        }
    }

    @Override
    public Department getDepartmentById(Long id) {
        try {
            if (id == null) {
                throw new NotFoundException("Department Id is empty!");
            }
            log.info("Get Department By Id - {}", id);
            return departmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Department not found!"));
        } catch (Exception e) {
            throw new BadRequestException("Bad Request!");
        }
    }
}
