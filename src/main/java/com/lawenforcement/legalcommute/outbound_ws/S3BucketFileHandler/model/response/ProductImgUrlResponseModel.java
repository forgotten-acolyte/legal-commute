package com.lawenforcement.legalcommute.outbound_ws.S3BucketFileHandler.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductImgUrlResponseModel {
    private String fileName;
    private String imgUrl;
}
