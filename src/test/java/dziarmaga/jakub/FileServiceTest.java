package dziarmaga.jakub;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dziarmaga.jakub.sustar.model.Request;
import dziarmaga.jakub.sustar.model.Response;
import dziarmaga.jakub.sustar.service.FileService;
import dziarmaga.jakub.sustar.service.FileServiceImpl;

public class FileServiceTest {

	@Mock
	private FileWriter mockFileWriter;	
	@Mock
	private Request mockRequest;	
	@Mock
	private Response mockResponse;
	@InjectMocks
	private FileService fileService = new FileServiceImpl();
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveRequest() throws IOException{
		fileService.saveRequest(mockRequest);

        verify(mockFileWriter, times(1)).write(anyString());
        verify(mockFileWriter, times(1)).flush();
        verifyNoMoreInteractions(mockFileWriter);			
	}
	
	@Test
	public void saveResponse() throws IOException{
		fileService.saveResponse(mockResponse);

        verify(mockFileWriter, times(1)).write(anyString());
        verify(mockFileWriter, times(1)).flush();
        verifyNoMoreInteractions(mockFileWriter);			
	}
}
