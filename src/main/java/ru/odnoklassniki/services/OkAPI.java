package ru.odnoklassniki.services;

import ru.odnoklassniki.ApiClient;
import ru.odnoklassniki.responses.bookmark.BookmarkAddResponse;

/**
 * @author
 * @created Клиент к API с сервисами
 */
public class OkAPI {
    private ApiClient apiClient;

    public ApiClient getApiClient() {
        return apiClient;
    }

    private OkAPI(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public static OkAPI create(ApiClient apiClient) {
        return new OkAPI(apiClient);
    }

    public UserService getUserService() {
        return new UserService(this.apiClient);
    }

    public BookmarkService getBookmarkService() {
        return new BookmarkService(this.apiClient);
    }
//    public DiscussionService getDiscussionService() {
//        return new DiscussionService(this.apiClient);
//    }
}
