package com.hcmus.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hcmus.information.layout.EditInfoActivity;
import com.hcmus.information.utils.CodeActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnSendInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSendInfo = findViewById(R.id.sendInfo);
        btnSendInfo.setOnClickListener((v) -> onClick());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void onClick() {
        Intent intent = new Intent(this, EditInfoActivity.class);
        startActivityForResult(intent, CodeActivity.CODE_MAIN);
    }
}