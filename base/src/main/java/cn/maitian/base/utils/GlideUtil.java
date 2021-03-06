package cn.maitian.base.utils;


import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by geng on 2016/7/19.
 */
public class GlideUtil {
    // -----------------activity-----------------
    public static void loadTransformationImage(FragmentActivity activity, String url, int placeholder, int error, ImageView imageView, Transformation<Bitmap>[] transformations) {
        config(Glide.with(activity), url, placeholder, error)
                .bitmapTransform(transformations)
                .into(imageView);
    }

    public static void loadImage(FragmentActivity activity, String url, int placeholder, int error, ImageView imageView) {
        config(Glide.with(activity), url, placeholder, error).into(imageView);
    }

    // -----------------fragment-----------------
    public static void loadTransformationImage(Fragment fragment, String url, int placeholder, int error, ImageView imageView, Transformation<Bitmap>[] transformations) {
        config(Glide.with(fragment), url, placeholder, error)
                .bitmapTransform(transformations)
                .into(imageView);
    }

    public static void loadImage(Fragment fragment, String url, int placeholder, int error, ImageView imageView) {
        config(Glide.with(fragment), url, placeholder, error).into(imageView);
    }

    // -----------------common-----------------
    private static DrawableRequestBuilder<String> config(RequestManager manager, String url, int placeholder, int error) {
        return manager.load(url)
                .placeholder(placeholder)
                .error(error)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESULT);
    }

}

