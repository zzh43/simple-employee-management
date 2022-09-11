package com.hotmail.zzh43.springbootaks.common.exception;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

/**
 * サンプルアプリのアプリケーション例外を表現するクラスです。
 */
@Value
@NonFinal
@Builder
public class ApplicationException extends RuntimeException {

    String errorMessage;

    /**
     * 指定されたエラーメッセージと原因で {@link ApplicationException} を構築します。
     *
     * @param errorMessage エラーメッセージ
     */
    public ApplicationException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

}
