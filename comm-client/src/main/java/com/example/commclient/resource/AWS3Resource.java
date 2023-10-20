package com.example.commclient.resource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.example.commclient.camel.CamelEventNotifier;

@RestController
@RequestMapping("/aws3")
public class AWS3Resource {
	
	private static final Logger logger = LoggerFactory.getLogger(AWS3Resource.class);
	@Value("${aws.s3.bucketName:bucketName}")
	private String bucketName;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@PostMapping("/create")
	public boolean createFile() throws IOException {
		try {
			// convert multipart file  to a file
		       File file = new File("tmp/test.txt");
		       try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
		           fileOutputStream.write("HEllo".getBytes());
		       }

		       // generate file name
		       String fileName = "text.txt";

		       // upload file
		       PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file);
		       ObjectMetadata metadata = new ObjectMetadata();
		       metadata.setContentType("plain/"+ FilenameUtils.getExtension("txt"));
		       metadata.addUserMetadata("Title", "File Upload - " + fileName);
		       metadata.setContentLength(file.length());
		       request.setMetadata(metadata);
		       amazonS3.putObject(request);
		      
		    } catch (AmazonServiceException e) {
		    	e.printStackTrace();
		    }
		return true;
	}
}
