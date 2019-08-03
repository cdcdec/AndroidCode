package com.yzx.tools;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import androidx.collection.LruCache;


public class ImgCache {
	private LruCache<String, Bitmap> mMemoryCache;
	private LinkedHashMap<String, SoftReference<Bitmap>> mSoftBitmapCache;
	private Context mContext;
	private static ImgCache INSTANCE;

	private ImgCache() {}

	public static ImgCache getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ImgCache();
		} else if (null == INSTANCE.mContext) {
			throw new IllegalAccessError("must init image cache before use");
		}
		return INSTANCE;
	}

	public void init(Context context) {
		this.mContext = context;
		final int memClass = ((ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		final int cacheSize = 1024 * 1024 * memClass / 6;
		
		if (mMemoryCache == null){
			mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
				@Override
				protected int sizeOf(String key, Bitmap bitmap) {
					return bitmap.getRowBytes() * bitmap.getHeight();
				}
				@Override
				protected void entryRemoved(boolean evicted, String key,
						Bitmap oldValue, Bitmap newValue) {
					mSoftBitmapCache.put(key, new SoftReference<Bitmap>(oldValue));
				}
			};
		}
		
		final int SOFT_CACHE_CAPACITY = 50;
		if(mSoftBitmapCache==null){
			mSoftBitmapCache =new LinkedHashMap<String, SoftReference<Bitmap>>(
					SOFT_CACHE_CAPACITY, 0.75f, true){
			
				private static final long serialVersionUID = 1L;

				@Override
				public SoftReference<Bitmap> put(String key,
						SoftReference<Bitmap> value) {
					return super.put(key, value);
				}

				@Override
				protected boolean removeEldestEntry(
						LinkedHashMap.Entry<String, SoftReference<Bitmap>> eldest) {
					if (size() > SOFT_CACHE_CAPACITY) {
						System.out.println("Soft Reference limit , purge one");
						return true;
					}
					return false;
				}
				
			};
		}
	}
    
	private void addBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (getBitmapFromCache(key) == null) {
			synchronized(mMemoryCache){
				mMemoryCache.put(key, bitmap);
			}
		}
	}
	
	public void removeBitmapFromMemoryCache(String key) {
	    key=key.substring(key.lastIndexOf("/")+1, key.length());
		Bitmap bm=getBitmapFromCache(key);
		if ( bm!= null) {
			mMemoryCache.remove(key);
			mSoftBitmapCache.remove(key);
			BitmapTools.recycle(bm);
		}
	}

    public void removeBitmapFromMemoryCache() {
        if (mMemoryCache != null) {
            mMemoryCache.evictAll();
        }
    }

	public void releaseSoftBitmapCache() {
		if (mSoftBitmapCache != null) {
			for (LinkedHashMap.Entry<String, SoftReference<Bitmap>> entry : mSoftBitmapCache
					.entrySet()) {
				Bitmap bitmap = entry.getValue().get();
				if (bitmap != null) {
					BitmapTools.recycle(bitmap);
				}
			}
			mSoftBitmapCache.clear();
		}
	}

	public int cachesize() {
		return mMemoryCache.size();
	}

	public Bitmap getBitmapFromCache(String key) {
	    key=key.substring(key.lastIndexOf("/")+1, key.length());
		synchronized(mMemoryCache){
			final Bitmap bitmap=mMemoryCache.get(key);
			if(bitmap!=null){
				return bitmap;
			}
			
			synchronized (mSoftBitmapCache) {
				SoftReference<Bitmap> bitmapReference = mSoftBitmapCache.get(key);
				if(bitmapReference!=null){
					final Bitmap bitmap2=bitmapReference.get();
					if(bitmap2!=null){
						return bitmap2;
					}else{
						 System.out.println("soft reference have recycle");
					     mSoftBitmapCache.remove(key);
					}
				}
			}
			return null;
		}
	}
	
	
	public void addBitmapToCache(String imageUrl, Bitmap bitmap) {
	    if (null == imageUrl || null == bitmap){
	        return;
	    }
	    String imageName=imageUrl.substring(imageUrl.lastIndexOf("/")+1, imageUrl.length());
		BitmapWorkerTask mTask = new BitmapWorkerTask();
		Object[] params = new Object[2];
		params[0] = bitmap;
		params[1] = imageName;
		mTask.execute(params);
	}
	
	/**
	 * anroid AsyncTask寮傛镓ц
	 * @author jacky
	 *
	 */
	class BitmapWorkerTask extends AsyncTask<Object, Integer, String> {

		@Override
		protected void onPreExecute() {
		}
		@Override
		protected String doInBackground(Object... params) {
			addBitmapToMemoryCache((String) params[1], (Bitmap) params[0]);
			return null;
		}
		@Override
		protected void onProgressUpdate(Integer... progresses) {

		}
		@Override
		protected void onPostExecute(String result) {

		}
		@Override
		protected void onCancelled() {
		}

	}

}
