package com.example.whitepagesdemo.identitycheck;


import com.example.whitepagesdemo.entities.request.ApiRequest;
import com.example.whitepagesdemo.entities.response.ApiResponse;
import com.example.whitepagesdemo.identitycheck.utils.IdentityCheckUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/idcheck")
public class IdentityCheckController {

    @Autowired
    IdentityCheckService identityCheckService;

    @ApiOperation(value = "Identity Check Details based on primary details")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Object getLocation(@RequestBody() List<ApiRequest> apiRequests) throws IOException {
        if(!IdentityCheckUtils.validateAPIRequest(apiRequests)) {
            return "Api Request is not valid";
        }
        List<ApiResponse> o = identityCheckService.performIdCheck(apiRequests);
        System.out.println(o);
        return o;
    }

    @ApiOperation(value = "Identity Check Details when a csv file is given")
    @RequestMapping(value = "/csv", method = RequestMethod.POST, produces = "application/json")
    public Object getLocation(@RequestBody() String csvContent) throws IOException {
        List<ApiRequest> apiRequests = IdentityCheckUtils.convertCsvToApiRequest(csvContent);
        List<ApiResponse> o = identityCheckService.performIdCheck(apiRequests);
        System.out.println(o);
        return o;
    }
}
