package org.openapitools.client;

import feign.Feign;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.Pony;

public class Main {
    public static void main(String[] args) {
        DefaultApi apiClient = new ApiClient()
                .setBasePath("http://localhost:8080")
                .buildClient(DefaultApi.class);

        Pony id = apiClient.getOne("id");
        System.out.println("id = " + id);
    }
}
