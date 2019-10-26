package ino.codelabs.member.sevice;

import ino.codelabs.member.entity.Department;
import ino.codelabs.member.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(Long id) { //혹시 모를 null 처리를 위해서 Long 지정
        Department department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        } else {
            return department;
        }
    }

    public Department getDepartmentByName(String name) {
        Department department = departmentRepository.findByName(name).orElse(null);

        if (department == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        } else {
            return department;
        }
    }

    public Department createDepartment(Department department) {
        department.setCurrentTime();
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department) {
        Department savedDepartment = departmentRepository.findById(id).orElse(null);

        if (savedDepartment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        } else {
            savedDepartment.update(department);
            return departmentRepository.save(savedDepartment);
        }
    }

    public void deleteDepartment(Long id) {
        if (departmentRepository.findById(id).isPresent()) {
            departmentRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department not found");
        }
    }
}
