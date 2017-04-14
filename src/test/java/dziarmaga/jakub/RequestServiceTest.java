package dziarmaga.jakub;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import dziarmaga.jakub.sustar.model.Request;
import dziarmaga.jakub.sustar.model.User;
import dziarmaga.jakub.sustar.service.FileService;
import dziarmaga.jakub.sustar.service.RequestService;
import dziarmaga.jakub.sustar.service.RequestServiceImpl;

public class RequestServiceTest {
	

	@Mock
	private RestTemplate mockTemplate;
	@Mock
	private FileService mockFileService;
	@InjectMocks
	private RequestService requestService = new RequestServiceImpl();
	
	private User user;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setLogin("testLogin");
		user.setToken("testToken");
	}
	
	@Test
	public void setLoginAndToken(){
		requestService.setLoginAndToken(user);
		
		Field field = ReflectionUtils.findField(RequestServiceImpl.class, "request");
        ReflectionUtils.makeAccessible(field);
        Request request = (Request) ReflectionUtils.getField(field, requestService);
        
        String expectedLogin = user.getLogin();
        String expectedToken = user.getToken();
        assertTrue(request.getLogin().equals(expectedLogin));
        assertTrue(request.getToken().equals(expectedToken));
	}

	
	@Test
	public void sendRequest(){
		requestService.sendRequest();
		        
        verify(mockTemplate, times(1)).postForObject(anyString(),any(Request.class),eq(Request.class));
        verifyNoMoreInteractions(mockTemplate);	
	}
}