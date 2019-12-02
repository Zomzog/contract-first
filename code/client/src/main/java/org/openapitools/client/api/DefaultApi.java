package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.EncodingUtils;

import org.openapitools.client.model.Pony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-12-02T22:53:59.327+01:00[Europe/Paris]")
public interface DefaultApi extends ApiClient.Api {


  /**
   * Create
   * 
   * @param pony  (optional)
   * @return Pony
   */
  @RequestLine("POST /ponies")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Pony create(Pony pony);

  /**
   * Delete one
   * 
   * @param ponyId  (required)
   */
  @RequestLine("DELETE /ponies/{ponyId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteOne(@Param("ponyId") String ponyId);

  /**
   * Get one
   * 
   * @param ponyId  (required)
   * @return Pony
   */
  @RequestLine("GET /ponies/{ponyId}")
  @Headers({
    "Accept: application/json",
  })
  Pony getOne(@Param("ponyId") String ponyId);

  /**
   * List
   * 
   * @param name  (optional)
   * @return List&lt;Pony&gt;
   */
  @RequestLine("GET /ponies?name={name}")
  @Headers({
    "Accept: application/json",
  })
  List<Pony> list(@Param("name") String name);

  /**
   * List
   * 
   * Note, this is equivalent to the other <code>list</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ListQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>name -  (optional)</li>
   *   </ul>
   * @return List&lt;Pony&gt;
   */
  @RequestLine("GET /ponies?name={name}")
  @Headers({
  "Accept: application/json",
  })
  List<Pony> list(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>list</code> method in a fluent style.
   */
  public static class ListQueryParams extends HashMap<String, Object> {
    public ListQueryParams name(final String value) {
      put("name", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update
   * 
   * @param ponyId  (required)
   * @param pony  (optional)
   * @return Pony
   */
  @RequestLine("PUT /ponies/{ponyId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Pony update(@Param("ponyId") String ponyId, Pony pony);
}
