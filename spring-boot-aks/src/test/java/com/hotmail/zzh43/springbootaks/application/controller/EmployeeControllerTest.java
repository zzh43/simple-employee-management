package com.hotmail.zzh43.springbootaks.application.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotmail.zzh43.springbootaks.application.payload.GetEmployeeResponse;
import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import com.hotmail.zzh43.springbootaks.domain.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void test_従業員idを指定して取得結果リスポンスが返されること() throws Exception {
        // setup
        Employee employee = Employee.builder()
                                    .id(1)
                                    .lastName("一郎")
                                    .firstName("天王洲")
                                    .fullName("天王洲一郎")
                                    .description("2020年入社")
                                    .build();

        when(employeeService.findById(1)).thenReturn(employee);

        GetEmployeeResponse expectedResponse = GetEmployeeResponse.builder()
                                                                  .id(1)
                                                                  .lastName("一郎")
                                                                  .firstName("天王洲")
                                                                  .fullName("天王洲一郎")
                                                                  .description("2020年入社")
                                                                  .build();

        String expected = objectMapper.writeValueAsString(expectedResponse);

        // execute
        mockMvc.perform(get("/v1/employee/1"))
               .andExpect(status().isOk())
               .andExpect(content().json(expected));

        // verify
        verify(employeeService).findById(1);
    }

}
