package kr.co.ned3y2k.imagelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import kr.co.ned3y2k.imagelistview.api.ApiTaskCallback;
import kr.co.ned3y2k.imagelistview.util.ImageUtil;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);


        ImageUtil.asyncGetImageList(new ApiTaskCallback<ImageList>() {
            @Override
            public void run(ImageList result) {
                listView.setAdapter(new ImageListViewAdatapter(MainActivity.this, result));
            }
        });

    }
}
