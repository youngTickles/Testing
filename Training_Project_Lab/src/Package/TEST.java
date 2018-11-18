package Package;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.*;
import java.io.*;
public class TEST {
	 private static String url = "https://lobbyservice-dot-training-project-lab.appspot.com/NewGameLobby";
  
	public static boolean POST(String route, NameValuePair[] data,int expectedStatusCode)
	{	boolean result = false ;
		// Create an instance of HttpClient.
	    HttpClient client = new HttpClient();
	    // Create a method instance.
	    PostMethod post = new PostMethod(url+route);
	    // Provide custom retry handler is necessary
	    client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		  new DefaultHttpMethodRetryHandler());
	    post.setQueryString(data);
	   // post.addParameters(data);
        // Execute the method.
        try {
			int statusCode = client.executeMethod(post);
			if (statusCode==expectedStatusCode)
				result = true; 
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return result;
		}
        finally {
	       post.releaseConnection();
        }
		return result;
	}
	@SuppressWarnings("deprecation")
	public static boolean PUT(String route, NameValuePair[]  data,int expectedStatusCode)
	{	boolean result = false ;
		// Create an instance of HttpClient.
	    HttpClient client = new HttpClient();
	    // Provide custom retry handler is necessary
	    client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		  new DefaultHttpMethodRetryHandler());
	    // Create a method instance.
	    PutMethod put = new PutMethod(url+route);
	    put.setQueryString(data);
	
	    try {
	        // Execute the method.
	        int statusCode = client.executeMethod(put);
	        if (statusCode==expectedStatusCode)
				result = true; 

	      } catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally {
		       put.releaseConnection();
	        }
	    return result;
	}
	public static boolean Get(String route,int expectedStatusCode)
	
	{	boolean result = false ;
	 
		// Create an instance of HttpClient.
	    HttpClient client = new HttpClient();
	    // Create a method instance.
	    GetMethod method = new GetMethod(url+route);
	    // Provide custom retry handler is necessary
	    client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    		  new DefaultHttpMethodRetryHandler());
	    try {
	        // Execute the method.
	        int statusCode = client.executeMethod(method);
	        if (statusCode==expectedStatusCode)
				result = true; 

	      } catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally {
		       method.releaseConnection();
	        }
	    return result;
	}
	public static boolean DELETE(String route,int expectedStatusCode) throws Exception {
			boolean result = false ;
		  HttpClient client=new HttpClient();
		  DeleteMethod method=new DeleteMethod(url+route);
		  //client.executeMethod(method);
		 ///int status=method.getStatusCode();
		  try {
		        // Execute the method.
		        int statusCode = client.executeMethod(method);
		        if (statusCode==expectedStatusCode)
					result = true; 

		      } catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        finally {
			       method.releaseConnection();
		        }
		    return result;
		   //if (status == 404)   throw new IllegalArgumentException("Dataset does not exist.");
		  // if (status == 503)   throw new IllegalStateException("Service error: " + status);
		}
	
  public static void main(String[] args) throws Exception {
	 //	 System.out.println(Get("https://20181102t154318-dot-training-project-lab.appspot.com/?fbclid=IwAR2BNcantGQsRYCmG-0DjnLjY7J8m_7hXJQ02K-yem_R7_QVNDXekPUYmpY",400)); 
	//Scenario 1:
	NameValuePair [] User1= { new NameValuePair("playerNumber","2"), new NameValuePair("userName", "mahdi")};  
    System.out.println("New game lobby : "+ POST("",User1,400));
	//System.out.println("hello  "+POST("",User1,201));
	//System.out.println(DELETE("",200));
	// System.out.println(Get("'",200));
	   
  }
}
