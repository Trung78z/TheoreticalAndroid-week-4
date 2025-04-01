package com.hcmus.information.layout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.hcmus.information.R;
import com.hcmus.information.commons.GoBackHomeButton;
import com.hcmus.information.models.Student;
import com.hcmus.information.utils.CodeActivity;


public class ShowInfoActivity extends AppCompatActivity {
    private TextView tvHoTen, tvMSSV, tvLop, tvPhone, tvChuyenNganh, tvNamHoc;
    private Button btnBackHome;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_info);
        if (savedInstanceState == null) {
            GoBackHomeButton homeButtonFragment = new GoBackHomeButton();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, homeButtonFragment);
            transaction.commit();
        }
        Student student = (Student) getIntent().getSerializableExtra("student");
        tvHoTen = findViewById(R.id.tvHoTen);
        tvMSSV = findViewById(R.id.tvMSSV);
        tvLop = findViewById(R.id.tvLop);
        tvPhone = findViewById(R.id.tvPhone);
        tvChuyenNganh = findViewById(R.id.tvChuyenNganh);
        tvNamHoc = findViewById(R.id.tvNamHoc);
        if (student != null) {
            tvHoTen.setText("Họ và tên: " + student.getName());
            tvMSSV.setText("MSSV: " + student.getMssv());
            tvLop.setText("Lớp: " + student.getStudentClass());
            tvPhone.setText("Phone: " + student.getPhone());
            tvChuyenNganh.setText("Chuyên ngành: " + student.getMajor());
            tvNamHoc.setText("Sinh viên năm: " + student.getYear());
        }
        btnBackHome = findViewById(R.id.goBack);
        btnBackHome.setOnClickListener(v -> goBack());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.showInfo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void goBack() {
        Intent resultIntent = new Intent();
        setResult(CodeActivity.CODE_SHOW_INFO, resultIntent);
        finish();
    }
}
