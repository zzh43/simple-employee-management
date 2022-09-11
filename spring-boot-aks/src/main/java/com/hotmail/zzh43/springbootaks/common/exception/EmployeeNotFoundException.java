package com.hotmail.zzh43.springbootaks.common.exception;

/**
 * 指定された条件で従業員を見つけられない場合に投げられる例外です。
 */
public class EmployeeNotFoundException extends ApplicationException {

    /**
     * コンストラクタです。
     *
     * @param errorMessage エラーメッセージ
     */
    public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
