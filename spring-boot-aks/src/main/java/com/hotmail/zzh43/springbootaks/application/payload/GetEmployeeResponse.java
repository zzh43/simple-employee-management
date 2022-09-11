package com.hotmail.zzh43.springbootaks.application.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotmail.zzh43.springbootaks.domain.model.Employee;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * employee 情報取得のレスポンスの Json を表現するくらすです。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("description")
    private String description;

    /**
     * 従業員情報のドメインインスタンスから従業員取得レスポンスを生成します。
     *
     * @param employee 従業員情報のドメインインスタンス
     * @return 従業員情報取得レスポンス
     */
    public static GetEmployeeResponse of(Employee employee) {
        return GetEmployeeResponse.builder()
                                  .id(employee.getId())
                                  .lastName(employee.getLastName())
                                  .firstName(employee.getFirstName())
                                  .fullName(employee.getFullName())
                                  .description(employee.getDescription())
                                  .build();
    }

}
