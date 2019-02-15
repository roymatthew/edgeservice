/**
 * 
 */
package com.demo.microservice.edge.rest;

import com.demo.microservice.edge.clients.DataElementClient;
import com.demo.microservice.edge.vo.DataElementVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rmathew
 *
 */
@Controller
@RequestMapping(value = "/edge/dataelements")
public class DataElementsRestController {
    
    @Autowired
    private DataElementClient dataElementClient;
    
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping(value="/elementtype/{elementType}")
    @ResponseBody
    public List<DataElementVO> listDataElementsByElementType(@PathVariable final String elementType)
    {
        return dataElementClient.getDataElements(elementType);
    }
    
    public List<DataElementVO> fallback(final String elementType) {
        return new ArrayList<>();
    }


}
