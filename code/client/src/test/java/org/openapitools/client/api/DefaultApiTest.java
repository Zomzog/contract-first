package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.model.Pony;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().buildClient(DefaultApi.class);
    }

    
    /**
     * Create
     *
     * 
     */
    @Test
    public void createTest() {
        Pony pony = null;
        // Pony response = api.create(pony);

        // TODO: test validations
    }

    
    /**
     * Delete one
     *
     * 
     */
    @Test
    public void deleteOneTest() {
        String ponyId = null;
        // api.deleteOne(ponyId);

        // TODO: test validations
    }

    
    /**
     * Get one
     *
     * 
     */
    @Test
    public void getOneTest() {
        String ponyId = null;
        // Pony response = api.getOne(ponyId);

        // TODO: test validations
    }

    
    /**
     * List
     *
     * 
     */
    @Test
    public void listTest() {
        String name = null;
        // List<Pony> response = api.list(name);

        // TODO: test validations
    }

    /**
     * List
     *
     * 
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    public void listTestQueryMap() {
        DefaultApi.ListQueryParams queryParams = new DefaultApi.ListQueryParams()
            .name(null);
        // List<Pony> response = api.list(queryParams);

    // TODO: test validations
    }
    
    /**
     * Update
     *
     * 
     */
    @Test
    public void updateTest() {
        String ponyId = null;
        Pony pony = null;
        // Pony response = api.update(ponyId, pony);

        // TODO: test validations
    }

    
}
