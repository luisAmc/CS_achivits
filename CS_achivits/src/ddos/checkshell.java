/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddos;

import java.net.*;

/**
 *
 * @author Luis Martínez/David Discua / Horacio Galdamez / Denisse Carvajal / Emerson Velasquez
 */
public class checkshell {

  public static void mainshellcheck(String s[]) {
    /*
      output :
        true
        false
    */    
  }

  public static boolean exists(String URLName){
     String evilPayload = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(1*3*3*7);    


    String userAgentPayload = "Attack by Discua"+evilPayload;
      int TIMEOUT_VALUE = 0;
   try {
      HttpURLConnection.setFollowRedirects(false);
      HttpURLConnection con =(HttpURLConnection) new URL(URLName).openConnection();
      con.setInstanceFollowRedirects(false);
      con.setConnectTimeout(TIMEOUT_VALUE);
      con.setReadTimeout(TIMEOUT_VALUE);
      con.setConnectTimeout(TIMEOUT_VALUE);
      con.setRequestMethod("HEAD");   
      con.addRequestProperty("User-Agent", userAgentPayload);
      con.disconnect();
      return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
    }



    catch (Exception e) {
       System.out.println("Offline ....");
     //e.printStackTrace();
       return false;
    }
  }
}