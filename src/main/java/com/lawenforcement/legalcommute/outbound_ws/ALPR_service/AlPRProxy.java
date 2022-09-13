package com.lawenforcement.legalcommute.outbound_ws.ALPR_service;

import com.lawenforcement.legalcommute.outbound_ws.ALPR_service.model.response.ALPRResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name ="what", url = "https://api.platerecognizer.com")
public interface AlPRProxy {

    @GetMapping("/v1/plate-reader/")
    public ALPRResponseModel retrieveRecognizedLicensePlateNumber(
            @RequestParam("file") List<MultipartFile> submissions);

}
