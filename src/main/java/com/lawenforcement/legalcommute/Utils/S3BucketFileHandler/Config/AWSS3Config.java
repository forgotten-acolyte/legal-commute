//package com.lawenforcement.legalcommute.Utils.S3BucketFileHandler.Config;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AWSS3Config {
//
//	@Value("${aws.access_key_id}")
//	private String accessKeyId;
//	@Value("${aws.secret_access_key}")
//	private String secretAccessKey;
//	@Value("${aws.s3.region}")
//	private String region;
//
//	@Bean
//	public AmazonS3 getAmazonS3Cient() {
//		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
//		// Get AmazonS3 client and return the s3Client object.
//		return AmazonS3ClientBuilder
//				.standard()
//				.withRegion(Regions.fromName(region))
//				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
//				.build();
//	}
//}
