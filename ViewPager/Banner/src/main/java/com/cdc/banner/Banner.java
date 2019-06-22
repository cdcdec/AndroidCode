package com.cdc.banner;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cdc.banner.listener.BannerVideo;
import com.cdc.banner.listener.OnBannerListener;
import com.cdc.banner.loader.ImageLoaderInterface;
import com.cdc.banner.view.BannerViewPager;
import com.cdc.banner.view.CustomView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.support.v4.view.ViewPager.OnPageChangeListener;
import static com.shuyu.gsyvideoplayer.video.base.GSYVideoView.CURRENT_STATE_PLAYING;


public class Banner extends FrameLayout implements OnPageChangeListener {
    public String tag = "banner";
    private int scrollTime = 800;
    private boolean isScroll = true;
    private int mLayoutResId = R.layout.banner;
    private int count = 0;
    private int currentItem;
    private List imageUrls;
    private List<View> imageViews;
    private Context context;
    private BannerViewPager viewPager;
    private TextView numIndicator;
    private ImageLoaderInterface imageLoader;
    private BannerPagerAdapter adapter;
    private OnPageChangeListener mOnPageChangeListener;
    private BannerScroller mScroller;
    private OnBannerListener listener;

    private BannerVideo bannerVideo;


    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Banner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        imageUrls = new ArrayList<>();
        imageViews = new ArrayList<>();
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        imageViews.clear();
        View view = LayoutInflater.from(context).inflate(mLayoutResId, this, true);
        viewPager = (BannerViewPager) view.findViewById(R.id.bannerViewPager);
        numIndicator = (TextView) view.findViewById(R.id.numIndicator);
        initViewPagerScroll();
    }


    private void initViewPagerScroll() {
        try {
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            mScroller = new BannerScroller(viewPager.getContext());
            mScroller.setDuration(scrollTime);
            mField.set(viewPager, mScroller);
        } catch (Exception e) {
            Log.e(tag, e.getMessage());
        }
    }


    public Banner setImageLoader(ImageLoaderInterface imageLoader) {
        this.imageLoader = imageLoader;
        return this;
    }

    public Banner setImages(List<?> imageUrls) {
        this.imageUrls = imageUrls;
        this.count = imageUrls.size();
        return this;
    }


    public Banner start() {
        setImageList(imageUrls);
        setData();
        return this;
    }

    private void initImages() {
        imageViews.clear();
        numIndicator.setText("1/" + count);

    }

    private void setImageList(List<?> imagesUrl) {
        if (imagesUrl == null || imagesUrl.size() <= 0) {
            return;
        }
        initImages();
        for (int i = 0; i <= count + 1; i++) {
            Log.e("123","i="+i);
            View imageView = null;
            if (imageLoader != null) {
                //Log.e("123","======createImageView0======");
                if(i==1 || i==(count+1)){
                    imageView = imageLoader.createImageView(context,1);
                }else{
                    imageView = imageLoader.createImageView(context,2);
                }

            }
            Object url = null;
            if (i == 0) {//显示最后一个元素
                url = imagesUrl.get(count - 1);
                Log.e("123","i==0,"+url.toString());
            } else if (i == count + 1) {//显示第一个元素
                url = imagesUrl.get(0);
                Log.e("123","i==count+1,"+(count+1)+","+url.toString());
            } else {//显示中间的元素  真正的元素
                url = imagesUrl.get(i - 1);
                Log.e("123","i=="+(i-1)+","+url.toString());
            }
            imageViews.add(imageView);
            if (imageLoader != null)
                imageLoader.displayImage(context, url, imageView);
            else
                Log.e(tag, "Please set images loader.");
        }
    }
    CustomView customView;
    private void setData() {
        currentItem = 1;
        if (adapter == null) {
            adapter = new BannerPagerAdapter();
            viewPager.addOnPageChangeListener(this);
        }
        viewPager.setAdapter(adapter);
        viewPager.setFocusable(true);
        viewPager.setCurrentItem(1);

         customView= (CustomView) imageViews.get(1);
        videoView=customView.getVideoView();
        videoView.setVisibility(View.VISIBLE);
        videoView.getBackButton().setVisibility(View.GONE);
        videoView.getFullscreenButton().setVisibility(View.GONE);

        getBuilder(imageUrls.get(0).toString()).build(videoView);



        bannerVideo.bannerVideo(videoView);



        if (isScroll && count > 1) {
            viewPager.setScrollable(true);
        } else {
            viewPager.setScrollable(false);
        }
    }

    private GSYVideoOptionBuilder getBuilder(String url){
        //增加封面
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.xxx1);
        videoView.setThumbImageView(imageView);
        GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
        gsyVideoOption.setThumbImageView(imageView)
//                .setIsTouchWiget(true)
//                .setRotateViewAuto(false)
//                .setLockLand(false)
//                .setAutoFullWithSize(true)
//                .setShowFullAnimation(false)
//                .setNeedLockFull(true)
                .setUrl(url)
                .setCacheWithPlay(true)
                .setVideoTitle("");

        //设置为Surface播放模式，注意此设置是全局的
        GSYVideoType.setShowType(GSYVideoType.SCREEN_MATCH_FULL);





        return gsyVideoOption;
    }




    /**
     * 返回真实的位置
     *
     * @param position
     * @return 下标从0开始
     */
    public int toRealPosition(int position) {
        int realPosition = (position - 1) % count;
        if (realPosition < 0)
            realPosition += count;
        return realPosition;
    }

    class BannerPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            container.addView(imageViews.get(position));
            View view = imageViews.get(position);
            if (listener != null) {
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.OnBannerClick(toRealPosition(position));
                    }
                });
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrollStateChanged(state);
        }
//        Log.i(tag,"currentItem: "+currentItem);
        switch (state) {
            case 0://No operation
                if (currentItem == 0) {
                    viewPager.setCurrentItem(count, false);
                } else if (currentItem == count + 1) {
                    Log.e("123","最后一个元素");
                    viewPager.setCurrentItem(1, false);
                }
                break;
            case 1://start Sliding
                if (currentItem == count + 1) {
                    viewPager.setCurrentItem(1, false);
                } else if (currentItem == 0) {
                    viewPager.setCurrentItem(count, false);
                }
                break;
            case 2://end Sliding
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrolled(toRealPosition(position), positionOffset, positionOffsetPixels);
        }
    }

    private StandardGSYVideoPlayer videoView;


    public StandardGSYVideoPlayer  getVideoView(){
        return videoView;
    }



    private ImageView iv;
    private int dur=0;
    @Override
    public void onPageSelected(int position) {
        currentItem = position;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageSelected(toRealPosition(position));
        }
        Log.e("123","position="+position);
        if (position == 0){
            position = count;
        }
        if (position > count){
            position = 1;
        }

        customView= (CustomView) imageViews.get(position);

        if(position==1 || position==(count+1)){
            videoView=customView.getVideoView();
            iv=customView.getImageView();
            videoView.setVisibility(View.VISIBLE);
            iv.setVisibility(View.GONE);

            getBuilder(imageUrls.get(0).toString()).build(videoView);
            //增加封面
//            ImageView imageView = new ImageView(context);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setImageResource(R.drawable.empty_drawable);
//            videoView.setThumbImageView(imageView);



            if(dur>10){
                //
                Log.e("123","seek to dur="+dur);
                videoView.seekTo(dur);
               // videoView.startPlayLogic();

            }


        }else{
            if(videoView!=null){
                if(videoView.getCurrentState() == CURRENT_STATE_PLAYING){
                    videoView.onVideoPause();

                    dur=videoView.getCurrentPositionWhenPlaying();
                    bannerVideo.bannerVideoDuration(dur);

                    Log.e("123","tag="+videoView.getPlayTag());
                    Log.e("123","dur="+videoView.getCurrentPositionWhenPlaying());
                }
            }
            videoView.setVisibility(View.GONE);
            iv.setVisibility(View.VISIBLE);

            iv.setImageURI((Uri) imageUrls.get(toRealPosition(position)));

        }






        numIndicator.setText(position + "/" + count);
    }


    /**
     * 废弃了旧版接口，新版的接口下标是从1开始，同时解决下标越界问题
     *
     * @param listener
     * @return
     */
    public Banner setOnBannerListener(OnBannerListener listener) {
        this.listener = listener;
        return this;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        mOnPageChangeListener = onPageChangeListener;
    }


    public Banner setBannerVideo(BannerVideo bannerVideo) {
        this.bannerVideo = bannerVideo;
        return this;
    }





}
