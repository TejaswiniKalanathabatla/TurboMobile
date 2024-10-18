package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.AggregationInfo;
import com.wavemaker.turbomobiles.FlankerAPI.model.DataExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.Downloadable;
import com.wavemaker.turbomobiles.FlankerAPI.model.Page;
import com.wavemaker.turbomobiles.FlankerAPI.model.PhoneFeatures;
import com.wavemaker.turbomobiles.FlankerAPI.model.QueryFilter;
import com.wavemaker.turbomobiles.FlankerAPI.model.StringWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface PhoneFeaturesControllerService {

  /**
   * 
   * Returns the total count of PhoneFeatures instances matching the optional query (q) request param.
    * @param q conditions to filter the results (optional)
   * @return Long
   */
  @RequestLine("GET /flanker_db/PhoneFeatures/count?q={q}")
  @Headers({
    "Accept: */*",  })
  Long phoneFeaturesControllerCountPhoneFeatures(@Param("q") String q);


    /**
     * 
     * Returns the total count of PhoneFeatures instances matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phoneFeaturesControllerCountPhoneFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerCountPhoneFeaturesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   </ul>
     * @return Long
     */
    @RequestLine("GET /flanker_db/PhoneFeatures/count?q={q}")
    @Headers({
    "Accept: */*",    })
    Long phoneFeaturesControllerCountPhoneFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Creates a new PhoneFeatures instance.
    * @param body  (required)
   * @return PhoneFeatures
   */
  @RequestLine("POST /flanker_db/PhoneFeatures")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhoneFeatures phoneFeaturesControllerCreatePhoneFeatures(PhoneFeatures body);

  /**
   * 
   * Deletes the PhoneFeatures instance associated with the given id.
    * @param id  (required)
   * @return Boolean
   */
  @RequestLine("DELETE /flanker_db/PhoneFeatures/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Boolean phoneFeaturesControllerDeletePhoneFeatures(@Param("id") Integer id);

  /**
   * 
   * Updates the PhoneFeatures instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return PhoneFeatures
   */
  @RequestLine("PUT /flanker_db/PhoneFeatures/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhoneFeatures phoneFeaturesControllerEditPhoneFeatures(PhoneFeatures body, @Param("id") Integer id);

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
  @RequestLine("GET /flanker_db/PhoneFeatures/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: application/octet-stream",  })
  Downloadable phoneFeaturesControllerExportPhoneFeatures(@Param("exportType") String exportType, @Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file for the data matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phoneFeaturesControllerExportPhoneFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerExportPhoneFeaturesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/PhoneFeatures/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: application/octet-stream",    })
    Downloadable phoneFeaturesControllerExportPhoneFeatures
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
  @RequestLine("POST /flanker_db/PhoneFeatures/export?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  StringWrapper phoneFeaturesControllerExportPhoneFeaturesAndGetURL(DataExportOptions body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
     * Note, this is equivalent to the other <code>phoneFeaturesControllerExportPhoneFeaturesAndGetURL</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerExportPhoneFeaturesAndGetURLQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneFeatures/export?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    StringWrapper phoneFeaturesControllerExportPhoneFeaturesAndGetURL
    (DataExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of PhoneFeatures instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhoneFeatures/filter?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Page phoneFeaturesControllerFilterPhoneFeatures(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of PhoneFeatures instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
     * Note, this is equivalent to the other <code>phoneFeaturesControllerFilterPhoneFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerFilterPhoneFeaturesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneFeatures/filter?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    Page phoneFeaturesControllerFilterPhoneFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of PhoneFeatures instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/PhoneFeatures?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneFeaturesControllerFindPhoneFeatures(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of PhoneFeatures instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
     * Note, this is equivalent to the other <code>phoneFeaturesControllerFindPhoneFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerFindPhoneFeaturesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/PhoneFeatures?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneFeaturesControllerFindPhoneFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the PhoneFeatures instance associated with the given id.
    * @param id  (required)
   * @return PhoneFeatures
   */
  @RequestLine("GET /flanker_db/PhoneFeatures/{id}")
  @Headers({
    "Accept: */*",  })
  PhoneFeatures phoneFeaturesControllerGetPhoneFeatures(@Param("id") Integer id);

  /**
   * 
   * Returns aggregated result with given aggregation info
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhoneFeatures/aggregations?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phoneFeaturesControllerGetPhoneFeaturesAggregatedValues(AggregationInfo body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns aggregated result with given aggregation info
     * Note, this is equivalent to the other <code>phoneFeaturesControllerGetPhoneFeaturesAggregatedValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerGetPhoneFeaturesAggregatedValuesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneFeatures/aggregations?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phoneFeaturesControllerGetPhoneFeaturesAggregatedValues
    (AggregationInfo body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Partially updates the PhoneFeatures instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return PhoneFeatures
   */
  @RequestLine("PATCH /flanker_db/PhoneFeatures/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhoneFeatures phoneFeaturesControllerPatchPhoneFeatures(PhoneFeatures body, @Param("id") Integer id);

  /**
   * 
   * Returns the list of PhoneFeatures instances matching the search criteria.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhoneFeatures/search?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phoneFeaturesControllerSearchPhoneFeaturesByQueryFilters(List<QueryFilter> body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the list of PhoneFeatures instances matching the search criteria.
     * Note, this is equivalent to the other <code>phoneFeaturesControllerSearchPhoneFeaturesByQueryFilters</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneFeaturesControllerSearchPhoneFeaturesByQueryFiltersQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneFeatures/search?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phoneFeaturesControllerSearchPhoneFeaturesByQueryFilters
    (List<QueryFilter> body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
