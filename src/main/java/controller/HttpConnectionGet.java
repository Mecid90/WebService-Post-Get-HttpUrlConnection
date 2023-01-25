package controller;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionGet {

    public static void main(String[] args) throws IOException, JSONException {

            HttpURLConnection con;
            BufferedReader bufferedReader = null;


                URL url = new URL("https://test-link.yigim.az/checkInvoice?invoiceRef=925181");
                con = (HttpURLConnection) url.openConnection();
                String userCredentials = "testlinkusername:testlinkpassword";
                String auth = new String(new Base64().encode(userCredentials.getBytes()));

                con.setRequestProperty("X-Signature", auth);
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");

                con.setRequestMethod("GET");
                int responseCode = con.getResponseCode();
                System.out.println("GET Response Code: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) {
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }
                bufferedReader.close();

                    JSONObject resp = new JSONObject(response);

                    System.out.println(resp);

                }

    }
}