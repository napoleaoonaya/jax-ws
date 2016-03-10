package webservices;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Consumer {

	public static void main(String[] args) {

		//service
		RandomService randomService = new RandomService();
		
		//proxy
		Random proxy = randomService.getRandomPort();
		
		//username and password
		BindingProvider bp = (BindingProvider) proxy ;
		Map<String , List<String >> headers = new HashMap<String , List <String>>();
		headers.put("Username", Collections.singletonList("napoleao"));
		headers.put("Password", Collections.singletonList("123456"));
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		//operation
		double next = proxy.next(50);
		System.out.println(next);
	}

}
