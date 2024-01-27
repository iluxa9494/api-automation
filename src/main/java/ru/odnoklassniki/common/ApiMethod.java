package ru.odnoklassniki.common;

/**
 * @author
 * @created Список API-методов
 */
public enum ApiMethod {
    USERS_GET_CURRENT_USER("users", "getCurrentUser"),
    ADD("bookmark", "add");

    private String methodGroup;
    private String methodName;

    ApiMethod(String methodGroup, String methodName) {
        this.methodGroup = methodGroup;
        this.methodName = methodName;
    }

    public String getMethodGroup() {
        return methodGroup;
    }

    public String getMethodName() {
        return methodName;
    }
}
