package com.myretail.test;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.MyRetailStartupApplication;
import com.myretail.config.MyRetailConfiguration;
import com.myretail.product.api.MyRetailProductOrchestrator;
import com.myretail.product.model.Price;
import com.myretail.product.model.Price.CurrencyCode;
import com.myretail.product.model.Product;
import com.myretail.product.model.ProductRepository;

//TODO add more test cases to get 100% test coverage
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK,
		  classes = MyRetailStartupApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
@EnableAutoConfiguration
public class MyRetailControllerTest {
		
		
		private static RedisTemplate<byte[],byte[]> template;
	
		@TestConfiguration 
		static class MyRetailTestContextConfiguration {
			  
	        @Bean
	        public JedisConnectionFactory jedisConnectionFactory() {
	            return new JedisConnectionFactory();
	        }
	        
	        @Bean
	    	@Autowired
	    	public RedisTemplate<byte[],byte[]> redisTemplate() {
	    	    template = new RedisTemplate<>();
	    	    template.setConnectionFactory(jedisConnectionFactory());
	    	    return template;
	    	}
	    	
	    	  
	    }
	
	 	@Autowired
	    private  JedisConnectionFactory jedisConnectionFactory;
	 
	    @MockBean
	    private ProductRepository productRepository;
	    
	    @MockBean
	    private MyRetailConfiguration config;
	    
	    @MockBean
	    private MyRetailProductOrchestrator productOrchestrator;
	    
	    @Autowired
	    private MockMvc mockMvc;
	    

	    ObjectMapper mapper = new ObjectMapper();
	    
	    @Before
	    public void mockProductName() {
	    	 Mockito.when(productOrchestrator.getProductName(13860428))
	          .thenReturn("test13860428");
	    }
	    
	    public Product createTestProduct(Integer id) {
	        Product product = new Product();
	        product.setId(id);
	        product.setName(String.format("test%s",id));
	        Price price = new Price();
	        price.setCurrencyCode(CurrencyCode.INR);
	        price.setValue(123.23);
	        product.setCurrentPrice(price);
	        Mockito.when(productRepository.findById(id))
	          .thenReturn(Optional.ofNullable(product));
	        return product;
	    }
	    
	    @Test
	    public void testGetProductById() throws Exception {
	    	Product product = createTestProduct(13860428);
	    	RequestBuilder builder = MockMvcRequestBuilders.get("/my-retail/products/13860428").accept(MediaType.APPLICATION_JSON);
	    	MvcResult mvcRes = mockMvc.perform(builder).andReturn();
	    	String expectedJson =  mapper.writeValueAsString(product);
	    	JSONAssert.assertEquals(expectedJson,mvcRes.getResponse().getContentAsString(),false);
	    }
	    
	  	
	    @Test
	    public void testPutPriceById() throws Exception {
	    	Product product = createTestProduct(13860428);
	    	String reqJson = mapper.writeValueAsString(product);
	    	RequestBuilder builder = MockMvcRequestBuilders.put("/my-retail/products/13860428/price").accept(MediaType.APPLICATION_JSON).content(reqJson).contentType(MediaType.APPLICATION_JSON);
	    	MvcResult mvcRes = mockMvc.perform(builder).andReturn();
	    	JSONAssert.assertEquals(reqJson,mvcRes.getResponse().getContentAsString(),false);
	    }
}
