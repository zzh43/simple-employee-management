package com.hotmail.zzh43.springbootaks.domain.repository;

import com.hotmail.zzh43.springbootaks.domain.model.Employee;

/**
 * employee テーブルのリポジトリのインタフェースです。
 */
public interface EmployeeRepository {

    /**
     * 従業員 id を指定して対応する employee のドメインインスタンスを取得します。
     *
     * @param id 従業員 id
     * @return id に対応する employee のドメインインスタンス
     */
    Employee findById(Integer id);

}
