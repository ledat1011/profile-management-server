package com.example.commclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;

@Component
public class AwsCredentialProviderImpl implements AWSCredentialsProvider{

	private AWSCredentials credentials;
	
	@Value("${aws.s3.region:region}")
	private String region;

	@Value("${aws.s3.accesskey:accesskey}")
	private String accesskey;

	@Value("${aws.s3.secretkey:secretkey}")
	private String secretkey;

	@Value("${aws.s3.bucketName:bucketName}")
	private String bucketName;
	
	@Value("${aws.s3.roleARN:roleARN}")
	private String roleARN;
	
	@Value("${aws.s3.roleSessionName:roleSessionName}")
	private String roleSessionName;
	
	@Override
	public AWSCredentials getCredentials() {
		this.refresh();
		return credentials;
	}

	@Override
	public void refresh() {
        AWSCredentials basicCredentials = new BasicAWSCredentials(accesskey, secretkey);

        AssumeRoleRequest roleRequest = new AssumeRoleRequest()
            .withRoleArn(roleARN)
            .withRoleSessionName(roleSessionName);

        AssumeRoleResult roleResponse = AWSSecurityTokenServiceClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(basicCredentials))
            .withRegion(region)
            .build()
            .assumeRole(roleRequest);

        Credentials sessionCredentials = roleResponse.getCredentials();

        this.credentials = new BasicSessionCredentials(
            sessionCredentials.getAccessKeyId(),
            sessionCredentials.getSecretAccessKey(),
            sessionCredentials.getSessionToken());
		
	}

}
