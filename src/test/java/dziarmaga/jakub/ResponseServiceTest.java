package dziarmaga.jakub;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import dziarmaga.jakub.sustar.model.Response;
import dziarmaga.jakub.sustar.model.User;
import dziarmaga.jakub.sustar.service.FileService;
import dziarmaga.jakub.sustar.service.ResponseService;
import dziarmaga.jakub.sustar.service.ResponseServiceImpl;

public class ResponseServiceTest {

	@Mock
	private RestTemplate mockTemplate;
	@Mock
	private FileService mockFileService;
	@Mock
	private Response mockResponse;
	@InjectMocks
	private ResponseService responseService = new ResponseServiceImpl();
	
	private RestTemplate template;
	
	private User user;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		user = new User();
		template = new RestTemplate();
	}
	
	@Test
	public void createUrl(){
		user.setLogin("testLogin");
		user.setToken("setToken");
		responseService.createUrl(user);
		
		Field field = ReflectionUtils.findField(ResponseServiceImpl.class, "url");
        ReflectionUtils.makeAccessible(field);
		String url = (String) ReflectionUtils.getField(field, responseService);

		assertTrue(url.equals("http://arcology.prime.future-processing.com/describe?login=testLogin&token=setToken"));
	}
	
	@Test
	public void getResponse(){
		when(mockTemplate.getForObject(anyString(), eq(Response.class))).thenReturn(mockResponse);
		
		responseService.getResponse();
		
        verify(mockFileService, times(1)).saveResponse(mockResponse);
        verifyNoMoreInteractions(mockFileService);	
        }
	
	@Test
	public void getPongMessage(){
		String actualString;
		String pongUrl = "http://arcology.prime.future-processing.com/";
		String expectedString = "Pong";
		
		actualString = template.getForObject(pongUrl,String.class);
		
		assertTrue(actualString.equals(expectedString));
		
	}
	
}
