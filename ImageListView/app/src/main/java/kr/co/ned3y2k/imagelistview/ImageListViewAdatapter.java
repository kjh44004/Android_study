package kr.co.ned3y2k.imagelistview;

import android.app.Activity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by User on 2016-10-28.
 */

public class ImageListViewAdatapter extends BaseAdapter {
    private ImageList imageList;
    private final LayoutInflater li;

    public ImageListViewAdatapter(Activity activity, ImageList imageList) {
        li = (LayoutInflater) activity.getSystemService(ContextThemeWrapper.LAYOUT_INFLATER_SERVICE);
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.imgList.length;
    }

    @Override
    public Object getItem(int position) {
        return imageList.imgList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = li.inflate(R.layout.list_item, null);
            ImageViewHolder imageViewHolder = new ImageViewHolder(convertView, imageList.imgList[position]);
            convertView.setTag(imageViewHolder);
        } else {
            ImageViewHolder imageViewHolder = (ImageViewHolder) convertView.getTag();
            imageViewHolder.setImgPath(imageList.imgList[position]);
        }
        return convertView;
    }
}

class ImageViewHolder {
    private final ImageView imgView;
    private String imgPath;

    public ImageViewHolder(View view, String imgPath) {
        imgView = (ImageView)view.findViewById(R.id.imageView);
        setImgPath(imgPath);
    }

    public View getImgView() {
        return imgView;
    }

    public void setImgPath(String imgPath) {
        Glide
                .with(imgView.getContext())
                .load(imgPath)
                .into(imgView);
    }
}