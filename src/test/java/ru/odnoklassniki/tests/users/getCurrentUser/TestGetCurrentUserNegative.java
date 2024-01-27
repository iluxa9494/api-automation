package ru.odnoklassniki.tests.users.getCurrentUser;

import org.junit.Test;
import ru.odnoklassniki.base.ApiTestBase;
import ru.odnoklassniki.common.ApiException;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author
 * @created
 * Тесты на метод users.getCurrentUser
 * Документация https://apiok.ru/dev/methods/rest/users/users.getCurrentUser
 */
public class TestGetCurrentUserNegative extends ApiTestBase {
    private static final Logger LOGGER = Logger.getLogger(TestGetCurrentUserPositive.class.getSimpleName());
    private static final String ERROR_NO_SESSION = "PARAM : Missed required parameter: access_token";

    /**
     * Проверка, что метод сессионный и требует указания access_token
     */
    @Test
    public void testMethodThrowsExceptionWhenSessionIsNotSet() {
        LOGGER.info("Проверим, что метод сессионный и требует указания access_token");
        try {
            LOGGER.info("Вызовем метод без сессии");
            okApi.getUserService().getCurrentUser();
            fail("Метод не кинул ошибку при отсутствии пользовательской сессии");
        } catch (ApiException e) {
            LOGGER.info("Получили ошибку, проверим её текст");
            assertEquals("Неверная ошибка при вызове без сессии", ERROR_NO_SESSION, e.getApiErrorInfo().getErrorMessage());
        }
        LOGGER.info("Метод сессионный и кидает верную ошибку при вызове без сессии");
    }
}