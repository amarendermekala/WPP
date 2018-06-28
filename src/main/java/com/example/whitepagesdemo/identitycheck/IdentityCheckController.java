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

    @ApiOperation(value = "Identity Check Details based on applicant details")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Object getLocation(@RequestBody() List<ApiRequest> apiRequests) throws IOException {
        if(!IdentityCheckUtils.validateAPIRequest(apiRequests)) {
            return "Api Request is not valid";
        }
        return identityCheckService.performIdCheck(apiRequests);
    }

    @ApiOperation(value = "Identity Check Details when applicant details are submitted in batch in csv format")
    @RequestMapping(value = "/csv", method = RequestMethod.POST, produces = "application/json")
    public Object getLocation(@RequestBody() String csvContent) throws IOException {
        List<ApiRequest> apiRequests = IdentityCheckUtils.convertCsvToApiRequest(csvContent);
        return identityCheckService.performIdCheck(apiRequests);
    }
}
