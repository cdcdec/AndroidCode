package com.yzx.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.yzxtcp.tools.FileTools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Bitmap.CompressFormat;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.media.ExifInterface;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @Title TakeCameraTool
 * @Description 在后台拍照，旋转、保存
 * @Company yunzhixun
 * @author xhb
 * @date 2017-2-16 下午3:05:05
 */
public class TakeCameraTool implements PictureCallback {
	private static final String TAG = TakeCameraTool.class.getSimpleName();
	private boolean isRunning; // 是否已在监控拍照
	private Camera mCamera;
	private Callback cb;
	private static TakeCameraTool takeCameraTool;

	private TakeCameraTool(Callback cb) {
		this.cb = cb;
	}

	/**
	 * @Title Callback   
	 * @Description  回调监听
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2017-2-17 上午11:17:02
	 */
	public interface Callback {
		void callback(String path);
	}

	public static TakeCameraTool getInstance(Callback cb) {
		if (takeCameraTool == null) {
			synchronized (TakeCameraTool.class) {
				if (takeCameraTool == null) {
					takeCameraTool = new TakeCameraTool(cb);
				}
			}
		}
		return takeCameraTool;
	}

	public void takeCamera() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (!isRunning) {
					SurfaceView preview = CameraWindow.getDummyCameraView();
					if (preview != null) {
						autoTakePic(preview);
					} else {
						if (cb != null) {
							cb.callback("");
						}
					}
				}
			}
		}).start();
	}

	private void autoTakePic(SurfaceView preview) {
		Log.d(TAG, "autoTakePic...");
		isRunning = true;
		mCamera = getFacingFrontCamera();
		if (mCamera == null) {
			Log.w(TAG, "getFacingFrontCamera return null");
			if (cb != null) {
				cb.callback("");
			}
			return;
		}
		try {
			mCamera.setPreviewDisplay(preview.getHolder());
			mCamera.startPreview();// 开始预览
			takePicture(); 
		} catch (Exception e) {
			Log.d(TAG, "Exception :" + e.getMessage());
			e.printStackTrace();
			releaseCamera();
			if (cb != null) {
				cb.callback("");
			}
		}
	}

	private void takePicture() throws Exception {
		Log.d(TAG, "takePicture...");
		try {
			mCamera.takePicture(null, null, this);
		} catch (Exception e) {
			Log.d(TAG, "Exception :" + e.getMessage());
			Log.d(TAG, "takePicture failed!");
			e.printStackTrace();
			throw e;
		}
	}

	private Camera getFacingFrontCamera() {
		CameraInfo cameraInfo = new CameraInfo();
		int numberOfCameras = Camera.getNumberOfCameras();
		for (int i = 0; i < numberOfCameras; i++) {
			Camera.getCameraInfo(i, cameraInfo);
			if (cameraInfo.facing == CameraInfo.CAMERA_FACING_FRONT) {
				try {
					return Camera.open(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		Log.d(TAG, "onPictureTaken...");
		Log.d(TAG, "data:" + data.length);
		releaseCamera();
		Bitmap adjustBitmap = null;
		try {
			// 旋转图片
			Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			adjustBitmap = adjustPhotoRotation(bitmap, 270);
			String previewPic = FileTools.createPicFilePath("previewpic.jpg");
			File file = new File(previewPic);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			Log.d(TAG, "previewPic:" + file.getAbsolutePath());
			if (savePic(Bitmap2Byte(adjustBitmap), file)) { 
				if (cb != null) {
					cb.callback(file.getAbsolutePath());
				}
			} else {
				if (cb != null) {
					cb.callback("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (cb != null) {
				cb.callback("");
			}
		} finally {
			if(adjustBitmap != null) {
				adjustBitmap.recycle();
				adjustBitmap = null;
			}
		}
	}

	// 保存照片
	private boolean savePic(byte[] data, File savefile) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(savefile);
			fos.write(data);
			fos.flush();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	// 释放照相机
	private void releaseCamera() {
		if (mCamera != null) {
			isRunning = false;
			Log.d(TAG, "releaseCamera...");
			mCamera.stopPreview();
			mCamera.release();
			mCamera = null;
		}
	}
	
	/**
	 * @Description 图片旋转
	 * @param bm 需要旋转的图片
	 * @param orientationDegree 旋转角度
	 * @return	旋转后的图片	
	 * @date 2017-2-17 上午11:15:26 
	 * @author xhb  
	 * @return Bitmap    返回类型
	 */
	public static Bitmap adjustPhotoRotation(Bitmap bm, final int orientationDegree) {
		Matrix m = new Matrix();
		m.setRotate(orientationDegree, (float) bm.getWidth() / 2,
				(float) bm.getHeight() / 2);
		try {
			Bitmap bm1 = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(),
					bm.getHeight(), m, true);
			return bm1;
		} catch (OutOfMemoryError ex) {
			ex.printStackTrace();
		} finally {
			if(bm != null) {
				bm.recycle();
				bm = null;
			}
		}
		return null;
	}
	
	/**
	 * @Description bitmap对象转换成byte数组  
	 * @param bitmap
	 * @return	byte数组
	 * @date 2017-2-28 下午3:47:09 
	 * @author xhb  
	 * @return byte[]    返回类型
	 */
	public static byte[] Bitmap2Byte(Bitmap bitmap) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.JPEG, 100, baos);
		return baos.toByteArray();
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
    
}
