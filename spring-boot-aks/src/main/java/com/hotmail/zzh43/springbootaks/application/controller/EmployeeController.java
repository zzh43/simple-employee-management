package com.hotmail.zzh43.springbootaks.application.controller;

import com.hotmail.zzh43.springbootaks.application.payload.GetEmployeeResponse;
import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import com.hotmail.zzh43.springbootaks.domain.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * employee に関する REST API を提供するコントローラです。
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final String requestInfoMessage = ">>> request = {}";

    private final String responseInfoMessage = "<<< response = {}";

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetEmployeeResponse getEmployee(@PathVariable Integer id) {

        log.info(requestInfoMessage, "id=" + id);

        Employee employee = employeeService.findById(id);

        log.info(responseInfoMessage, employee);
        return GetEmployeeResponse.of(employee);
    }

}
