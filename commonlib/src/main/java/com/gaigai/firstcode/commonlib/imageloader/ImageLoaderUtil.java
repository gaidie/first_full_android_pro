package com.gaigai.firstcode.commonlib.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.gaigai.firstcode.commonlib.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by ga on 2017/2/16.
 */

public class ImageLoaderUtil {

    private static final int THREAD_COUNT = 4;//最多4个线程可以加载图片
    private static final int PRIORITY = 2;//图片加载优先级
    private static final int DISK_CACHE_SIZE = 50 * 1024;//缓存图片的最大缓存容量
    private static final int CONNECTION_TIME_OUT = 10 * 1000;//连接的超时时间
    private static final int READ_TIME_OUT = 30 * 1000;//读取的超时时间

    private static ImageLoader mImageLoader = null;
    private static ImageLoaderUtil mImageLoaderUtil = null;

    private ImageLoaderUtil(Context context){
        //单例模式的私有构造方法
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
                .Builder(context)
                .threadPoolSize(THREAD_COUNT)//图片下载的线程数量
                .threadPriority(Thread.NORM_PRIORITY - PRIORITY)
                .denyCacheImageMultipleSizesInMemory()//防止缓存不同尺寸大小的图片
                .memoryCache(new WeakMemoryCache())//使用弱引用内存缓存
        .diskCacheSize(DISK_CACHE_SIZE)//分配硬盘
        .diskCacheFileNameGenerator(new Md5FileNameGenerator())//使用MD5命名缓存文件名
        .tasksProcessingOrder(QueueProcessingType.LIFO)//图片现在顺序
        .defaultDisplayImageOptions(getDefaultImageOptions())//默认图片加载Options
        .imageDownloader(new BaseImageDownloader(context, CONNECTION_TIME_OUT, READ_TIME_OUT))//设置图片下载器
                .writeDebugLogs()//debug环境下会输出日志
        .build();
        ImageLoader.getInstance().init(configuration);
        mImageLoader = ImageLoader.getInstance();
    }

    /**
     * 图片下载的参数Options配置
     * @return
     */
    private DisplayImageOptions getDefaultImageOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.xadsdk_img_error)//图片加载失败的显示图片
        .cacheInMemory(true)//图片是否可以缓存在内存中
        .cacheOnDisk(true)//图片是否可以缓存在硬盘中
        .bitmapConfig(Bitmap.Config.RGB_565)// 使用图片解码类型
        .decodingOptions(new BitmapFactory.Options())//图片解码配置
        .build();
        return options;
    }

    public static ImageLoaderUtil getInstance(Context context){
        if (mImageLoaderUtil == null){
            synchronized (ImageLoaderUtil.class){
                if (mImageLoaderUtil == null){
                    mImageLoaderUtil = new ImageLoaderUtil(context);
                }
            }
        }
        return mImageLoaderUtil;
    }

    /**
     * 显示图片
     * @param imageView
     * @param url
     * @param options
     * @param listener
     */
    public void displayImage(ImageView imageView, String url,
                             DisplayImageOptions options,
                             ImageLoadingListener listener){
        if (mImageLoader != null){
            mImageLoader.displayImage(url, imageView, options, listener);
        }
    }

    public void displayImage(ImageView imageView, String url){
        if (mImageLoader != null){
            mImageLoader.displayImage(url, imageView);
        }
    }

    public void displayImage(ImageView imageView, String url,
                             ImageLoadingListener listener){
        if (mImageLoader != null){
            mImageLoader.displayImage(url, imageView, listener);
        }
    }
}
