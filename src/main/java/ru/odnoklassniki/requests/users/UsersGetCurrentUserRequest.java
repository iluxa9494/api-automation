package ru.odnoklassniki.requests.users;

import ru.odnoklassniki.common.ApiMethod;
import ru.odnoklassniki.common.UserInfoField;
import ru.odnoklassniki.requests.ApiRequest;
import ru.odnoklassniki.requests.ApiRequestConstants;

/**
 * @author
 * @created Запрос на выполнение метода users.getCurrentUser
 * Документация: https://apiok.ru/dev/methods/rest/users/users.getCurrentUser
 */
public class UsersGetCurrentUserRequest extends ApiRequest {
    public UsersGetCurrentUserRequest() {
        this.setApiMethod(ApiMethod.USERS_GET_CURRENT_USER);
    }

    public UsersGetCurrentUserRequest(UserInfoField[] userInfoFields) {
        this.setApiMethod(ApiMethod.USERS_GET_CURRENT_USER).addParam(ApiRequestConstants.FIELDS_PARAM, userInfoFields);
    }
}