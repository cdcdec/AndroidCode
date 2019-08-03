package com.yzx.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.UUID;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.yzx.cache.impl.YZXImageLoader;
import com.yzx.im_demo.R;
import com.yzx.mydefineview.IMChatImageView;
import com.yzxIM.IMManager;
import com.yzxtcp.tools.CustomLog;

public class BitmapTools {
	 
	private static final String TAG = "BitmapTools";
	public static Bitmap pointBitmap;

	public static Bitmap loadImageBitmap(String url, int screenWidth, int screenHeigh){
		ImgCache mImgCache = ImgCache.getInstance();
    	Bitmap bitmap = mImgCache.getBitmapFromCache(url);
    	
        if (bitmap == null) {
        	if(screenWidth>1500){
            	screenWidth=screenWidth*7/10;
            	screenHeigh=screenHeigh*7/10;
            }else if(screenWidth>1000){
            	screenWidth=screenWidth*6/10;
            	screenHeigh=screenHeigh*6/10;
            }else if(screenWidth>700){
            	screenWidth=screenWidth*4/10;
            	screenHeigh=screenHeigh*4/10;
            }else if(screenWidth>400){
            	screenWidth=screenWidth*3/10;
            	screenHeigh=screenHeigh*3/10;
            }else {
            	screenWidth=screenWidth*2/10;
            	screenHeigh=screenHeigh*2/10;
    		}
            bitmap = BitmapFactory.decodeFile(url);
            if(null!=bitmap){
                if(bitmap.getWidth()>bitmap.getHeight()){
                	int height = (screenWidth*bitmap.getHeight())/bitmap.getWidth();
        	    	bitmap=ThumbnailUtils.extractThumbnail(bitmap, screenWidth, height);
                }else{
                	int width = (screenHeigh*bitmap.getWidth())/bitmap.getHeight();
        	    	bitmap=ThumbnailUtils.extractThumbnail(bitmap, width, screenHeigh);
                }
                return bitmap;
           }
        }
		return bitmap;
	}
	public static void loadImageBitmap(Context context, String url, ImageView imageView, 
			int screenWidth, int screenHeigh) {
		Drawable defaultDrawable = context.getResources().getDrawable(R.drawable.default_img);
		if (TextUtils.isEmpty(url)) {
    		if(imageView!=null){
    			imageView.setImageDrawable(defaultDrawable);
    		}
    		return;
        }

    	ImgCache mImgCache = ImgCache.getInstance();
    	Bitmap bitmap = mImgCache.getBitmapFromCache(url);
    	
        if (bitmap != null) {
        	if(imageView!=null){
        		Drawable drawable = new BitmapDrawable(bitmap);	
        		imageView.setImageDrawable(drawable);
        	}
        }else{
        	File mFile=new File(url);
            if(!mFile.exists()){
            	if(imageView!=null){
        			imageView.setImageDrawable(defaultDrawable);
        		}
        		return;
            }
        	if(screenWidth>1500){
            	screenWidth=screenWidth*7/10;
            	screenHeigh=screenHeigh*7/10;
            }else if(screenWidth>1000){
            	screenWidth=screenWidth*6/10;
            	screenHeigh=screenHeigh*6/10;
            }else if(screenWidth>700){
            	screenWidth=screenWidth*4/10;
            	screenHeigh=screenHeigh*4/10;
            }else if(screenWidth>400){
            	screenWidth=screenWidth*3/10;
            	screenHeigh=screenHeigh*3/10;
            }else {
            	screenWidth=screenWidth*2/10;
            	screenHeigh=screenHeigh*2/10;
    		}
            bitmap = BitmapFactory.decodeFile(url);
            if(null!=bitmap){
                if(bitmap.getWidth()>bitmap.getHeight()){
                	int height = (screenWidth*bitmap.getHeight())/bitmap.getWidth();
            		bitmap = Bitmap.createScaledBitmap(bitmap, screenWidth, height,true);
                }else{
                	int width = (screenHeigh*bitmap.getWidth())/bitmap.getHeight();
        	    	bitmap = Bitmap.createScaledBitmap(bitmap, width, screenHeigh,true);
                }
    	    	mImgCache.addBitmapToCache(url, bitmap);
    	    	if(imageView!=null){
    	    		Drawable drawable = new BitmapDrawable(bitmap);
            		imageView.setImageDrawable(drawable);
            	}
            }
        }
        bitmap = null;
    }
	
	public static void loadChatImageBitmap(Context context, String url, IMChatImageView imageView, 
			int screenWidth, int screenHeigh,boolean isMySelf) {
		if (TextUtils.isEmpty(url)) {
    		if(imageView!=null){
    			Bitmap defaultBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.default_img);
    			imageView.setImageBitmap(defaultBitmap);
    		}
    		return;
        }

    	YZXImageLoader yzxImageLoader = YZXImageLoader.newInstance(context);
    	Bitmap bitmap = yzxImageLoader.get(url);
    	
        if (bitmap != null) {
        	if(imageView!=null){
        		imageView.setImageBitmap(bitmap);
        		return;
        	}
        }else{
        	File mFile=new File(url);
            if(!mFile.exists()){
            	if(imageView!=null){
            		Bitmap defaultBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.default_img);
        			imageView.setImageBitmap(defaultBitmap);
        		}
        		return;
            }
            bitmap = BitmapFactory.decodeFile(url);
            //选择最合适的缩放比例
            Bitmap newBitmap = null;
            if(isMySelf){
            	newBitmap = fillterBimtapBySelf(context,bitmap,screenWidth,screenHeigh);
            }else{
            	newBitmap = fillterBimtap(context,bitmap,screenWidth,screenHeigh);
            }
            if(bitmap != null && !bitmap.isRecycled()){
            	bitmap.recycle();
            	bitmap = null;
            	System.gc();
            }
            if(null != newBitmap){
            	yzxImageLoader.put(url, newBitmap);
    	    	if(imageView!=null){
            		imageView.setImageBitmap(newBitmap);
            	}
            }
        }
        bitmap = null;
    }
	
	public static void loadImageBitmapNoCompress(Context context, String url, ImageView imageView,BitmapIsPutInCacheListener mListener) {
		if (TextUtils.isEmpty(url)) {
    		if(imageView!=null){
    			Drawable defaultDrawable = context.getResources().getDrawable(R.drawable.default_img);
    			imageView.setImageDrawable(defaultDrawable);
    		}
    		return;
        }
    	YZXImageLoader yzxImageLoader = YZXImageLoader.newInstance(context);
    	Bitmap bitmap = yzxImageLoader.get(url);
    	
        if (bitmap != null) {
        	if(imageView!=null){
        		Drawable drawable = new BitmapDrawable(bitmap);	
        		imageView.setImageDrawable(drawable);
        		return;
        	}
        }else{
        	File mFile=new File(url);
            if(!mFile.exists()){
            	if(imageView!=null){
            		Drawable defaultDrawable = context.getResources().getDrawable(R.drawable.default_img);
        			imageView.setImageDrawable(defaultDrawable);
        		}
        		return;
            }
            bitmap = getReSizeBitmap(context, url);
            Log.i(TAG, "reSizeWidth = "+bitmap.getWidth());
            Log.i(TAG, "reSizeHeight = "+bitmap.getHeight());
            if(null != bitmap){
            	if(mListener != null){
            		boolean isPut = yzxImageLoader.put(url, bitmap);
            		if(isPut){
            			mListener.putInCache(null);
            		}else{
            			mListener.putInCache(bitmap);
            		}
            	}else{
            		yzxImageLoader.put(url, bitmap);
            	}
    	    	if(imageView!=null){
    	    		Drawable drawable = new BitmapDrawable(bitmap);
            		imageView.setImageDrawable(drawable);
            	}
            }
        }
        bitmap = null;
    }
	
	public static void loadImageBitmapFromMySelf(Context context, String url, ImageView imageView,BitmapIsPutInCacheListener mListener) {
		Drawable defaultDrawable = context.getResources().getDrawable(R.drawable.default_img);
		if (TextUtils.isEmpty(url)) {
    		if(imageView!=null){
    			imageView.setImageDrawable(defaultDrawable);
    		}
    		return;
        }
    	YZXImageLoader yzxImageLoader = YZXImageLoader.newInstance(context);
    	Bitmap bitmap = yzxImageLoader.get(url+"_byMyself");;
    	
        if (bitmap != null) {
        	if(imageView!=null){
        		Drawable drawable = new BitmapDrawable(bitmap);	
        		imageView.setImageDrawable(drawable);
        	}
        }else{
        	File mFile=new File(url);
            if(!mFile.exists()){
            	if(imageView!=null){
        			imageView.setImageDrawable(defaultDrawable);
        		}
        		return;
            }
            bitmap = getReSizeBitmap(context, url);
            Log.i(TAG, "reSizeWidth = "+bitmap.getWidth());
            Log.i(TAG, "reSizeHeight = "+bitmap.getHeight());
            if(null!=bitmap){
            	url = url + "_byMyself";
            	if(mListener != null){
            		boolean isPut = yzxImageLoader.put(url, bitmap);
            		if(isPut){
            			mListener.putInCache(null);
            		}else{
            			mListener.putInCache(bitmap);
            		}
            	}else{
            		yzxImageLoader.put(url, bitmap);
            	}
    	    	if(imageView!=null){
    	    		Drawable drawable = new BitmapDrawable(bitmap);
            		imageView.setImageDrawable(drawable);
            	}
            }
        }
        bitmap = null;
    }
	
	/**
     * 回收Bitmap图片对象
     * @param bitmap
     */
    public static void recycle(Bitmap bitmap){
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
                bitmap = null;
                System.gc();
            }
            
        }
    }
    
    
    private static BitmapDownloaderTask getBitmapDownloaderTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof DownloadedDrawable)) {
                return null;
            }
            DownloadedDrawable downloadedDrawable = (DownloadedDrawable) drawable;
            return downloadedDrawable.getBitmapDownloaderTask();
        }
        return null;
    }
    
    static class DownloadedDrawable extends BitmapDrawable {
        private final WeakReference<BitmapDownloaderTask> bitmapDownloaderTaskReference;

        public DownloadedDrawable(Drawable defaultBitmap, BitmapDownloaderTask bitmapDownloaderTask) {
            super(((BitmapDrawable) defaultBitmap).getBitmap());
            bitmapDownloaderTaskReference = new WeakReference<BitmapDownloaderTask>(
                    bitmapDownloaderTask);
        }

        public BitmapDownloaderTask getBitmapDownloaderTask() {
            return bitmapDownloaderTaskReference.get();
        }
    }
    
    static class BitmapDownloaderTask extends AsyncTask<Object, Void, Bitmap> {
    	private WeakReference<ImageView> imageViewReference;
    	private ImgCache mImgCache;
        private Context context;
        private String url;
        private int screenWidth;
        private int screenHeigh;
        public BitmapDownloaderTask(ImageView imageView) {
        	if(imageView!=null){
        		imageViewReference = new WeakReference<ImageView>(imageView);
        	}
            mImgCache = ImgCache.getInstance();
        }

        @Override
        protected Bitmap doInBackground(Object... params) {
        	context = (Context) params[0];
            url = (String) params[1];
            screenWidth = (Integer) params[2];
            screenHeigh = (Integer) params[3];
            if(screenWidth>1500){
            	screenWidth=screenWidth*7/10;
            	screenHeigh=screenHeigh*7/10;
            }else if(screenWidth>1000){
            	screenWidth=screenWidth*6/10;
            	screenHeigh=screenHeigh*6/10;
            }else if(screenWidth>700){
            	screenWidth=screenWidth*4/10;
            	screenHeigh=screenHeigh*4/10;
            }else if(screenWidth>400){
            	screenWidth=screenWidth*3/10;
            	screenHeigh=screenHeigh*3/10;
            }else {
            	screenWidth=screenWidth*2/10;
            	screenHeigh=screenHeigh*2/10;
			}
            Bitmap bitmap = BitmapFactory.decodeFile(url);
            if(null!=bitmap){
	            if(bitmap.getWidth()>bitmap.getHeight()){
	            	int height = (screenWidth*bitmap.getHeight())/bitmap.getWidth();
	    	    	bitmap=ThumbnailUtils.extractThumbnail(bitmap, screenWidth, height);
	            }else{
	            	int width = (screenHeigh*bitmap.getWidth())/bitmap.getHeight();
	    	    	bitmap=ThumbnailUtils.extractThumbnail(bitmap, width, screenHeigh);
	            }
		    	mImgCache.addBitmapToCache(url, bitmap);
            }
            return bitmap;
        }

        void getSize(){
        	
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }
            if (imageViewReference != null) {
                ImageView imageView = imageViewReference.get();
                BitmapDownloaderTask bitmapDownloaderTask = null;
                bitmapDownloaderTask = getBitmapDownloaderTask(imageView);
                if (this == bitmapDownloaderTask && bitmap != null) {
                	imageView.setImageDrawable(new BitmapDrawable(bitmap));
                }
            }
        }
    }
    
	private static Bitmap compressImageFromFile(String srcPath, int displayWidth, int displayHeight) {  
        BitmapFactory.Options newOpts = new BitmapFactory.Options();  
        newOpts.inJustDecodeBounds = true;//只读边,不读内容  
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);  
  
        newOpts.inJustDecodeBounds = false;  
        int be = computeScale(newOpts,displayWidth,displayHeight);
        Log.i(TAG, "compressImageFromFile inSampleSize = "+be);
        newOpts.inSampleSize = be;//设置采样率  
          
        newOpts.inPreferredConfig = Config.ARGB_8888;//该模式是默认的,可不设  
        newOpts.inPurgeable = true;// 同时设置才会有效  
        newOpts.inInputShareable = true;//。当系统内存不够时候图片自动被回收  
          
        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);  
        return bitmap;  
    }  
	
	public static String getNewPath(String path, int angle, int screenWidth, int screenHeigh , String targetId) throws IOException{
		File mFile=new File(path);
        //若该文件存在
        if (mFile.exists()) {
        	long size = 0;
  		    FileInputStream fis = null;
  		    fis = new FileInputStream(mFile);
  		    size = fis.available();
  		    fis.close();
  		    int sizeKb = (int) (size/(1024));
  		    int quality = 90;
  		    CustomLog.e("sizeKb:"+sizeKb);
  		    if(sizeKb>6154){
		    	quality=10;
		    }else if(sizeKb>3072){
  		    	quality=30;
  		    }else if(sizeKb>1024){
  		    	quality=40;
  		    }else if(sizeKb>512){
  		    	quality=70;
  		    }
            Bitmap bitmap = compressImageFromFile(path, 768, 1024);
            if(bitmap==null){
            	CustomLog.e("------------选择图片异常--------------");
            	return "";
            }
            bitmap = adjustPhotoRotation(bitmap, angle);
            //saveImageFile(bitmap, path.substring(path.lastIndexOf("/")+1));
            if(!"".equals(targetId)){
            	targetId = targetId+"/";
            	File image_file = new File(Environment.getExternalStorageDirectory().getPath() + "/yunzhixun/image/"+targetId);
        		if (!image_file.exists()) {
        			image_file.mkdirs();
        		}
            }
            File jpegFalseFile = new File(Environment.getExternalStorageDirectory().getPath() + "/yunzhixun/image/", targetId+path.substring(path.lastIndexOf("/")+1));
            if(CPUInfoUtil.isCPU64Bit()){
            	//判断是否是64位cpu，是的话不能调用sdk压缩方式
            	Log.i(TAG, "64 bit cpu compressBitmap");
            	Bitmap compressBitmap = compressImage(bitmap,25*1024);
            	compressBitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(jpegFalseFile));
            }else{
            	Log.i(TAG, "32 bit cpu compressBitmap");
            	IMManager.getInstance(null).compressBitmap(bitmap, quality, jpegFalseFile.getAbsolutePath());
            }
            path=Environment.getExternalStorageDirectory().getPath() + "/yunzhixun/image/"+targetId+path.substring(path.lastIndexOf("/")+1);
        }
		return path;
	}
	
	/**
	* @Description 将图片压缩至指定大小以下
	* @param bitmap
	* @param maxBytes 最大的图片大小
	* @return	返回bitmap
	* @date 2016-1-12 上午10:17:50 
	* @author zhuqian  
	* @return Bitmap
	 */
	private static Bitmap compressImage(Bitmap image,int maxSize) {  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中  
        int options = 100;  
        while (baos.toByteArray().length > maxSize) {  //循环判断如果压缩后图片是否大于300kb,大于继续压缩 
            baos.reset();//重置baos即清空baos  
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            if(options > 10){
            	options -= 10;//每次都减少10
            }else{
            	 break;
            }
        }
        Log.i(TAG, "64 bit cpu simple options = "+options);
        Bitmap bitmap = BitmapFactory.decodeByteArray(baos.toByteArray(), 0, baos.toByteArray().length);
        return bitmap;  
    } 
     
	
    public static Bitmap adjustPhotoRotation(Bitmap bm, final int orientationDegree)
    {
         Matrix m = new Matrix();
         m.setRotate(orientationDegree, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);

         try {
            Bitmap bm1 = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
               return bm1;
            } catch (OutOfMemoryError ex) {
         }
         return null;
    }
    //根据屏幕宽高，匹配合适的图片宽高
    private static Bitmap fillterBimtap(Context context,Bitmap srcBitmap,int screenWidth, int screenHeigh){
    	//最大显示宽
    	int maxWidth = (int) (screenWidth * 0.372);
    	//最大显示高
    	int maxHeight = (int) (screenHeigh * 0.21);
    	//最小显示宽
    	int minWidth = (int) (screenWidth * 0.122);
    	//最小显示高
    	int minHeight = (int) (screenHeigh * 0.08);
    	
    	int width = srcBitmap.getWidth();
    	int height = srcBitmap.getHeight();
    	
    	if(width > 240){
    		width = maxWidth;
    	}else if(width > 150){
    		//按最大宽度的等比例缩放
    		width = (int) ((float)width / 200 * (screenWidth * 0.372));
    	}else if(width > 100){
    		width = (int) (((float)width / 150) * (screenWidth * 0.312));
    	}else if(width > 80){
    		width = (int) (((float)width / 100) * (screenWidth * 0.252));
    	}else{
    		width = minWidth;
    	}
    	//按比例缩放得到的高度
    	height = (int) (width*srcBitmap.getHeight()/srcBitmap.getWidth());
    	Log.i(TAG, "bitmap width = "+width +"，height = "+height);
    	if(height > maxHeight){
    		height = maxHeight;
    	}else if(height < minHeight){
    		height = minHeight;
    	}
    	return Bitmap.createScaledBitmap(srcBitmap, width, height,true);
    }
    
  //根据屏幕宽高，匹配合适的图片宽高
    private static Bitmap fillterBimtapBySelf(Context context,Bitmap srcBitmap,int screenWidth, int screenHeigh){
    	//最大显示宽
    	int maxWidth = (int) (screenWidth * 0.372);
    	//最大显示高
    	int maxHeight = (int) (screenHeigh * 0.21);
    	//最小显示宽
    	int minWidth = (int) (screenWidth * 0.122);
    	//最小显示高
    	int minHeight = (int) (screenHeigh * 0.08);
    	
    	int width = srcBitmap.getWidth();
    	int height = srcBitmap.getHeight();
    	Log.i(TAG, "src bitmap width = "+width +"，height = "+height);
    	if(width > 1500){
    		width = maxWidth;
    	}else if(width > 1200){
    		//按最大宽度的等比例缩放
    		width = (int) ((float)width / 1200 * (screenWidth * 0.342));
    	}else if(width > 900){
    		width = (int) (((float)width / 900) * (screenWidth * 0.322));
    	}else if(width > 600){
    		width = (int) (((float)width / 600) * (screenWidth * 0.302));
    	}else if(width > 300){
    		width = (int) (((float)width / 300) * (screenWidth * 0.282));
    	}else if(width > 100){
    		width = (int) (((float)width / 200) * (screenWidth * 0.262));
    	}else if(width > 50){
    		width = (int) (((float)width / 100) * (screenWidth * 0.222));
    	}else{
    		width = minWidth;
    	}
    	//按比例缩放得到的高度
    	height = (int) (width*srcBitmap.getHeight()/srcBitmap.getWidth());
    	if(height > maxHeight){
    		height = maxHeight;
    		width = srcBitmap.getWidth() * height / srcBitmap.getHeight();
    		if(width > maxWidth){
    			width = maxWidth;
    		}else if(width < minWidth){
    			width = minWidth;
    		}
    	}else if(height < minHeight){
    		height = minHeight;
    	}
    	Log.i(TAG, "dest bitmap width = "+width +"，height = "+height);
    	return Bitmap.createScaledBitmap(srcBitmap, width, height,true);
    }
    
    /**
     * 获取图片方向
     * @param 图片路径
     * @return
     */
    public static int readImageDegree(String path){
    	int degree = 0;
    	try {
			ExifInterface exifInterface = new ExifInterface(path);
			int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return degree;
    }
    /**
    * @Description 保存图片到本地
    * @param src
    * @param targetId
    * @date 2015-12-14 下午9:00:13 
    * @author zhuqian  
    * @return String
     */
    public static String saveLocation(Bitmap src,String targetId){
    	String yzxDir = FileTools.getSdCardFilePath();
    	String srcPath = "";
    	File locationDir = new File(yzxDir+"/location");
    	if(!locationDir.exists()){
    		locationDir.mkdirs();
    	}
    	File targetDir = new File(locationDir.getAbsolutePath()+"/"+targetId);
    	if(!targetDir.exists()){
    		targetDir.mkdirs();
    	}
    	String srcName = Md5FileNameGenerator.generate(UUID.randomUUID().toString().substring(0, 32)+"_"+src.hashCode());
    	srcPath = targetDir.getAbsolutePath()+"/"+srcName+".png";
    	try {
    		//先压缩
    		ByteArrayOutputStream bos = new ByteArrayOutputStream();
    		Bitmap locationBitmap = null;
    		src.compress(Bitmap.CompressFormat.PNG, 100, bos);
    		//设置显示图片的中心区域
			BitmapRegionDecoder bitmapRegionDecoder;
			bitmapRegionDecoder = BitmapRegionDecoder.newInstance(bos.toByteArray(),0,bos.toByteArray().length, false);
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;//只读边,不读内容  
			bitmapRegionDecoder.decodeRegion(new Rect(0,0,src.getWidth(),src.getHeight()), options);
			// 768 * 1024
			int simpleSize = computeScale(options,768 * 2 / 3,1024 / 4);
			options.inJustDecodeBounds = false;
			options.inSampleSize = simpleSize;
			Log.i(TAG, "location inSampleSize = "+simpleSize);
			options.inPreferredConfig = Bitmap.Config.RGB_565;
			locationBitmap = bitmapRegionDecoder.decodeRegion(new Rect(src.getWidth() / 6, src.getHeight() / 4, src.getWidth() * 5 / 6, src.getHeight() * 3 / 4), options);
			bos.reset();
			locationBitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
    		int quality = 90;
    		int sizeKb = bos.toByteArray().length / 1024;
    		Log.i(TAG,"sizeKb = "+sizeKb);
    		if(sizeKb>1024){
		    	quality=5;
		    }else if(sizeKb > 512){
  		    	quality=10;
  		    }else if(sizeKb > 256){
  		    	quality=15;
  		    }else if(sizeKb > 128){
  		    	quality=20;
  		    }else if(sizeKb > 64){
  		    	quality=30;
  		    }
    		if(CPUInfoUtil.isCPU64Bit()){
    			//判断是否是64位cpu，是的话不能调用sdk压缩方式
            	Log.i(TAG, "64 bit cpu compressBitmap");
            	Bitmap compressBitmap = compressImage(locationBitmap,5*1024);
            	compressBitmap.compress(CompressFormat.JPEG, 100, new FileOutputStream(srcPath));
    		}else{
    			IMManager.compressBitmap(locationBitmap, quality, srcPath);
    		}
    		bos.reset();
			return srcPath;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
    }
    public static void loadChatLocationBitmap(Context context,final String url,final IMChatImageView imageView, 
			int screenWidth, int screenHeigh){
    	final YZXImageLoader yzxImageLoader = YZXImageLoader.newInstance(context);
    	if (TextUtils.isEmpty(url)) {
    		if(imageView!=null){
    			//选择最合适的缩放比例
                clipLocationBitmap(context,"",screenWidth,screenHeigh,new OnBitmapClipListener() {
    				@Override
    				public void onClip(Bitmap bitmap) {
    					if(null != bitmap){
    						yzxImageLoader.put(url, bitmap);
    						if(imageView!=null){
    							imageView.setImageBitmap(bitmap);
    						}
    					}
    				}
    			});
    		}
    		return;
        }
    	Bitmap bitmap = yzxImageLoader.get(url);
    	
        if (bitmap != null) {
        	if(imageView!=null){
        		imageView.setImageBitmap(bitmap);
        		return;
        	}
        }else{
        	File mFile=new File(url);
            if(!mFile.exists()){
            	if(imageView!=null){
            		//选择最合适的缩放比例
                    clipLocationBitmap(context,"",screenWidth,screenHeigh,new OnBitmapClipListener() {
        				@Override
        				public void onClip(Bitmap bitmap) {
        					if(null != bitmap){
        						yzxImageLoader.put(url, bitmap);
        						if(imageView!=null){
        							imageView.setImageBitmap(bitmap);
        						}
        					}
        				}
        			});
        		}
        		return;
            }
            //选择最合适的缩放比例
            clipLocationBitmap(context,url,screenWidth,screenHeigh,new OnBitmapClipListener() {
				@Override
				public void onClip(Bitmap bitmap) {
					if(null != bitmap){
						yzxImageLoader.put(url, bitmap);
						if(imageView!=null){
							imageView.setImageBitmap(bitmap);
						}
					}
				}
			});
        }
    }
    /**
    * @Description 以位置图片中间为中心，截取图片
    * @param srcPath	图片路径
    * @date 2015-12-8 上午10:56:09 
    * @author zhuqian  
    * @return void
     */
    private static void clipLocationBitmap(Context context,String path,int screenWidth, int screenHeigh,OnBitmapClipListener listener){
    	//先截取图片，再进行宽高的缩放
    	//获得图片的宽、高
    	File locationFile = new File(path);
    	Bitmap locationBitmap = null;
    	if(!locationFile.exists()){
    		CustomLog.d("要加载的图片位置不存在");
    		locationBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.default_img, null);
    	}else{
			try {
				BitmapFactory.Options tmpOptions = new BitmapFactory.Options();
				tmpOptions.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(path, tmpOptions);
				int width = tmpOptions.outWidth;
				int height = tmpOptions.outHeight;
				//设置显示图片的中心区域
				BitmapRegionDecoder bitmapRegionDecoder;
				bitmapRegionDecoder = BitmapRegionDecoder.newInstance(path, false);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inPreferredConfig = Bitmap.Config.RGB_565;
				locationBitmap = bitmapRegionDecoder.decodeRegion(new Rect(0,0, width, height), options);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	if(locationBitmap != null){
    		//位置图片大小为宽*0.625，高*0.228
    		int width = (int) (0.625 * screenWidth);
    		int height = (int) (0.228 * screenHeigh);
    		if(listener != null){
    			listener.onClip(Bitmap.createScaledBitmap(locationBitmap, width, height,true));
    		}
    		if(!locationBitmap.isRecycled()){
    			locationBitmap.recycle();
    			locationBitmap = null;
    		}
    	}else{
    		if(listener != null){
    			listener.onClip(null);
    		}
    	}
    }
    /**
    * @Description 从View中获取图片
    * @param view
    * @date 2015-12-10 下午4:59:39 
    * @author zhuqian  
    * @return Bitmap
     */
    public static Bitmap getBitmapFromView(View view){
    	view.destroyDrawingCache();
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache(true);
        return bitmap;
    }
    /**
    * @Description 合成位置图片
    * @param srcBitmap
    * @date 2015-12-11 下午6:43:44 
    * @author zhuqian  
    * @return Bitmap
     */
    public static Bitmap getThumbnailLoctionBitmap(Context context,Bitmap srcBitmap){
    	Bitmap desBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
    	Canvas canvas = new Canvas(desBitmap);
    	canvas.drawBitmap(srcBitmap, new Matrix(), null);  
    	if(pointBitmap == null){
    		BitmapTools.pointBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_local);
    	}
    	
    	int x = (srcBitmap.getWidth() - pointBitmap.getWidth()) / 2;
    	int y = srcBitmap.getHeight() / 2 - pointBitmap.getHeight();
    	
    	int xOffset = DensityUtil.dip2px(context, 8);
    	x += xOffset;
    	canvas.drawBitmap(pointBitmap, x, y, null);  //120、350为bitmap2写入点的x、y坐标 
    	
    	if(srcBitmap != null && !srcBitmap.isRecycled()){
    		Log.i(TAG, "recycled srcBitmap");
    		srcBitmap.recycle();
    		srcBitmap = null;
    	}
    	return desBitmap;
    }
    /**
    * @Description 从当前Activity获取图片
    * @return	图片
    * @date 2015-12-11 下午6:02:28 
    * @author zhuqian  
    * @return Bitmap
     */
    public static Bitmap getBitmapFromActivity(Activity activity){
    	 activity.getWindow().getDecorView().setDrawingCacheEnabled(true);
    	 Bitmap bmp= activity.getWindow().getDecorView().getDrawingCache();
    	 return bmp;
    }
    /**
    * @Description 裁剪图片适合屏幕
    * @param context
    * @param path
    * @return	返回合适尺寸的Bitmap
    * @date 2016-1-11 下午2:43:31 
    * @author zhuqian  
    * @return Bitmap
     */
    private static Bitmap getReSizeBitmap(Context context,String path){
		if(context instanceof Activity){
			int width = ((Activity)context).getWindowManager().getDefaultDisplay().getWidth();
			int height = ((Activity)context).getWindowManager().getDefaultDisplay().getHeight();
			BitmapFactory.Options newOpts = new BitmapFactory.Options();  
	        newOpts.inJustDecodeBounds = true;//只读边,不读内容  
	        BitmapFactory.decodeFile(path, newOpts);
	        //原来的图片宽度
	        int orinalWidth = newOpts.outWidth;
	        Log.i(TAG, "orinalWidth = "+orinalWidth);
	        //原来的图片高度
	        int orinalHeight = newOpts.outHeight;
	        Log.i(TAG, "orinalHeight = "+orinalHeight);
	        newOpts.inSampleSize = computeScale(newOpts,width,height);
	        Log.i(TAG, "inSampleSize = "+newOpts.inSampleSize);
	        newOpts.inJustDecodeBounds = false;
	        return BitmapFactory.decodeFile(path, newOpts);
		}
		return BitmapFactory.decodeFile(path);
	}
    /**
    * @Description 根据View(主要是ImageView)的宽和高来计算Bitmap缩放比例。默认不缩放 
    * @param options
    * @param viewWidth
    * @param viewHeight
    * @return	缩放值
    * @date 2016-1-11 下午2:44:20 
    * @author zhuqian  
    * @return int
     */
    private static int computeScale(BitmapFactory.Options options, int viewWidth, int viewHeight){  
        int inSampleSize = 1;  
        if(viewWidth == 0 || viewWidth == 0){  
            return inSampleSize;  
        }  
        int bitmapWidth = options.outWidth;  
        int bitmapHeight = options.outHeight;  
          
        //假如Bitmap的宽度或高度大于我们设定图片的View的宽高，则计算缩放比例  
        if(bitmapWidth > viewWidth || bitmapHeight > viewHeight){
            int widthScale = Math.round((float) bitmapWidth / (float) viewWidth);  
            int heightScale = Math.round((float) bitmapHeight / (float) viewWidth);  
              
            //为了保证图片不缩放变形，我们取宽高比例最小的那个  
            inSampleSize = widthScale < heightScale ? widthScale : heightScale;  
        }
        return inSampleSize;  
    } 
    /**
    * @Title BitmapIsPutInCacheListener 
    * @Description 需要被回收的图片对象
    * @Company yunzhixun
    * @author zhuqian
    * @date 2015-12-7 下午3:13:10
     */
    public interface BitmapIsPutInCacheListener{
    	void putInCache(Bitmap recycleBitmap);
    }
    /**
    * @Title BitmapClipListener 
    * @Description 图片截取回调
    * @Company yunzhixun
    * @author zhuqian
    * @date 2015-12-8 上午11:41:15
     */
    public interface OnBitmapClipListener{
    	void onClip(Bitmap bitmap);
    }
}
