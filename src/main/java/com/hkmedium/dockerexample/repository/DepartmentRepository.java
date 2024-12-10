package com.hkmedium.dockerexample.repository;

import com.hkmedium.dockerexample.dto.EmployeeDTO;
import com.hkmedium.dockerexample.entity.Department;
import com.hkmedium.dockerexample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("SELECT d.employees FROM Department d WHERE d.depId = :depId")
    Set<Employee> findEmployeesByDepartmentId(@Param("depId") int depId);

    @Query("SELECT new com.hkmedium.dockerexample.dto.EmployeeDTO(e.employeeId, e.employeeName, e.department.depId, e.department.departmentName) " +
            "FROM Department d JOIN d.employees e WHERE d.depId = :depId")
    Set<EmployeeDTO> findEmployeeDTOsByDepartmentId(@Param("depId") int depId);

}
