package com.github.example.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.example.R;
import com.github.example.home.entity.UserListBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

/**
 * 类描述:    描述该类的功能
 * 创建人:    wzg
 * 创建时间:  2016/11/29
 * 创建人:    wzg
 * 修改时间:  2016/11/29 10:13
 * 修改备注:  说明本次修改内容
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<UserListBean> mUserListBeanArrayList;
    private ImageLoader mImageLoader;
    private DisplayImageOptions options;

    public HomeAdapter(Context context, ArrayList<UserListBean> userListBeanArrayList) {
        mContext = context;
        mUserListBeanArrayList = userListBeanArrayList;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.ic_launcher)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(1000))
                .delayBeforeLoading(0)//int delayInMillis为你设置的下载前的延迟时间
                .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                .build();
        mImageLoader = ImageLoader.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserListBean userListBean = mUserListBeanArrayList.get(position);
        mImageLoader.displayImage(userListBean.getAvatar_url(), holder.img_pic, options);
        holder.tv_name.setText(userListBean.getId());
    }

    @Override
    public int getItemCount() {
        return mUserListBeanArrayList.size();
    }

    public void setList(ArrayList<UserListBean> userListBeanArrayList) {
        mUserListBeanArrayList = userListBeanArrayList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        ImageView img_pic;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            img_pic = (ImageView) itemView.findViewById(R.id.img_pic);
        }
    }
}