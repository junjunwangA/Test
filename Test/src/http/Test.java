package http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {

    public static void main(String[] args) throws Exception {
    	System.setProperty("java.net.preferIPv4Stack" , "true");
    	InetSocketAddress inet = new InetSocketAddress(10001);
    	
        HttpServer server = HttpServer.create(inet, 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
       
        server.start();
        System.out.println( server.getAddress()+"  "+ InetAddress.getLocalHost() );
        
        System.out.println("server started");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            System.out.println(t.getRemoteAddress()+" "+t.getLocalAddress());
            BufferedReader reader = new BufferedReader(new InputStreamReader(t.getRequestBody(),"utf-8"));
            System.out.println("client request method:"+t.getRequestMethod());
            String tmp=null;
            StringBuffer requestBody=new StringBuffer();
            while((tmp=reader.readLine())!=null){
            	requestBody.append(tmp);
            }
            reader.close();
            System.out.println("requestBody:"+requestBody);
            t.sendResponseHeaders(200, response.getBytes().length);
            
            OutputStream os = t.getResponseBody();
//            System.out.println(response);
            os.write(response.getBytes());

            os.close();
        }
         
        
    }

}
