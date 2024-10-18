package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.AggregationInfo;
import com.wavemaker.turbomobiles.FlankerAPI.model.DataExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.Downloadable;
import com.wavemaker.turbomobiles.FlankerAPI.model.OrderType;
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

public interface OrderTypeControllerService {

  /**
   * 
   * Returns the total count of OrderType instances matching the optional query (q) request param.
    * @param q conditions to filter the results (optional)
   * @return Long
   */
  @RequestLine("GET /flanker_db/OrderType/count?q={q}")
  @Headers({
    "Accept: */*",  })
  Long orderTypeControllerCountOrderTypes(@Param("q") String q);


    /**
     * 
     * Returns the total count of OrderType instances matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>orderTypeControllerCountOrderTypes</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerCountOrderTypesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   </ul>
     * @return Long
     */
    @RequestLine("GET /flanker_db/OrderType/count?q={q}")
    @Headers({
    "Accept: */*",    })
    Long orderTypeControllerCountOrderTypes
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Creates a new OrderType instance.
    * @param body  (required)
   * @return OrderType
   */
  @RequestLine("POST /flanker_db/OrderType")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  OrderType orderTypeControllerCreateOrderType(OrderType body);

  /**
   * 
   * Deletes the OrderType instance associated with the given id.
    * @param id  (required)
   * @return Boolean
   */
  @RequestLine("DELETE /flanker_db/OrderType/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Boolean orderTypeControllerDeleteOrderType(@Param("id") Integer id);

  /**
   * 
   * Updates the OrderType instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return OrderType
   */
  @RequestLine("PUT /flanker_db/OrderType/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  OrderType orderTypeControllerEditOrderType(OrderType body, @Param("id") Integer id);

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
  @RequestLine("GET /flanker_db/OrderType/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: application/octet-stream",  })
  Downloadable orderTypeControllerExportOrderTypes(@Param("exportType") String exportType, @Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file for the data matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>orderTypeControllerExportOrderTypes</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerExportOrderTypesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/OrderType/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: application/octet-stream",    })
    Downloadable orderTypeControllerExportOrderTypes
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
  @RequestLine("POST /flanker_db/OrderType/export?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  StringWrapper orderTypeControllerExportOrderTypesAndGetURL(DataExportOptions body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
     * Note, this is equivalent to the other <code>orderTypeControllerExportOrderTypesAndGetURL</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerExportOrderTypesAndGetURLQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/OrderType/export?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    StringWrapper orderTypeControllerExportOrderTypesAndGetURL
    (DataExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of OrderType instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/OrderType/filter?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Page orderTypeControllerFilterOrderTypes(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of OrderType instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
     * Note, this is equivalent to the other <code>orderTypeControllerFilterOrderTypes</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerFilterOrderTypesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/OrderType/filter?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    Page orderTypeControllerFilterOrderTypes
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Gets the orderses instance associated with the given id.
    * @param id  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/OrderType/{id}/orderses?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page orderTypeControllerFindAssociatedOrderses(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Gets the orderses instance associated with the given id.
     * Note, this is equivalent to the other <code>orderTypeControllerFindAssociatedOrderses</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerFindAssociatedOrdersesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param id  (required)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Page
     */
    @RequestLine("GET /flanker_db/OrderType/{id}/orderses?page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page orderTypeControllerFindAssociatedOrderses
    (@Param("id") Integer id, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of OrderType instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/OrderType?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page orderTypeControllerFindOrderTypes(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of OrderType instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
     * Note, this is equivalent to the other <code>orderTypeControllerFindOrderTypes</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerFindOrderTypesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/OrderType?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page orderTypeControllerFindOrderTypes
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the OrderType instance associated with the given id.
    * @param id  (required)
   * @return OrderType
   */
  @RequestLine("GET /flanker_db/OrderType/{id}")
  @Headers({
    "Accept: */*",  })
  OrderType orderTypeControllerGetOrderType(@Param("id") Integer id);

  /**
   * 
   * Returns aggregated result with given aggregation info
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/OrderType/aggregations?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page orderTypeControllerGetOrderTypeAggregatedValues(AggregationInfo body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns aggregated result with given aggregation info
     * Note, this is equivalent to the other <code>orderTypeControllerGetOrderTypeAggregatedValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerGetOrderTypeAggregatedValuesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/OrderType/aggregations?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page orderTypeControllerGetOrderTypeAggregatedValues
    (AggregationInfo body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Partially updates the OrderType instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return OrderType
   */
  @RequestLine("PATCH /flanker_db/OrderType/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  OrderType orderTypeControllerPatchOrderType(OrderType body, @Param("id") Integer id);

  /**
   * 
   * Returns the list of OrderType instances matching the search criteria.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/OrderType/search?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page orderTypeControllerSearchOrderTypesByQueryFilters(List<QueryFilter> body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the list of OrderType instances matching the search criteria.
     * Note, this is equivalent to the other <code>orderTypeControllerSearchOrderTypesByQueryFilters</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link OrderTypeControllerSearchOrderTypesByQueryFiltersQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/OrderType/search?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page orderTypeControllerSearchOrderTypesByQueryFilters
    (List<QueryFilter> body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
