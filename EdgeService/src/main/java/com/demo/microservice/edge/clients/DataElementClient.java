/**
 * 
 */
package com.demo.microservice.edge.clients;

import com.demo.microservice.edge.vo.DataElementVO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author rmathew
 *
 */
@FeignClient("DataElementsService")
public interface DataElementClient {
    
    @GetMapping("/dataelements/elementtype/{elementType}")
    List<DataElementVO> getDataElements(@PathVariable final String elementType);

}
