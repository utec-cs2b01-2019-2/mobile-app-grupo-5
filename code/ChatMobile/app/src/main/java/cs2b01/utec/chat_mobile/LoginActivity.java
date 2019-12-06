package cs2b01.utec.chat_mobile;

import android.app.DownloadManager;
import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.Request;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    public void onBtnLoginClicked(View view){
        Toast.makeText(this, "Boton clicked!!", Toast.LENGTH_SHORT).show();
        EditText txtUsername = (EditText)findViewById(R.id.txtUsername);
        EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        Toast.makeText(this, username+"--"+password, Toast.LENGTH_SHORT).show();

        Map<String, String> message = new HashMap<>();
        message.put("username", username);
        message.put("password", password);

        JSONObject jsonMessage = new JSONObject(message);
        Toast.makeText(this, jsonMessage.toString(), Toast.LENGTH_SHORT).show();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                "http://10.0.2.2:8000/authenticate",
                jsonMessage,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        //TODO Qué hacer cuando el server responda
                        showMessage("Authorized!");
                        try {
                            String username = response.getString("username");
                            int user_id = response.getInt("user_id");
                            goToContactsActivity(user_id, username);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO Qué hacer cuando ocurra un error
                        showMessage("Unauthorized!!!");

                    }
                }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    private void goToContactsActivity(int user_id, String username) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("user_id", user_id);
        intent.putExtra("username", username);

        startActivity(intent);
    }

    public void goToRegisterActivity(View view){
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }
}
