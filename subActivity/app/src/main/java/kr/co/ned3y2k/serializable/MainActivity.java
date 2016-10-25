package kr.co.ned3y2k.serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText textView1;
    private EditText textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (EditText) findViewById(R.id.textView);
        textView2 = (EditText) findViewById(R.id.textView2);
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(view.getContext(), SubActivity.class);
        intent.putExtra("string1", textView1.getText().toString());
        intent.putExtra("string2", textView2.getText().toString());
        startActivity(intent);
    }
}
