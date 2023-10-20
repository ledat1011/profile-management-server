package com.example.commclient.route;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.CamelSpringTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

import com.example.commclient.proccessor.TransformProcessorCustom;

@CamelSpringBootTest
@SpringBootTest(
    properties = { "camel.springboot.name=customName" },
    webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
public class ApacheCamelRouteTest  {
    
    @Autowired
    private ProducerTemplate producerTemplate;

    
    @Mock
    TransformProcessorCustom custom; 
    //Spring context fixtures
//    @Configuration
//    static class TestConfig {
//
//        @Bean
//        RoutesBuilder route() {
//            return new ApacheCamelRoute();
//        }
//    }
    @Test
    public void testXmlContentType() throws Exception {
        Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/xml");
		String response = (String) producerTemplate.requestBodyAndHeaders("direct:startGetAllByApache", null, headers);
		verify(custom,times(1)).process(any());
		assertEquals("TESTNE", response);
    }

}
