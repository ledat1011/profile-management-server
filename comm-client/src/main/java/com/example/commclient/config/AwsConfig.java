package com.example.commclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfig {

	@Value("${aws.s3.region:region}")
	private String region;
	
	@Autowired
	private AwsCredentialProviderImpl awsCredentialProviderImpl;
	
	@Value("${aws.s3.accesskey:accesskey}")
	private String accesskey;

	@Value("${aws.s3.secretkey:secretkey}")
	private String secretkey;

	@Value("${aws.s3.bucketName:bucketName}")
	private String bucketName;
	
  @Bean
  public AmazonS3 s3Client() {
	  
      return AmazonS3ClientBuilder.standard()
              .withRegion(Regions.AP_SOUTHEAST_1)
              .withCredentials(awsCredentialProviderImpl)
              .build();
  }

}
