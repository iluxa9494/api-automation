package ru.odnoklassniki.tests.bookmark;

import org.junit.Test;
import ru.odnoklassniki.base.ApiTestBase;
import ru.odnoklassniki.common.ApiException;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author
 * @created
 * Тесты на метод bookmark.add
 * Документация https://apiok.ru/dev/methods/rest/bookmark/bookmark.add
 */
public class TestAddNegative extends ApiTestBase {
    private static final Logger LOGGER = Logger.getLogger(TestAddNegative.class.getSimpleName());
    private static final String ERROR_NO_SESSION = "PARAM : Missed required parameter: access_token";
    private static final String REF_ID = "908897643314";
    private static final String BOOKMARK_TYPE = "PHOTO";

    /**
     * Проверка, что метод сессионный и требует указания access_token
     */
    @Test
    public void testMethodThrowsExceptionWhenSessionIsNotSet() {
        LOGGER.info("Проверим, что метод сессионный и требует указания access_token");
        try {
            LOGGER.info("Вызовем метод без сессии");
            okApi.getBookmarkService().add(REF_ID, BOOKMARK_TYPE);
            fail("Метод не кинул ошибку при отсутствии пользовательской сессии");
        } catch (ApiException e) {
            LOGGER.info("Получили ошибку, проверим её текст");
            assertEquals("Неверная ошибка при вызове без сессии", ERROR_NO_SESSION, e.getApiErrorInfo().getErrorMessage());
        }
        LOGGER.info("Метод сессионный и кидает верную ошибку при вызове без сессии");
    }

}