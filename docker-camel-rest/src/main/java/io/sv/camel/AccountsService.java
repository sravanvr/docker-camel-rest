package io.sv.camel;

import org.apache.camel.*;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Account Service
 */
public class AccountsService {

		 
	public String getAccountsResposneFromAccountsMicroService(){
		CamelContext context = new DefaultCamelContext();
		String ret = null;

	    try {
	        ProducerTemplate template = context.createProducerTemplate();
	        context.start();

	        Exchange exchange = template
	                .request(
	                		"http://153.83.18.98:1234/AccountInquiry/getAccounts",
	                        //"http://153.83.18.98:1234/AccountInquiry/getAccounts",
	                        new Processor() {
	                            public void process(Exchange exchange)
	                                    throws Exception {
	                            }
	                        });

	        if (null != exchange) {
	            Message out = exchange.getOut();
	            ret = out.getBody(String.class);
	            
//	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	            String json = gson.toJson(ret);
//	            System.out.println(json);
//	            ret = json;
	            System.out.println("Body: " + ret);	//.toString());
	           
	        }

	        //Thread.sleep(1000 * 3);
	        context.stop();
	        return (ret);
	        
	    } catch (Exception ex) {
	        System.out.println("Here is Exception: " + ex);
	        return ret;
	    }
	}
	

	public void getResposneFromAccountsMicroService(){
		CamelContext context = new DefaultCamelContext();

	    try {
	        ProducerTemplate template = context.createProducerTemplate();
	        context.start();

	        Exchange exchange = template
	                .request(
	                		"https://jsonplaceholder.typicode.com/posts/1",
	                        //"http://153.83.18.98:1234/AccountInquiry/getAccounts",
	                        new Processor() {
	                            public void process(Exchange exchange)
	                                    throws Exception {
	                            }
	                        });

	        if (null != exchange) {
	            Message out = exchange.getOut();
	            System.out.println("Body: " + out.getBody(String.class));	//.toString());
	            int responseCode = out.getHeader(Exchange.HTTP_RESPONSE_CODE,
	                    Integer.class);
	            System.out.println("Response: " + String.valueOf(responseCode));
	        }

	        Thread.sleep(1000 * 3);
	        context.stop();
	    } catch (Exception ex) {
	        System.out.println("Here is Exception: " + ex);
	    }
	}
//	public static void main(String[] args) {
//		
//		new AccountsService().getAccountsResposneFromAccountsMicroService();
//	}

}
