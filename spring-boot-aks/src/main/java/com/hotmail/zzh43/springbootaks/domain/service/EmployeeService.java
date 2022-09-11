package com.hotmail.zzh43.springbootaks.domain.service;

import com.hotmail.zzh43.springbootaks.domain.model.Employee;

/**
 * employee 情報を管理するサービスのインタフェースです。
 */
public interface EmployeeService {

    /**
     * 従業員 id を指定して、対応する従業員情報を取得します。
     *
     * @param id 従業員 id
     * @return 従業員情報
     */
    Employee findById(Integer id);

}
