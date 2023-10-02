package com.example.keylistenerx;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setFocusable(true);
        textView.requestFocus();

        textView.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                String scancode = String.valueOf(event.getScanCode());
                String keycode = String.valueOf(keyCode);
                String keyName = KeyEvent.keyCodeToString(keyCode);

                // 在TextView中显示按键信息
                textView.append("Scancode: " + scancode  + " Keycode: " + keycode + " " + keyName + "\n");

                // 使用Toast提示用户按键信息
                Toast.makeText(this, "Scancode: " + scancode + " Keycode: " + keycode + "\n" + keyName, Toast.LENGTH_SHORT).show();

                // 打印到Logcat
                Log.e("Devin Key Pressed", "Scancode: " + scancode + ", Keycode: " + keycode + ", 按键含义: " + keyName);
                textView.setMovementMethod(new ScrollingMovementMethod());
                return true;
            }
            return false;
        });
    }
}
