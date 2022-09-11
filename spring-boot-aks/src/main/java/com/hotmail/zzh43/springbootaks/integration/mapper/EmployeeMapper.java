package com.hotmail.zzh43.springbootaks.integration.mapper;

import com.hotmail.zzh43.springbootaks.integration.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * employee テーブルの Mapper を表現するクラスです。
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 従業員 id を指定して対応する従業員の情報を取得します。
     *
     * @param id 従業員 id
     * @return 従業員の情報
     */
    @Select({
            " SELECT *          " +
            " FROM              " +
            "        employee   " +
            " WHERE             " +
            "        id = #{id} "
    })
    EmployeeEntity findById(Integer id);

}
