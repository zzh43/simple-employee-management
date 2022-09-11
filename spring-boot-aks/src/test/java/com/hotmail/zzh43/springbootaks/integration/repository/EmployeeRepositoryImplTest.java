package com.hotmail.zzh43.springbootaks.integration.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import com.hotmail.zzh43.springbootaks.integration.mapper.EmployeeMapper;
import com.hotmail.zzh43.springbootaks.integration.entity.EmployeeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryImplTest {

    @InjectMocks
    private EmployeeRepositoryImpl target;

    @Mock
    private EmployeeMapper employeeMapper;

    @Test
    void test_従業員idを指定して対応する従業員情報を正常に取得できること() {
        // setup
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                                                      .id(1)
                                                      .lastName("一郎")
                                                      .firstName("天王洲")
                                                      .fullName("天王洲一郎")
                                                      .description("2020年入社")
                                                      .build();

        when(employeeMapper.findById(1)).thenReturn(employeeEntity);

        Employee expected = Employee.builder()
                                    .id(1)
                                    .lastName("一郎")
                                    .firstName("天王洲")
                                    .fullName("天王洲一郎")
                                    .description("2020年入社")
                                    .build();

        // execute
        Employee actual = target.findById(1);

        // assert
        assertThat(actual).isEqualTo(expected);

        // verify
        verify(employeeMapper).findById(1);
    }

    @Test
    void test_存在していない従業員idを指定して取得するとnullが返されること() {
        // setup
        when(employeeMapper.findById(3)).thenReturn(null);

        // execute
        Employee actual = target.findById(3);

        // assert
        assertThat(actual).isNull();

        // verify
        verify(employeeMapper).findById(3);
    }

}
