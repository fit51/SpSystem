package kernel.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpConn
{
  public static String connect(String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpGet localHttpGet = new HttpGet(paramString);
      String str1 = null;
    try
    {
      HttpEntity localHttpEntity = localDefaultHttpClient.execute(localHttpGet).getEntity();
      str1 = convertStreamToString(localHttpEntity.getContent());
    }
    catch (IOException localIOException)
    {

    }
    return str1;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream);
    BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
    String result= null;
    try
    {   for(;;){
        String str1 = localBufferedReader.readLine();
        if(str1 == null)
            break;
        result += str1+"\n";
        }
    } catch (IOException e ){
        e.printStackTrace();

    }   finally {
        try {
            localInputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

          return result;

  }
}



/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar

 * Qualified Name:     kernel.connection.HttpConn

 * JD-Core Version:    0.7.0.1

 */