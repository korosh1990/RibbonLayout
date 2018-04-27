package ir.androidlife.ribbonlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.androidlife.ribbonlayout.Adapter.CustomAdapter;
import ir.androidlife.ribbonlayout.Model.Item;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Item> items;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initItem();
    }

    private void initItem() {
        // 0 = jadid , 1 = Ghadimi , 2 = hichi!
        items = new ArrayList<>();

        items.add(new Item(0, "جدید", "فیلم 12 قدرتمند" , "https://wallpapercave.com/wp/wp2333953.jpg"));
        items.add(new Item(1, "قدیمی", "فیلم خاطره انگیز لئون" , "https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2015/11/12/14/leon3.jpg"));
        items.add(new Item(1, "قدیمی", "فیلم زیبای هابیت" , "http://www-images.theonering.org/torwp/wp-content/uploads/2014/07/follow-me.jpg"));
        items.add(new Item(0, "جدید", "سری جدید بتمن" , "http://media.comicbook.com/2017/11/the-batman-matt-reeves-ben-affleck-jake-gyllenhaal-1059472-1280x0.jpg"));
        items.add(new Item(2, "", "مجموعه کامل هری پاتر" , "https://img.wennermedia.com/article-leads-horizontal/harry-potter-wizarding-world-weekly-194a3b47-580f-46e3-8407-d4cd9c4dc26e.jpg"));

        adapter = new CustomAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }
}
