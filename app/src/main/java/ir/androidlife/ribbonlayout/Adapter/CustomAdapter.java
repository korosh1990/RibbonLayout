package ir.androidlife.ribbonlayout.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.battleent.ribbonviews.RibbonLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

import ir.androidlife.ribbonlayout.Model.Item;
import ir.androidlife.ribbonlayout.R;

/**
 * Created by Mojtaba on 4/27/2018.
 */

class CustomViewHolder extends RecyclerView.ViewHolder {

    RibbonLayout ribbonLayout;
    ImageView imageView;

    public CustomViewHolder(View itemView) {
        super(itemView);

        ribbonLayout = (RibbonLayout)itemView.findViewById(R.id.ribbonLayout);
        imageView = (ImageView)itemView.findViewById(R.id.imageView);
    }
}

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    Context context;
    List<Item> itemList;

    public CustomAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Item item = itemList.get(position);
        if(item.type == 0) //جدید
        {
            holder.ribbonLayout.setShowBottom(true);
            holder.ribbonLayout.setShowBottom(true);

            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#2B323A"));
            holder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

            holder.ribbonLayout.setHeaderText(item.headerText);
            holder.ribbonLayout.setBottomText(item.bottomText);
            Picasso.with(context).load(item.imageURL)
                    .into(holder.imageView);


        }
        else if(item.type == 1) //قدیمی
        {
            holder.ribbonLayout.setShowBottom(true);
            holder.ribbonLayout.setShowBottom(true);

            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#B94948"));
            holder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

            holder.ribbonLayout.setHeaderText(item.headerText);
            holder.ribbonLayout.setBottomText(item.bottomText);
            Picasso.with(context).load(item.imageURL)
                    .into(holder.imageView);
        }

        else {
            holder.ribbonLayout.setShowBottom(false);
            holder.ribbonLayout.setShowBottom(false);


            
            Picasso.with(context).load(item.imageURL)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
