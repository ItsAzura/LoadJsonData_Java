package com.example.loadjsondata_java;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonAsyncTask extends AsyncTask<Void, Void, List<Character>> {
    private static final String JSON_URL = "https://genshinlist.com/api/characters";
    private final JsonAsyncTaskListener listener;
    public interface JsonAsyncTaskListener {
        void onJsonDownloaded(List<Character> data);
    }

    public JsonAsyncTask(JsonAsyncTaskListener listener) {
        this.listener = listener;
    }
    @Override
    protected List<Character> doInBackground(Void... voids) {
        List<Character> result = new ArrayList<>();

        try {
            URL url = new URL(JSON_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Character character = new Character();
                character.setId(jsonObject.getInt("id"));
                character.setName(jsonObject.getString("name"));
                character.setSlug(jsonObject.getString("slug"));
                character.setGender(jsonObject.getString("gender"));
                character.setDescription(jsonObject.getString("description"));
                character.setBirthday(jsonObject.getString("birthday"));
                character.setRarity(jsonObject.getInt("rarity"));
                character.setVision(jsonObject.getString("vision"));
                character.setWeapon(jsonObject.getString("weapon"));
                character.setObtain(jsonObject.getString("obtain"));
                result.add(character);
            }
            inputStream.close();
            httpURLConnection.disconnect();
        }
        catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(List<Character> characters) {

        super.onPostExecute(characters);

        if (listener != null) {
            listener.onJsonDownloaded(characters);
        }
    }
}
