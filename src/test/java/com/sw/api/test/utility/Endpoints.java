package com.sw.api.test.utility;

public class Endpoints {

    public static final String base_url = "https://fakerestapi.azurewebsites.net";
    public static final String getActivitiesURL = base_url+"/api/v1/Activities";
    public static final String postActivityURL = base_url +"/api/v1/Activities";

    public static final String deleteActivityURL = base_url +"/api/v1/Activities";
    public static final String putActivityURL = base_url +"/api/v1/Activities";

    public static final String postBookApi= base_url +"/api/v1/Books";

    public static final String postAuthorApi = base_url + "/api/v1/Authors";

    public static final String getAuthorByBookId = base_url + "/api/v1/Authors/authors/books";
}
