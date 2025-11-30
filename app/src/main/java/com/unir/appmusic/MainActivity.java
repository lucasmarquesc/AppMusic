package com.unir.appmusic;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_tocar, btn_parar;
    private RadioGroup radioGroup;
    private Intent intent;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        btn_tocar = findViewById(R.id.btn_tocar);
        btn_parar = findViewById(R.id.btn_parar);
        radioGroup = findViewById(R.id.radioGroup);
        intent = new Intent(MainActivity.this, MyService.class);
        setSupportActionBar(toolbar);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    1);
        }

        btn_tocar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                selecionarMusica();
                RadioButton rb = findViewById(radioGroup.getCheckedRadioButtonId());
                String musica = rb.getText().toString();
                intent.putExtra("musica", musica);
                intent.putExtra("id", id);
                startForegroundService(intent);
            }
        });

        btn_parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }

    public void selecionarMusica(){
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == R.id.rb_jack) {
            this.id = R.raw.jack_sparrow;
        }else if (id == R.id.rb_happy) {
            this.id = R.raw.happy_birthday;
        }else if (id == R.id.rb_luck) {
            this.id = R.raw.bad_luck;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "O App não pode funcionar corretamente sem a permissão", Toast.LENGTH_SHORT).show();
            }
        }
    }
}