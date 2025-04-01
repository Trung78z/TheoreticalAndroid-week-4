package com.hcmus.information.layout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

public class EditInfoActivity extends AppCompatActivity {
    private Button applyInfo,btnClearDataInput;
    private EditText editTextName;
    private EditText editTextMSSV;
    private EditText editTextClass;
    private EditText editTextPhone;
    private RadioGroup radioGroupYear;
    private RadioGroup radioGroupMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_info);
        if (savedInstanceState == null) {
            GoBackHomeButton homeButtonFragment = new GoBackHomeButton();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, homeButtonFragment);
            transaction.commit();
        }
        editTextName = findViewById(R.id.editTextName);
        editTextMSSV = findViewById(R.id.editTextMSSV);
        editTextClass = findViewById(R.id.editTextClass);
        editTextPhone = findViewById(R.id.editTextPhone);
        radioGroupYear = findViewById(R.id.radioGroupYear);
        radioGroupMajor = findViewById(R.id.radioGroupMajor);
        btnClearDataInput = findViewById(R.id.clearDataInput);
        applyInfo = findViewById(R.id.applyInfo);
        applyInfo.setOnClickListener(v -> applyInfo());
        btnClearDataInput.setOnClickListener(v->{
            editTextName.setText("");
            editTextMSSV.setText("");
            editTextClass.setText("");
            editTextPhone.setText("");
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editInfo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void applyInfo() {
        String name = editTextName.getText().toString().trim();
        String mssv = editTextMSSV.getText().toString().trim();
        String studentClass = editTextClass.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        int selectedYearId = radioGroupYear.getCheckedRadioButtonId();
        int selectedMajorId = radioGroupMajor.getCheckedRadioButtonId();
        String year = selectedYearId != -1 ? ((RadioButton) findViewById(selectedYearId)).getText().toString() : "";
        String major = selectedMajorId != -1 ? ((RadioButton) findViewById(selectedMajorId)).getText().toString() : "";
        if (name.isEmpty() || mssv.isEmpty() || studentClass.isEmpty() || phone.isEmpty() || selectedYearId == -1 || selectedMajorId == -1) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }
        Student student = new Student(name, mssv, studentClass, phone, year, major);
        Intent intent = new Intent(this, ShowInfoActivity.class);
        intent.putExtra("student", student);
        startActivityForResult(intent, CodeActivity.CODE_EDIT_STUDENT);
    }
}
