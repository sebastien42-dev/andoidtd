package com.example.androidtd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PasserelleApi extends Service {

    private final String URL = "http://http://usertd.test/api/user/list";
    Gson gson;

/*   public PasserelleApi() {
}
*/
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void WebService() {
        this.gson = new Gson();
    }

    private InputStream sendRequest(URL url) throws Exception {

        try {
            // Ouverture de la connexion
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Connexion à l'URL
            urlConnection.connect();

            // Si le serveur nous répond avec un code OK
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return urlConnection.getInputStream();
            }
        } catch (Exception e) {
            throw new Exception("");
        }
        return null;
    }

    public List<Users> getUsers() {

        try {
            // Envoi de la requête
            InputStream inputStream = sendRequest(new URL(URL));

            // Vérification de l'inputStream
            if(inputStream != null) {
                // Lecture de l'inputStream dans un reader
                InputStreamReader reader = new InputStreamReader(inputStream);

                // Retourne la liste désérialisée par le moteur GSON
                return gson.fromJson(reader, new TypeToken<List<Users>>(){}.getType());
            }

        } catch (Exception e) {
            Log.e("PasserelleApi", "Mais où sont les users ?");
        }
        return null;
    }

}