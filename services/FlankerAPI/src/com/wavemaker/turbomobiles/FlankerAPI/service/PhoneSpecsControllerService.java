package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.AggregationInfo;
import com.wavemaker.turbomobiles.FlankerAPI.model.DataExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.Downloadable;
import com.wavemaker.turbomobiles.FlankerAPI.model.Page;
import com.wavemaker.turbomobiles.FlankerAPI.model.PhoneSpecs;
import com.wavemaker.turbomobiles.FlankerAPI.model.QueryFilter;
import com.wavemaker.turbomobiles.FlankerAPI.model.StringWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface PhoneSpecsControllerService {

  /**
   * 
   * Returns the total count of PhoneSpecs instances matching the optional query (q) request param.
    * @param q conditions to filter the results (optional)
   * @return Long
   */
  @RequestLine("GET /flanker_db/PhoneSpecs/count?q={q}")
  @Headers({
    "Accept: */*",  })
  Long phoneSpecsControllerCountPhoneSpecs(@Param("q") String q);


    /**
     * 
     * Returns the total count of PhoneSpecs instances matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phoneSpecsControllerCountPhoneSpecs</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerCountPhoneSpecsQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   </ul>
     * @return Long
     */
    @RequestLine("GET /flanker_db/PhoneSpecs/count?q={q}")
    @Headers({
    "Accept: */*",    })
    Long phoneSpecsControllerCountPhoneSpecs
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Creates a new PhoneSpecs instance.
    * @param body  (required)
   * @return PhoneSpecs
   */
  @RequestLine("POST /flanker_db/PhoneSpecs")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhoneSpecs phoneSpecsControllerCreatePhoneSpecs(PhoneSpecs body);

  /**
   * 
   * Deletes the PhoneSpecs instance associated with the given id.
    * @param id  (required)
   * @return Boolean
   */
  @RequestLine("DELETE /flanker_db/PhoneSpecs/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Boolean phoneSpecsControllerDeletePhoneSpecs(@Param("id") Integer id);

  /**
   * 
   * Updates the PhoneSpecs instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return PhoneSpecs
   */
  @RequestLine("PUT /flanker_db/PhoneSpecs/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhoneSpecs phoneSpecsControllerEditPhoneSpecs(PhoneSpecs body, @Param("id") Integer id);

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
  @RequestLine("GET /flanker_db/PhoneSpecs/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: application/octet-stream",  })
  Downloadable phoneSpecsControllerExportPhoneSpecs(@Param("exportType") String exportType, @Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file for the data matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phoneSpecsControllerExportPhoneSpecs</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerExportPhoneSpecsQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/PhoneSpecs/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: application/octet-stream",    })
    Downloadable phoneSpecsControllerExportPhoneSpecs
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
  @RequestLine("POST /flanker_db/PhoneSpecs/export?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  StringWrapper phoneSpecsControllerExportPhoneSpecsAndGetURL(DataExportOptions body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
     * Note, this is equivalent to the other <code>phoneSpecsControllerExportPhoneSpecsAndGetURL</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerExportPhoneSpecsAndGetURLQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneSpecs/export?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    StringWrapper phoneSpecsControllerExportPhoneSpecsAndGetURL
    (DataExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of PhoneSpecs instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhoneSpecs/filter?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Page phoneSpecsControllerFilterPhoneSpecs(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of PhoneSpecs instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
     * Note, this is equivalent to the other <code>phoneSpecsControllerFilterPhoneSpecs</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerFilterPhoneSpecsQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneSpecs/filter?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    Page phoneSpecsControllerFilterPhoneSpecs
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of PhoneSpecs instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/PhoneSpecs?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneSpecsControllerFindPhoneSpecs(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of PhoneSpecs instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
     * Note, this is equivalent to the other <code>phoneSpecsControllerFindPhoneSpecs</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerFindPhoneSpecsQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/PhoneSpecs?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneSpecsControllerFindPhoneSpecs
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the PhoneSpecs instance associated with the given id.
    * @param id  (required)
   * @return PhoneSpecs
   */
  @RequestLine("GET /flanker_db/PhoneSpecs/{id}")
  @Headers({
    "Accept: */*",  })
  PhoneSpecs phoneSpecsControllerGetPhoneSpecs(@Param("id") Integer id);

  /**
   * 
   * Returns aggregated result with given aggregation info
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhoneSpecs/aggregations?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phoneSpecsControllerGetPhoneSpecsAggregatedValues(AggregationInfo body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns aggregated result with given aggregation info
     * Note, this is equivalent to the other <code>phoneSpecsControllerGetPhoneSpecsAggregatedValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerGetPhoneSpecsAggregatedValuesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneSpecs/aggregations?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phoneSpecsControllerGetPhoneSpecsAggregatedValues
    (AggregationInfo body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Partially updates the PhoneSpecs instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return PhoneSpecs
   */
  @RequestLine("PATCH /flanker_db/PhoneSpecs/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  PhoneSpecs phoneSpecsControllerPatchPhoneSpecs(PhoneSpecs body, @Param("id") Integer id);

  /**
   * 
   * Returns the list of PhoneSpecs instances matching the search criteria.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/PhoneSpecs/search?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phoneSpecsControllerSearchPhoneSpecsByQueryFilters(List<QueryFilter> body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the list of PhoneSpecs instances matching the search criteria.
     * Note, this is equivalent to the other <code>phoneSpecsControllerSearchPhoneSpecsByQueryFilters</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneSpecsControllerSearchPhoneSpecsByQueryFiltersQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/PhoneSpecs/search?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phoneSpecsControllerSearchPhoneSpecsByQueryFilters
    (List<QueryFilter> body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
