package com.hotmail.zzh43.springbootaks.integration.entity;

import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * employee テーブルのエンティティを表現するクラスです。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable {

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

    /**
     * 従業員エンティティをドメインインスタンスに変換します。
     */
    public Employee fromEntity() {
        return Employee.builder()
                       .id(id)
                       .lastName(lastName)
                       .firstName(firstName)
                       .fullName(fullName)
                       .description(description)
                       .build();
    }

}




