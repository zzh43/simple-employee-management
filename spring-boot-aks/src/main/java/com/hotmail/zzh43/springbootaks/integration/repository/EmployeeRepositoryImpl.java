package com.hotmail.zzh43.springbootaks.integration.repository;

import static java.util.Objects.nonNull;

import com.hotmail.zzh43.springbootaks.integration.mapper.EmployeeMapper;
import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import com.hotmail.zzh43.springbootaks.domain.repository.EmployeeRepository;
import com.hotmail.zzh43.springbootaks.integration.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * {@link EmployeeRepository} の実装クラスです。
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeMapper employeeMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findById(Integer id) {

        log.info("find employee information by id={}", id);

        EmployeeEntity employeeEntity = employeeMapper.findById(id);

        Employee employee = null;
        if (nonNull(employeeEntity)) {
            employee = employeeEntity.fromEntity();
        }

        return employee;
    }

}
