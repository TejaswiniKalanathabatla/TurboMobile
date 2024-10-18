package com.wavemaker.turbomobiles.GetThemeDetail.service;


import com.wavemaker.turbomobiles.GetThemeDetail.model.*;
import com.wavemaker.turbomobiles.GetThemeDetail.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface RestServiceVirtualControllerService {

  /**
   * 
   * 
    * @param size size (optional)
   * @return RootResponse
   */
  @RequestLine("GET /themeconfig/Themedetail?size={size}")
  @Headers({
    "Accept: application/json",  })
  RootResponse restServiceVirtualControllerInvoke(@Param("size") String size);


    /**
     * 
     * 
     * Note, this is equivalent to the other <code>restServiceVirtualControllerInvoke</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link RestServiceVirtualControllerInvokeQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>size - size (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /themeconfig/Themedetail?size={size}")
    @Headers({
    "Accept: application/json",    })
    RootResponse restServiceVirtualControllerInvoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
