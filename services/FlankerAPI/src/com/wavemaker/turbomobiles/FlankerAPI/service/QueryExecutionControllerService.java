package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.ExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.IntegerWrapper;
import com.wavemaker.turbomobiles.FlankerAPI.model.Page;
import com.wavemaker.turbomobiles.FlankerAPI.model.StringWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface QueryExecutionControllerService {

  /**
   * 
   * deleteFeaturesForPricePlan
    * @param pricePlanId  (required)
   * @return IntegerWrapper
   */
  @RequestLine("DELETE /flanker_db/queryExecutor/queries/deleteFeaturesForPricePlan?pricePlanId={pricePlanId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  IntegerWrapper queryExecutionControllerExecuteDeleteFeaturesForPricePlan(@Param("pricePlanId") Integer pricePlanId);


    /**
     * 
     * deleteFeaturesForPricePlan
     * Note, this is equivalent to the other <code>queryExecutionControllerExecuteDeleteFeaturesForPricePlan</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link QueryExecutionControllerExecuteDeleteFeaturesForPricePlanQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>pricePlanId -  (required)</li>
     *   </ul>
     * @return IntegerWrapper
     */
    @RequestLine("DELETE /flanker_db/queryExecutor/queries/deleteFeaturesForPricePlan?pricePlanId={pricePlanId}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    IntegerWrapper queryExecutionControllerExecuteDeleteFeaturesForPricePlan
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * getUserFromEmail
    * @param email  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/queryExecutor/queries/getUserFromEmail?email={email}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page queryExecutionControllerExecuteGetUserFromEmail(@Param("email") String email, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * getUserFromEmail
     * Note, this is equivalent to the other <code>queryExecutionControllerExecuteGetUserFromEmail</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link QueryExecutionControllerExecuteGetUserFromEmailQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>email -  (required)</li>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return Page
     */
    @RequestLine("GET /flanker_db/queryExecutor/queries/getUserFromEmail?email={email}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page queryExecutionControllerExecuteGetUserFromEmail
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns downloadable file url for query getUserFromEmail
    * @param body  (required)
    * @param email  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return StringWrapper
   */
  @RequestLine("POST /flanker_db/queryExecutor/queries/getUserFromEmail/export?email={email}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  StringWrapper queryExecutionControllerExportGetUserFromEmail(ExportOptions body, @Param("email") String email, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file url for query getUserFromEmail
     * Note, this is equivalent to the other <code>queryExecutionControllerExportGetUserFromEmail</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link QueryExecutionControllerExportGetUserFromEmailQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param body  (required)
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>email -  (required)</li>
     *   <li>page -  (optional, default to 0)</li>
     *   <li>size -  (optional, default to 20)</li>
     *   <li>sort -  (optional)</li>
     *   </ul>
     * @return StringWrapper
     */
    @RequestLine("POST /flanker_db/queryExecutor/queries/getUserFromEmail/export?email={email}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    StringWrapper queryExecutionControllerExportGetUserFromEmail
    (ExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
