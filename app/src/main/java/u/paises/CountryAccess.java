package u.paises;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by willy on 25/02/18.
 */

public class CountryAccess {

    private JSONArray countries;

    public CountryAccess(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("countries.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

            //countries = json;
            countries = new JSONArray(json);

            //Log.d("jsone", );

        } catch (IOException ex) {
            Log.d("file", "exception");
            ex.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<String> getCountries(String language) throws JSONException
    {
        List<String> lstCountries = new ArrayList<String>();

        for(int x=0; x< this.countries.length(); x++)
        {
            String country = "";
            if( language == "en" )
                country = this.countries.getJSONObject(x).getString("name");
            else
                country = this.countries.getJSONObject(x).getJSONObject("translations").getString(language);
            //Log.d("paises", country);
            if( country.isEmpty() )
            {
                country = this.countries.getJSONObject(x).getString("name");
            }
            lstCountries.add(country);
            //Log.d("Count", String.valueOf(lstCountries.size()));
        }

        return  lstCountries;
    }
}
