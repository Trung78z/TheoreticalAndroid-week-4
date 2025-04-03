package com.hcmus.information;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
        Button callButton = findViewById(R.id.callButton);
        Button smsButton = findViewById(R.id.smsButton);
        Button cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(v -> {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, CodeActivity.REQUEST_CAMERA_PERMISSION);
            } else {

                openCamera();
            }
        });
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "tel:+1234567890";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                startActivity(callIntent);
            }
        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+1234567890";
                String message = "Hello, this is a test message!";
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
                smsIntent.putExtra("sms_body", message);
                startActivity(smsIntent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CodeActivity.REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "Can't found Camera", Toast.LENGTH_SHORT).show();
        }
    }


    private void onClick() {
        Intent intent = new Intent(this, EditInfoActivity.class);
        startActivityForResult(intent, CodeActivity.CODE_MAIN);
    }
}