package ru.odnoklassniki.common;

import org.apache.http.Header;

import java.util.Arrays;

/**
 * @author
 * @created
 * Ошибка, произошедшая при выполнении запроса к API
 */
public class ApiException extends Exception {
    private static final long serialVersionUID = -2417699943099954494L;
    private Header[] headers = new Header[0];
    private ApiErrorInfo apiErrorInfo;

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public void setApiErrorInfo(ApiErrorInfo apiErrorInfo) {
        this.apiErrorInfo = apiErrorInfo;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public ApiErrorInfo getApiErrorInfo() {
        return apiErrorInfo;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "headers=" + Arrays.toString(headers) +
                ", apiErrorInfo=" + apiErrorInfo +
                '}';
    }
}
