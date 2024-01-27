package ru.odnoklassniki.services;

import ru.odnoklassniki.ApiClient;
import ru.odnoklassniki.common.ApiException;
import ru.odnoklassniki.common.UserInfoField;
import ru.odnoklassniki.requests.users.UsersGetCurrentUserRequest;
import ru.odnoklassniki.responses.users.UsersGetCurrentUserResponse;

/**
 * @author
 * @created
 * Сервис для выполнения методов группы users: https://apiok.ru/dev/methods/rest/users/
 */
public class UserService {
    private ApiClient apiClient;

    UserService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получение информации о текущем пользователе
     * @param userInfoFields список полей, которые надо получить в ответе
     */
    public UsersGetCurrentUserResponse getCurrentUser(UserInfoField[] userInfoFields) throws ApiException {
        UsersGetCurrentUserRequest getCurrentUserRequest = new UsersGetCurrentUserRequest(userInfoFields);
        return apiClient.executeRequest(getCurrentUserRequest, UsersGetCurrentUserResponse.class);
    }

    /**
     * Получение информации о текущем пользователе с дефолтным набором полей в ответе
     */
    public UsersGetCurrentUserResponse getCurrentUser() throws ApiException {
        UsersGetCurrentUserRequest getCurrentUserRequest = new UsersGetCurrentUserRequest();
        return apiClient.executeRequest(getCurrentUserRequest, UsersGetCurrentUserResponse.class);
    }
}
