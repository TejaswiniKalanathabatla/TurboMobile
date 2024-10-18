package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.AggregationInfo;
import com.wavemaker.turbomobiles.FlankerAPI.model.DataExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.Downloadable;
import com.wavemaker.turbomobiles.FlankerAPI.model.Page;
import com.wavemaker.turbomobiles.FlankerAPI.model.PhonePricePlanFeatures;
import com.wavemaker.turbomobiles.FlankerAPI.model.QueryFilter;
import com.wavemaker.turbomobiles.FlankerAPI.model.StringWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface PhonePricePlanFeaturesControllerService {

  /**
   * 
   * Returns the total count of PhonePricePlanFeatures instances matching the optional query (q) request param.
    * @param q conditions to filter the results (optional)
   * @return Long
   */
  @RequestLine("GET /flanker_db/PhonePricePlanFeatures/count?q={q}")
  @Headers({
    "Accept: */*",  })
  Long phonePricePlanFeaturesControllerCountPhonePricePlanFeatures(@Param("q") String q);


    /**
     * 
     * Returns the total count of PhonePricePlanFeatures instances matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerCountPhonePricePlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerCountPhonePricePlanFeaturesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   </ul>
     * @return Long
     */
    @RequestLine("GET /flanker_db/PhonePricePlanFeatures/count?q={q}")
    @Headers({
    "Accept: */*",    })
    Long phonePricePlanFeaturesControllerCountPhonePricePlanFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Creates a new PhonePricePlanFeatures instance.
    * @param body  (required)
   * @return PhonePricePlanFeatures
   */
  @RequestLine("POST /flanker_db/PhonePricePlanFeatures")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhonePricePlanFeatures phonePricePlanFeaturesControllerCreatePhonePricePlanFeatures(PhonePricePlanFeatures body);

  /**
   * 
   * Deletes the PhonePricePlanFeatures instance associated with the given id.
    * @param id  (required)
   * @return Boolean
   */
  @RequestLine("DELETE /flanker_db/PhonePricePlanFeatures/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Boolean phonePricePlanFeaturesControllerDeletePhonePricePlanFeatures(@Param("id") Integer id);

  /**
   * 
   * Updates the PhonePricePlanFeatures instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return PhonePricePlanFeatures
   */
  @RequestLine("PUT /flanker_db/PhonePricePlanFeatures/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhonePricePlanFeatures phonePricePlanFeaturesControllerEditPhonePricePlanFeatures(PhonePricePlanFeatures body, @Param("id") Integer id);

  /**
   * 
   * Returns downloadable file for the data matching the optional query (q) request param.
    * @param exportType  (required)
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Downloadable
   */
  @RequestLine("GET /flanker_db/PhonePricePlanFeatures/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: application/octet-stream",  })
  Downloadable phonePricePlanFeaturesControllerExportPhonePricePlanFeatures(@Param("exportType") String exportType, @Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file for the data matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerExportPhonePricePlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerExportPhonePricePlanFeaturesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param exportType  (required)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Downloadable
     */
    @RequestLine("GET /flanker_db/PhonePricePlanFeatures/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: application/octet-stream",    })
    Downloadable phonePricePlanFeaturesControllerExportPhonePricePlanFeatures
    (@Param("exportType") String exportType, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return StringWrapper
   */
  @RequestLine("POST /flanker_db/PhonePricePlanFeatures/export?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  StringWrapper phonePricePlanFeaturesControllerExportPhonePricePlanFeaturesAndGetURL(DataExportOptions body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerExportPhonePricePlanFeaturesAndGetURL</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerExportPhonePricePlanFeaturesAndGetURLQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param body  (required)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return StringWrapper
     */
    @RequestLine("POST /flanker_db/PhonePricePlanFeatures/export?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    StringWrapper phonePricePlanFeaturesControllerExportPhonePricePlanFeaturesAndGetURL
    (DataExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of PhonePricePlanFeatures instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhonePricePlanFeatures/filter?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Page phonePricePlanFeaturesControllerFilterPhonePricePlanFeatures(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of PhonePricePlanFeatures instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerFilterPhonePricePlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerFilterPhonePricePlanFeaturesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Page
     */
    @RequestLine("POST /flanker_db/PhonePricePlanFeatures/filter?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    Page phonePricePlanFeaturesControllerFilterPhonePricePlanFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of PhonePricePlanFeatures instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/PhonePricePlanFeatures?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phonePricePlanFeaturesControllerFindPhonePricePlanFeatures(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of PhonePricePlanFeatures instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerFindPhonePricePlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerFindPhonePricePlanFeaturesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Page
     */
    @RequestLine("GET /flanker_db/PhonePricePlanFeatures?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phonePricePlanFeaturesControllerFindPhonePricePlanFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the PhonePricePlanFeatures instance associated with the given id.
    * @param id  (required)
   * @return PhonePricePlanFeatures
   */
  @RequestLine("GET /flanker_db/PhonePricePlanFeatures/{id}")
  @Headers({
    "Accept: */*",  })
  PhonePricePlanFeatures phonePricePlanFeaturesControllerGetPhonePricePlanFeatures(@Param("id") Integer id);

  /**
   * 
   * Returns aggregated result with given aggregation info
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhonePricePlanFeatures/aggregations?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phonePricePlanFeaturesControllerGetPhonePricePlanFeaturesAggregatedValues(AggregationInfo body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns aggregated result with given aggregation info
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerGetPhonePricePlanFeaturesAggregatedValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerGetPhonePricePlanFeaturesAggregatedValuesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param body  (required)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Page
     */
    @RequestLine("POST /flanker_db/PhonePricePlanFeatures/aggregations?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phonePricePlanFeaturesControllerGetPhonePricePlanFeaturesAggregatedValues
    (AggregationInfo body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Partially updates the PhonePricePlanFeatures instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return PhonePricePlanFeatures
   */
  @RequestLine("PATCH /flanker_db/PhonePricePlanFeatures/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhonePricePlanFeatures phonePricePlanFeaturesControllerPatchPhonePricePlanFeatures(PhonePricePlanFeatures body, @Param("id") Integer id);

  /**
   * 
   * Returns the list of PhonePricePlanFeatures instances matching the search criteria.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhonePricePlanFeatures/search?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phonePricePlanFeaturesControllerSearchPhonePricePlanFeaturesByQueryFilters(List<QueryFilter> body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the list of PhonePricePlanFeatures instances matching the search criteria.
     * Note, this is equivalent to the other <code>phonePricePlanFeaturesControllerSearchPhonePricePlanFeaturesByQueryFilters</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhonePricePlanFeaturesControllerSearchPhonePricePlanFeaturesByQueryFiltersQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param body  (required)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Page
     */
    @RequestLine("POST /flanker_db/PhonePricePlanFeatures/search?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phonePricePlanFeaturesControllerSearchPhonePricePlanFeaturesByQueryFilters
    (List<QueryFilter> body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
