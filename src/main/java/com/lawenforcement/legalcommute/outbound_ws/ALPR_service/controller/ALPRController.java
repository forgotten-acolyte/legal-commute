package com.lawenforcement.legalcommute.outbound_ws.ALPR_service.controller;

import com.lawenforcement.legalcommute.outbound_ws.ALPR_service.AlPRProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ALPRController {

    @Autowired
    AlPRProxy alPRProxy;


}
