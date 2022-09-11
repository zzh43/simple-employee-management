package com.hotmail.zzh43.springbootaks.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hotmail.zzh43.springbootaks.common.exception.EmployeeNotFoundException;
import com.hotmail.zzh43.springbootaks.domain.repository.EmployeeRepository;
import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl target;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void test_従業員idを指定して対応する従業員情報を正常に取得できること() {
        // setup
        Employee employee = Employee.builder()
                                    .id(1)
                                    .lastName("一郎")
                                    .firstName("天王洲")
                                    .fullName("天王洲一郎")
                                    .description("2020年入社")
                                    .build();

        when(employeeRepository.findById(1)).thenReturn(employee);

        // execute
        Employee actual = target.findById(1);

        // assert
        assertThat(actual).isEqualTo(employee);

        // verify
        verify(employeeRepository).findById(1);
    }

    @Test
    void test_存在しない従業員idを指定したら例外が発生すること() {
        // setup
        when(employeeRepository.findById(3)).thenReturn(null);

        // execute
        EmployeeNotFoundException actual = assertThrows(EmployeeNotFoundException.class, () -> target.findById(3));

        // assert
        assertThat(actual.getErrorMessage()).isEqualTo("Can not find specified employee.(id=3)");

        // verify
        verify(employeeRepository).findById(3);
    }

}
