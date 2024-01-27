package ru.odnoklassniki.tests.bookmark;

import org.junit.Test;
import ru.odnoklassniki.base.ApiTestBase;
import ru.odnoklassniki.responses.bookmark.BookmarkAddResponse;
import ru.odnoklassniki.tests.users.getCurrentUser.TestGetCurrentUserPositive;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

/**
 * @author
 * @created Тесты на метод bookmark.add
 * Документация https://apiok.ru/dev/methods/rest/bookmark/bookmark.add
 */
public class TestAddPositive extends ApiTestBase {
    private static final Logger LOGGER = Logger.getLogger(TestGetCurrentUserPositive.class.getSimpleName());
    private static final String REF_ID = "908897643314";
    private static final String BOOKMARK_TYPE = "PHOTO";

    @Test
    public void testAddOwnVideoPublic() throws Exception {
        LOGGER.info("Проверка добавления в закладки фото друга");
        bindSession("","");
        BookmarkAddResponse bookmarkAddResponse = okApi.getBookmarkService().add(REF_ID, BOOKMARK_TYPE);
        assertTrue("Ошибка в добавлении закладки", bookmarkAddResponse.getSuccess());
        LOGGER.info("Успешно проверили добавление фото друга в закладки");
    }
}
