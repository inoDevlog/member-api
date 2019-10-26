package ino.codelabs.member.controller;

import ino.codelabs.member.entity.Department;
import ino.codelabs.member.sevice.DepartmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/departments")
    @ApiOperation(value = "전체 부서 조회", notes = "모든 부서를 조회하는 API")
    public ResponseEntity<?> getAllDepartment() {
        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/{id}")
    @ApiOperation(value = "부서 조회", notes = "ID로 부서를 조회하는 API")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "부서 id", paramType = "path", dataType = "long")})
    public ResponseEntity<?> getDepartment(Long id) {
        Department department = departmentService.getDepartment(id);

        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments/name")
    public ResponseEntity<?> getDepartmentByName(@RequestParam String name) {
        Department department = departmentService.getDepartmentByName(name);

        return ResponseEntity.ok(department);
    }

    @PostMapping("/departments")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.updateDepartment(id, department), HttpStatus.OK);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
