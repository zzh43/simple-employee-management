package com.hotmail.zzh43.springbootaks.domain.service;

import static java.util.Objects.isNull;

import com.hotmail.zzh43.springbootaks.common.exception.EmployeeNotFoundException;
import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import com.hotmail.zzh43.springbootaks.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * {@link EmployeeService} の実装クラスです。
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeRepository.findById(id);

        if (isNull(employee)) {
            String errorMessage = "Can not find specified employee.(id=" + id + ")";
            throw new EmployeeNotFoundException(errorMessage);
        }

        return employee;
    }

}
