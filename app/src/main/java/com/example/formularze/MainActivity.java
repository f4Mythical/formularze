package com.example.formularze;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvTest;
    Button btnSend, btnGallery;
    EditText eTName, eTDate;
    ListView listView;

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
        ini();
    }

    private void ini() {
        tvTitle = findViewById(R.id.tvTitle);
        tvTest = findViewById(R.id.tvTest);
        btnSend = findViewById(R.id.btnSend);
        btnGallery = findViewById(R.id.btnGallery);
        eTName = findViewById(R.id.eTName);
        eTDate = findViewById(R.id.eTDate);


        String name = eTName.getText().toString().trim();

        eTDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String formattedDate = String.format(Locale.getDefault(), "%02d.%02d.%d", selectedDay, selectedMonth + 1, selectedYear);
                        eTDate.setText(formattedDate);
                        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });
        listView = findViewById(R.id.listView);
    }
}

