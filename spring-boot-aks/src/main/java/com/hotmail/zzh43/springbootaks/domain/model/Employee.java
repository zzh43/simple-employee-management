package com.hotmail.zzh43.springbootaks.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員のドメインモデルです。
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    /**
     * 従業員　id
     */
    private Integer id;

    /**
     * 従業員の名
     */
    private String lastName;

    /**
     * 従業員の姓
     */
    private String firstName;

    /**
     * 従業員のフルーネーム
     */
    private String fullName;

    /**
     * 従業員の詳細
     */
    private String description;

}
