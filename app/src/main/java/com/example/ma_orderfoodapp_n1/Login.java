package com.example.ma_orderfoodapp_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Login extends AppCompatActivity {
    Button btnLogin;
    TextView tvRegister;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 1;

    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.e("Bún Type: ", R.drawable.buntype+"");
        Log.e("Bún Đậu: ", R.drawable.bundaumamtom+"");
        Log.e("Bún Riêu: ", R.drawable.bunrieucua+"");
        Log.e("Bún Thịt Nướng: ", R.drawable.bunthitnuong+"");
        Log.e("Bún Măng: ", R.drawable.mangga+"");

        Log.e("Cơm Type: ", R.drawable.comtype+"");
        Log.e("Cơm Cari: ", R.drawable.comcari+"");
        Log.e("Cơm Chiên: ", R.drawable.comchienduongchau+"");
        Log.e("Cơm đùi gà: ", R.drawable.comduiga+"");
        Log.e("Cươm sườn: ", R.drawable.comsuonbicha+"");

        Log.e("Phở Type: ", R.drawable.photype+"");
        Log.e("Phở bò: ", R.drawable.phobo+"");
        Log.e("Phở gà: ", R.drawable.phoga+"");
        Log.e("Phở heo: ", R.drawable.phoheo+"");
        Log.e("Phở sao: ", R.drawable.phosaotomthi+"");

        Log.e("Vịt quay: ", R.drawable.vitquay+"");
        Log.e("Miến gà: ", R.drawable.miengaa+"");
        Log.e("Miến trộn: ", R.drawable.mientron+"");
        Log.e("Xôi gà: ", R.drawable.xoiga+"");
        Log.e("Cút xào me: ", R.drawable.cutxaome+"");
        Log.e("hột vịt lộn: ", R.drawable.hotvitlon+"");

        Log.e("Cháo type: ", R.drawable.chaohs+"");
        Log.e("hủ tiếu: ", R.drawable.hutieunamvang+"");



        initializeListeners();
        onClickListeners();

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);

        ImageButton signInButton = findViewById(R.id.imgGoogle);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imgGoogle:
                        Log.e("Loi: ", "loi");
                        signIn();
                        break;
                    // ...
                }
            }
        });

    }
    private void onClickListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUsername() && validatePassword()) {
                    ResponseRegisterClass responseRegisterClass = new ResponseRegisterClass(etPassword.getText().toString(),etUsername.getText().toString());

                    ApiService apiService = Network.getInstance().create(ApiService.class);
                    apiService.getUser(responseRegisterClass).enqueue(new Callback<ResponseClass>() {
                        @Override
                        public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
                            if (response.body() != null) {
                                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, Introduce1.class);
                                intent.putExtra("username", response.body().getUsername());
                                startActivity(intent);
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseClass> call, Throwable t) {
                            Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }
    public void updateUI(GoogleSignInAccount account) {
        if(account != null) {
            Toast.makeText(this, "Sigin in successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,Introduce1.class));

        }else {
            Toast.makeText(this,"You Didnt signed in",Toast.LENGTH_LONG).show();
        }

    }


    private boolean validatePassword() {
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError("password cannot be empty");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void initializeListeners() {
        etUsername = findViewById(R.id.edtMail);
        etPassword = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
    }
    private boolean validateUsername() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError("username cannot be empty");
            etUsername.requestFocus();
            return false;
        }
        return true;
    }
}