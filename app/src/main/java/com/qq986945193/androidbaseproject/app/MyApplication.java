package com.qq986945193.androidbaseproject.app;

import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.qq986945193.androidbaseproject.utils.OkHttpUtils;
/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @GitHub: https://github.com/QQ986945193
 */

/**
 * Application的配置 继承MultiDexApplication是为了使项目能够突破65535限制
 */
public class MyApplication extends MultiDexApplication {
    private static MyApplication app;
    private ImageLoader imageLoader = null;
    private DisplayImageOptions imageOptions;
    private OkHttpUtils mOkHttpUtils;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        /**
         * 这里使用抽取出来的封装imageloder，当然，用本类中的也是可以的
         *
         * 如果用本类中的UniversalImageloader配置 调用方法如下：
         *
         * 1,ImageLoader imageLoader = MyApplication.getApp().getImageLoader();
         *
         * 2,DisplayImageOptions options = MyApplication.getApp().getImageOptions();
         *
         *        // 图片显示
         *
         *   3,     imageLoader.displayImage(图片的url,ImageView控件,options);
         */
        ImageLoaderConfig.initImageLoader(this, getCacheDir().getAbsolutePath());

//        initUniversalImageLoader();

        initOkHttpUtils();
        //最基本的初始化Fresco
        initFresco();

    }


    /**
     * 最基本的初始化Fresco
     */
    private void initFresco() {
        Fresco.initialize(this);
    }

    /**
     * 初始化OkHttp
     */
    private void initOkHttpUtils() {
        mOkHttpUtils = OkHttpUtils.getInstance();

    }


    public static MyApplication getApp() {
        return app;
    }


    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public DisplayImageOptions getImageOptions() {
        return imageOptions;
    }

    /**
     * @return
     * @GitHub: https://github.com/QQ986945193
     * @CSDN博客: http://blog.csdn.net/qq_21376985
     */
    public OkHttpUtils getOkHttpUtils() {
        return this.mOkHttpUtils;
    }

}
