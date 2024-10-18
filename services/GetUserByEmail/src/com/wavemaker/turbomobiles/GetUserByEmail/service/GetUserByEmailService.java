package com.wavemaker.turbomobiles.GetUserByEmail.service;


import com.wavemaker.turbomobiles.GetUserByEmail.model.*;
import com.wavemaker.turbomobiles.GetUserByEmail.model.RootResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;
import org.springframework.util.MultiValueMap;
import feign.*;

public interface GetUserByEmailService {

  /**
   * 
   * 
    * @param email email (optional)
   * @return RootResponse
   */
  @RequestLine("GET /flanker_db/queryExecutor/queries/getUserFromEmail?email={email}")
  @Headers({
    "Accept: application/json",  })
  RootResponse invoke(@Param("email") String email);


    /**
     * 
     * 
     * Note, this is equivalent to the other <code>invoke</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link InvokeQueryParams} class that allows for
     * building up this map in a fluent style.
     * @param queryParams Map of query parameters as name-value pairs
     *   <p>The following elements may be specified in the query map:</p>
     *   <ul>
     *   <li>email - email (optional)</li>
     *   </ul>
     * @return RootResponse
     */
    @RequestLine("GET /flanker_db/queryExecutor/queries/getUserFromEmail?email={email}")
    @Headers({
    "Accept: application/json",    })
    RootResponse invoke
    (@QueryMap(encoded=true)
    MultiValueMap<String, String> queryParams);

}
