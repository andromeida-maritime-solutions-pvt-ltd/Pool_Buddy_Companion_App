package com.example.smartvoltmeter;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sql extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;
    String address="http://192.168.2.1/basicphp.php";
    InputStream inputStream=null;
    String line=null;
    String result=null;
    String[] data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        listView=(ListView)findViewById(R.id.sql_database);

        //ALLOWING NETWORK ON THIS PAGE

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        //retreive

        getdata();

        //ADAPTER
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }


    private void getdata()
    {
        try {

            URL url = new URL(address);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            inputStream=new BufferedInputStream(con.getInputStream());

        }
        catch(Exception e)
        {
          e.printStackTrace();
        }

        //READ INPUTSTREAM CONTENT INTO A STRING

        try
        {

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb=new StringBuilder();

            while((line=bufferedReader.readLine())!=null)
            {
                sb.append(line+"\n");

            }
            inputStream.close();
            result=sb.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //PARSE JSON DATA

        try{
            JSONArray js=new JSONArray(result);
            JSONObject jo=null;

            data=new String[js.length()];

            for(int i=0;i<js.length();i++)
            {
                jo=js.getJSONObject(i);
                data[i]=jo.getString("time");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
