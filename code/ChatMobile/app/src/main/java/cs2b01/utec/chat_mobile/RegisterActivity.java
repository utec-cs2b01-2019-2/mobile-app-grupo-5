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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void backActivityLogin(View view){
        Intent register = new Intent(this, LoginActivity.class);
        startActivity(register);
    }

    public void ActRegister(View view) {

        EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        EditText txtFullname = (EditText) findViewById(R.id.txtFullname);
        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);

        final String username = txtUsername.getText().toString();
        final
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        String fullname = txtFullname.getText().toString();
        String numero = txtNumero.getText().toString();}

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://127.0.0.1:8000/register");
}
}