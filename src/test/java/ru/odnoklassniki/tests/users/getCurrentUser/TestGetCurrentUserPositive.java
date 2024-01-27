package ru.odnoklassniki.tests.users.getCurrentUser;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import ru.odnoklassniki.base.ApiTestBase;
import ru.odnoklassniki.common.ApiException;
import ru.odnoklassniki.common.UserInfoField;
import ru.odnoklassniki.responses.users.UsersGetCurrentUserResponse;

import java.util.logging.Logger;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author
 * @created Тесты на метод users.getCurrentUser
 * Документация https://apiok.ru/dev/methods/rest/users/users.getCurrentUser
 */
public class TestGetCurrentUserPositive extends ApiTestBase {
    private static final Logger LOGGER = Logger.getLogger(TestGetCurrentUserPositive.class.getSimpleName());

    /**
     * Проверка, что по дефолту метод возвращает имя и фамилию пользователя
     */
    @Test
    public void testLastNameAndFirstNameAreReturnedByDefault() throws ApiException {
        LOGGER.info("Проверим, что по дефолту метод возвращает имя и фамилию пользователя");

        LOGGER.info("Вызовем метод в сессии пользователя");
        bindDefaultUserSession();
        UsersGetCurrentUserResponse getCurrentUserResponse = okApi.getUserService().getCurrentUser();

        LOGGER.info("Проверим, что в ответе есть непустые имя и фамилия");
        assertTrue("Пустое имя пользователя", StringUtils.isNotBlank(getCurrentUserResponse.getFirstName()));
        assertTrue("Пустая фамилия пользователя", StringUtils.isNotBlank(getCurrentUserResponse.getLastName()));
        LOGGER.info("Метод по дефолту возвращает имя и фамилию");
    }

    /**
     * Проверка, что учитывается параметр fields и в ответе возвращаются только запрошенные поля
     */
    @Test
    public void testFieldsParam() throws ApiException {
        LOGGER.info("Проверим, что учитывается параметр fields и в ответе возвращаются только запрошенные поля");

        LOGGER.info("Вызовем метод в сессии пользователя");
        bindDefaultUserSession();
        UsersGetCurrentUserResponse getCurrentUserResponse = okApi.getUserService().getCurrentUser(new UserInfoField[]{UserInfoField.FIRST_NAME});

        LOGGER.info("Проверим, что в ответе есть запрошенное поле");
        assertTrue("Пустое имя пользователя", StringUtils.isNotBlank(getCurrentUserResponse.getFirstName()));

        LOGGER.info("Проверим, что в ответе нет не запрошенного поля");
        assertNull("Пустая фамилия пользователя", getCurrentUserResponse.getLastName());
        LOGGER.info("Учитывается параметр fields и в ответе возвращаются только запрошенные поля");
    }
}
