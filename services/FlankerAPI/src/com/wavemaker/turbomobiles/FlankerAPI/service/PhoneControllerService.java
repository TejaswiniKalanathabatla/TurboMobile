package com.wavemaker.turbomobiles.FlankerAPI.service;


import com.wavemaker.turbomobiles.FlankerAPI.model.*;
import com.wavemaker.turbomobiles.FlankerAPI.model.AggregationInfo;
import com.wavemaker.turbomobiles.FlankerAPI.model.DataExportOptions;
import com.wavemaker.turbomobiles.FlankerAPI.model.Downloadable;
import com.wavemaker.turbomobiles.FlankerAPI.model.Page;
import com.wavemaker.turbomobiles.FlankerAPI.model.Phone;
import com.wavemaker.turbomobiles.FlankerAPI.model.QueryFilter;
import com.wavemaker.turbomobiles.FlankerAPI.model.StringWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface PhoneControllerService {

  /**
   * 
   * Returns the total count of Phone instances matching the optional query (q) request param.
    * @param q conditions to filter the results (optional)
   * @return Long
   */
  @RequestLine("GET /flanker_db/Phone/count?q={q}")
  @Headers({
    "Accept: */*",  })
  Long phoneControllerCountPhones(@Param("q") String q);


    /**
     * 
     * Returns the total count of Phone instances matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phoneControllerCountPhones</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerCountPhonesQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>q - conditions to filter the results (optional)</li>
     *   </ul>
     * @return Long
     */
    @RequestLine("GET /flanker_db/Phone/count?q={q}")
    @Headers({
    "Accept: */*",    })
    Long phoneControllerCountPhones
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Creates a new Phone instance.
    * @param body  (required)
   * @return Phone
   */
  @RequestLine("POST /flanker_db/Phone")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Phone phoneControllerCreatePhone(Phone body);

  /**
   * 
   * Deletes the Phone instance associated with the given id.
    * @param id  (required)
   * @return Boolean
   */
  @RequestLine("DELETE /flanker_db/Phone/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Boolean phoneControllerDeletePhone(@Param("id") Integer id);

  /**
   * 
   * Updates the Phone instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return Phone
   */
  @RequestLine("PUT /flanker_db/Phone/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Phone phoneControllerEditPhone(Phone body, @Param("id") Integer id);

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
  @RequestLine("GET /flanker_db/Phone/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: application/octet-stream",  })
  Downloadable phoneControllerExportPhones(@Param("exportType") String exportType, @Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns downloadable file for the data matching the optional query (q) request param.
     * Note, this is equivalent to the other <code>phoneControllerExportPhones</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerExportPhonesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone/export/{exportType}?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: application/octet-stream",    })
    Downloadable phoneControllerExportPhones
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
  @RequestLine("POST /flanker_db/Phone/export?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  StringWrapper phoneControllerExportPhonesAndGetURL(DataExportOptions body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.
     * Note, this is equivalent to the other <code>phoneControllerExportPhonesAndGetURL</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerExportPhonesAndGetURLQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/Phone/export?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    StringWrapper phoneControllerExportPhonesAndGetURL
    (DataExportOptions body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of Phone instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/Phone/filter?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",  })
  Page phoneControllerFilterPhones(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of Phone instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.
     * Note, this is equivalent to the other <code>phoneControllerFilterPhones</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFilterPhonesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/Phone/filter?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: application/json",
    "Accept: */*",    })
    Page phoneControllerFilterPhones
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Gets the phoneColorses instance associated with the given id.
    * @param id  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/Phone/{id}/phoneColorses?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneControllerFindAssociatedPhoneColorses(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Gets the phoneColorses instance associated with the given id.
     * Note, this is equivalent to the other <code>phoneControllerFindAssociatedPhoneColorses</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFindAssociatedPhoneColorsesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone/{id}/phoneColorses?page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneControllerFindAssociatedPhoneColorses
    (@Param("id") Integer id, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Gets the phoneFeatureses instance associated with the given id.
    * @param id  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/Phone/{id}/phoneFeatureses?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneControllerFindAssociatedPhoneFeatureses(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Gets the phoneFeatureses instance associated with the given id.
     * Note, this is equivalent to the other <code>phoneControllerFindAssociatedPhoneFeatureses</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFindAssociatedPhoneFeaturesesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone/{id}/phoneFeatureses?page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneControllerFindAssociatedPhoneFeatureses
    (@Param("id") Integer id, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Gets the phoneSpecses instance associated with the given id.
    * @param id  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/Phone/{id}/phoneSpecses?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneControllerFindAssociatedPhoneSpecses(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Gets the phoneSpecses instance associated with the given id.
     * Note, this is equivalent to the other <code>phoneControllerFindAssociatedPhoneSpecses</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFindAssociatedPhoneSpecsesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone/{id}/phoneSpecses?page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneControllerFindAssociatedPhoneSpecses
    (@Param("id") Integer id, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Gets the phoneStorageSizeses instance associated with the given id.
    * @param id  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/Phone/{id}/phoneStorageSizeses?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneControllerFindAssociatedPhoneStorageSizeses(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Gets the phoneStorageSizeses instance associated with the given id.
     * Note, this is equivalent to the other <code>phoneControllerFindAssociatedPhoneStorageSizeses</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFindAssociatedPhoneStorageSizesesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone/{id}/phoneStorageSizeses?page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneControllerFindAssociatedPhoneStorageSizeses
    (@Param("id") Integer id, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Gets the phoneVariants instance associated with the given id.
    * @param id  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/Phone/{id}/phoneVariants?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneControllerFindAssociatedPhoneVariants(@Param("id") Integer id, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Gets the phoneVariants instance associated with the given id.
     * Note, this is equivalent to the other <code>phoneControllerFindAssociatedPhoneVariants</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFindAssociatedPhoneVariantsQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone/{id}/phoneVariants?page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneControllerFindAssociatedPhoneVariants
    (@Param("id") Integer id, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the paginated list of Phone instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
    * @param q conditions to filter the results (optional)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("GET /flanker_db/Phone?q={q}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",  })
  Page phoneControllerFindPhones(@Param("q") String q, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the paginated list of Phone instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination &amp; Sorting parameters such as page&amp; size, sort can be sent as request parameters. The sort value should be a comma separated list of field names &amp; optional sort order to sort the data on. eg: field1 asc, field2 desc etc 
     * Note, this is equivalent to the other <code>phoneControllerFindPhones</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerFindPhonesQueryParams} class that allows for
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
    @RequestLine("GET /flanker_db/Phone?q={q}&page={page}&size={size}&sort={sort}")
    @Headers({
    "Accept: */*",    })
    Page phoneControllerFindPhones
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Returns the Phone instance associated with the given id.
    * @param id  (required)
   * @return Phone
   */
  @RequestLine("GET /flanker_db/Phone/{id}")
  @Headers({
    "Accept: */*",  })
  Phone phoneControllerGetPhone(@Param("id") Integer id);

  /**
   * 
   * Returns aggregated result with given aggregation info
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/Phone/aggregations?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phoneControllerGetPhoneAggregatedValues(AggregationInfo body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns aggregated result with given aggregation info
     * Note, this is equivalent to the other <code>phoneControllerGetPhoneAggregatedValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerGetPhoneAggregatedValuesQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/Phone/aggregations?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phoneControllerGetPhoneAggregatedValues
    (AggregationInfo body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

  /**
   * 
   * Partially updates the Phone instance associated with the given id.
    * @param body  (required)
    * @param id  (required)
   * @return Phone
   */
  @RequestLine("PATCH /flanker_db/Phone/{id}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Phone phoneControllerPatchPhone(Phone body, @Param("id") Integer id);

  /**
   * 
   * Returns the list of Phone instances matching the search criteria.
    * @param body  (required)
    * @param page  (optional, default to 0)
    * @param size  (optional, default to 20)
    * @param sort  (optional)
   * @return Page
   */
  @RequestLine("POST /flanker_db/Phone/search?page={page}&size={size}&sort={sort}")
  @Headers({
    "Content-Type: */*",
    "Accept: */*",  })
  Page phoneControllerSearchPhonesByQueryFilters(List<QueryFilter> body, @Param("page") Integer page, @Param("size") Integer size, @Param("sort") String sort);


    /**
     * 
     * Returns the list of Phone instances matching the search criteria.
     * Note, this is equivalent to the other <code>phoneControllerSearchPhonesByQueryFilters</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link PhoneControllerSearchPhonesByQueryFiltersQueryParams} class that allows for
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
    @RequestLine("POST /flanker_db/Phone/search?page={page}&size={size}&sort={sort}")
    @Headers({
    "Content-Type: */*",
    "Accept: */*",    })
    Page phoneControllerSearchPhonesByQueryFilters
    (List<QueryFilter> body, @QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
