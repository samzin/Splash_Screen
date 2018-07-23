package cdac.lrhs.com.splash_screen;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context context;
    String register_url = "http://avinashkumbhar.com/CIF/register.php";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];

        if (method.equals("register")) {
            String name = params[1];
            String contact = params[2];
            String address = params[3];
            String department = params[4];
            String useremail = params[5];
            String guidename = params[6];
            String guideeamil = params[7];
            String gstin = params[8];
            String staecode = params[9];
            String pass = params[10];
            String utid = params[11];
            String iname = params[12];

            try {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();


                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("Username", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("Contact", "UTF-8") + "=" + URLEncoder.encode(contact, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("department", "UTF-8") + "=" + URLEncoder.encode(department, "UTF-8") + "&" +
                        URLEncoder.encode("useremail", "UTF-8") + "=" + URLEncoder.encode(useremail, "UTF-8") + "&" +
                        URLEncoder.encode("guidename", "UTF-8") + "=" + URLEncoder.encode(guidename, "UTF-8") + "&" +
                        URLEncoder.encode("guideemail", "UTF-8") + "=" + URLEncoder.encode(guideeamil, "UTF-8") + "&" +
                        URLEncoder.encode("gstin", "UTF-8") + "=" + URLEncoder.encode(gstin, "UTF-8") + "&" +
                        URLEncoder.encode("statecode", "UTF-8") + "=" + URLEncoder.encode(staecode, "UTF-8") + "&" +
                        URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&" +
                        URLEncoder.encode("iname", "UTF-8") + "=" + URLEncoder.encode(iname, "UTF-8") + "&" +
                        URLEncoder.encode("utid", "UTF-8") + "=" + URLEncoder.encode(utid, "UTF-8");

                Log.d("savedata", data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                InputStream IS = httpURLConnection.getInputStream();

                BufferedReader rd = new BufferedReader(new InputStreamReader(IS));
                StringBuilder sb = new StringBuilder("");
                String line;
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }
                String finalResult = sb.toString();

                if (finalResult.contains("inserted")) {
                    Log.d("notification", "Home Screen");
                } else if (finalResult.contains("Contact")) {
                    Log.d("notification", "Login Screen");
                }

                Log.d("savedata", finalResult);
                IS.close();

                return "";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
