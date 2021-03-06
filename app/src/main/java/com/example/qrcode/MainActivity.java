package com.example.qrcode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    private EditText editText2;
    private ImageView imageView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText2 = findViewById(R.id.editText2);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
    }

    public void btnOK(View view) {
        getCode(view);
    }
    public void getCode(View view){
        BarcodeEncoder encoder = new BarcodeEncoder();
        try {
            Bitmap bit = encoder.encodeBitmap(editText2.getText().toString(),
                    BarcodeFormat.QR_CODE,
                    250, 250);
            imageView.setImageBitmap(bit);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
