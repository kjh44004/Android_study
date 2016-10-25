package kr.co.ned3y2k.serializable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textView1 = (TextView) findViewById(R.id.textView3);
        TextView textView2 = (TextView) findViewById(R.id.textView4);

        textView1.setText(getIntent().getStringExtra("string1"));
        textView2.setText(getIntent().getStringExtra("string2"));
    }

    public static void startActivity(Context context, String string1, String string2){

        Intent intent = new Intent(context, SubActivity.class);
        intent.putExtra("string1", string1);
        intent.putExtra("string2", string2);
        context.startActivity(intent);

    }
}
