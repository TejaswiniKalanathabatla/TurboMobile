package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.AggregationInfo;
import com.wavemaker.turbomobiles.FlankerAPI.model.BroadbandPlanFeatures;
import com.wavemaker.turbomobiles.FlankerAPI.model.DataExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.Downloadable;
import com.wavemaker.turbomobiles.FlankerAPI.model.Page;
import com.wavemaker.turbomobiles.FlankerAPI.model.QueryFilter;
import com.wavemaker.turbomobiles.FlankerAPI.model.StringWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface BroadbandPlanFeaturesControllerService {

  /**
   * 
   * Returns the total count of BroadbandPlanFeatures instances matching the optional query (q) request param.
    * @param q conditions to filter the results (optional)
   * @return Long
   */
  @RequestLine("GET /flanker_db/BroadbandPlanFeatures/count?q={q}")
  @Headers({
    "Accept: */*",  })
  Long broadbandPlanFeaturesControllerCountBroadbandPlanFeatures(@Param("q") String q);


    /**
     * 
     * Returns the total count of BroadbandPlanFeatures instances matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerCountBroadbandPlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerCountBroadbandPlanFeaturesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   </ul>
     * @return Long
     */
    @RequestLine("GET /flanker_db/BroadbandPlanFeatures/count?q={q}")
    @Headers({
    "Accept: */*",    })
    Long broadbandPlanFeaturesControllerCountBroadbandPlanFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Creates a new BroadbandPlanFeatures instance.
    * @param body  (required)
   * @return BroadbandPlanFeatures
   */
  @RequestLine("POST /flanker_db/BroadbandPlanFeatures")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  BroadbandPlanFeatures broadbandPlanFeaturesControllerCreateBroadbandPlanFeatures(BroadbandPlanFeatures body);

  /**
   * 
   * Deletes the BroadbandPlanFeatures instance associated with the given id.
    * @param id  (required)
   * @return Boolean
   */
  @RequestLine("DELETE /flanker_db/BroadbandPlanFeatures/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Boolean broadbandPlanFeaturesControllerDeleteBroadbandPlanFeatures(@Param("id") Integer id);

  /**
   * 
   * Updates the BroadbandPlanFeatures instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return BroadbandPlanFeatures
   */
  @RequestLine("PUT /flanker_db/BroadbandPlanFeatures/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  BroadbandPlanFeatures broadbandPlanFeaturesControllerEditBroadbandPlanFeatures(BroadbandPlanFeatures body, @Param("id") Integer id);

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
  @RequestLine("GET /flanker_db/BroadbandPlanFeatures/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: application/octet-stream",  })
  Downloadable broadbandPlanFeaturesControllerExportBroadbandPlanFeatures(@Param("exportType") String exportType, @Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file for the data matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerExportBroadbandPlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerExportBroadbandPlanFeaturesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/BroadbandPlanFeatures/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: application/octet-stream",    })
    Downloadable broadbandPlanFeaturesControllerExportBroadbandPlanFeatures
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
  @RequestLine("POST /flanker_db/BroadbandPlanFeatures/export?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  StringWrapper broadbandPlanFeaturesControllerExportBroadbandPlanFeaturesAndGetURL(DataExportOptions body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerExportBroadbandPlanFeaturesAndGetURL</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerExportBroadbandPlanFeaturesAndGetURLQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/BroadbandPlanFeatures/export?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    StringWrapper broadbandPlanFeaturesControllerExportBroadbandPlanFeaturesAndGetURL
    (DataExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of BroadbandPlanFeatures instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/BroadbandPlanFeatures/filter?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Page broadbandPlanFeaturesControllerFilterBroadbandPlanFeatures(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of BroadbandPlanFeatures instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerFilterBroadbandPlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerFilterBroadbandPlanFeaturesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/BroadbandPlanFeatures/filter?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    Page broadbandPlanFeaturesControllerFilterBroadbandPlanFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of BroadbandPlanFeatures instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/BroadbandPlanFeatures?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page broadbandPlanFeaturesControllerFindBroadbandPlanFeatures(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of BroadbandPlanFeatures instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerFindBroadbandPlanFeatures</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerFindBroadbandPlanFeaturesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/BroadbandPlanFeatures?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page broadbandPlanFeaturesControllerFindBroadbandPlanFeatures
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the BroadbandPlanFeatures instance associated with the given id.
    * @param id  (required)
   * @return BroadbandPlanFeatures
   */
  @RequestLine("GET /flanker_db/BroadbandPlanFeatures/{id}")
  @Headers({
    "Accept: */*",  })
  BroadbandPlanFeatures broadbandPlanFeaturesControllerGetBroadbandPlanFeatures(@Param("id") Integer id);

  /**
   * 
   * Returns aggregated result with given aggregation info
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/BroadbandPlanFeatures/aggregations?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page broadbandPlanFeaturesControllerGetBroadbandPlanFeaturesAggregatedValues(AggregationInfo body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns aggregated result with given aggregation info
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerGetBroadbandPlanFeaturesAggregatedValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerGetBroadbandPlanFeaturesAggregatedValuesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/BroadbandPlanFeatures/aggregations?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page broadbandPlanFeaturesControllerGetBroadbandPlanFeaturesAggregatedValues
    (AggregationInfo body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Partially updates the BroadbandPlanFeatures instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return BroadbandPlanFeatures
   */
  @RequestLine("PATCH /flanker_db/BroadbandPlanFeatures/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  BroadbandPlanFeatures broadbandPlanFeaturesControllerPatchBroadbandPlanFeatures(BroadbandPlanFeatures body, @Param("id") Integer id);

  /**
   * 
   * Returns the list of BroadbandPlanFeatures instances matching the search criteria.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/BroadbandPlanFeatures/search?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page broadbandPlanFeaturesControllerSearchBroadbandPlanFeaturesByQueryFilters(List<QueryFilter> body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the list of BroadbandPlanFeatures instances matching the search criteria.
     * Note, this is equivalent to the other <code>broadbandPlanFeaturesControllerSearchBroadbandPlanFeaturesByQueryFilters</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link BroadbandPlanFeaturesControllerSearchBroadbandPlanFeaturesByQueryFiltersQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/BroadbandPlanFeatures/search?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page broadbandPlanFeaturesControllerSearchBroadbandPlanFeaturesByQueryFilters
    (List<QueryFilter> body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
