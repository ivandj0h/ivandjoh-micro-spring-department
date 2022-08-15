package ivandjoh.online.department.controller;

import ivandjoh.online.department.entity.Department;
import ivandjoh.online.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department/add")
    public Department addNewDepartment(
            @RequestBody Department department
    ) {
        log.info("Add New Department");
        return departmentService.addNewDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(
            @PathVariable Long id
    ) {
        log.info("Get Department");
        return departmentService.getDepartmentById(id);
    }
}
