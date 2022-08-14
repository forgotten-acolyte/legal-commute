package com.lawenforcement.legalcommute.outbound_ws.S3BucketFileHandler.service;

import com.lawenforcement.legalcommute.outbound_ws.S3BucketFileHandler.model.response.ProductImgUrlResponseModel;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

	ProductImgUrlResponseModel uploadFile(MultipartFile multipartFile);
}
