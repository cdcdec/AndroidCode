package com.example.netsdk_demo;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

import com.sdk.NetDEVSDK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.os.Environment;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.nio.IntBuffer;

public class CPlayView extends GLSurfaceView {
	private static final boolean DEBUG = false;
	public boolean m_bCanDrawFrame = true; // false
    private boolean m_bRenderInited = false; // render
	public int m_dwWinIndex = 1; // false


	/**
	 * 记录是拖拉照片模式还是放大缩小照片模式
	 */
	private int mode = 0;// 初始状态
	/**
	 * 拖拉照片模式
	 */
	private static final int MODE_DRAG = 1;
	/**
	 * 放大缩小照片模式
	 */
	private static final int MODE_ZOOM = 2;

	/**
	 * 当前放大的倍数
	 */
	private float mCurrentRate = 1;
	/**
	 * 上一次放大的倍数
	 */
	private float mOldRate = 1;
	/**
	 * 刚触摸时两个手指的距离
	 */
	private float mOriginalLength;
	/**
	 * 当前两个手指的距离
	 */
	private float mCurrentLength;
	private float scaleEx = 1.0f;

	float xLastMove = 0.0f;
	float yLastMove = 0.0f;
	float fTotal = 0.0f;
	private float[] fCenterPosition;

    public CPlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
       // Log.i(“----------------------------------”, “PlayView(Context context, AttributeSet attrs)”);
        Log.d("------------", "PlayView(Context context, AttributeSet attrs)");
        // TODO Auto-generated constructor stub
        //mContext = context;  
        //setEGLContextClientVersion(2);
        init(false, 0, 0);

        setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				switch (event.getAction() & MotionEvent.ACTION_MASK) {
					case MotionEvent.ACTION_POINTER_DOWN:
						mode = MODE_ZOOM;
						mOriginalLength = (float) Math.sqrt(Math.pow(event.getX(0) - event.getX(1), 2) + Math.pow(event.getY(0) - event.getY(1), 2));

						//0.47-0.53有效
						float percentX = 0.47f + ((event.getX(0) + event.getX(1)) / 2) / (getWidth()) * 0.06f;
						float percentY = 0.53f - ((event.getY(0) + event.getY(1)) / 2) / (getHeight()) * 0.06f;

						//数字放大手指中心点
						fCenterPosition = new float[]{percentX, percentY};
						break;
					// 手指压下屏幕
					case MotionEvent.ACTION_DOWN:
						mode = MODE_DRAG;
						xLastMove = event.getX();
						yLastMove = event.getY();
//                int id = mPlayerView.getId();
						break;
					// 当触点离开屏幕，但是屏幕上还有触点(手指)
					case MotionEvent.ACTION_POINTER_UP:
						mode = 0;
						break;


					case MotionEvent.ACTION_MOVE:
						if (mode == MODE_DRAG) {// 平移
							float fSum = (float) (scaleEx * 0.5 - 0.5);
							float X = 0.5f;
							float Y = 0.5f;

							X = X - (event.getX() - xLastMove) / (getWidth());
							Y = Y + (event.getY() - yLastMove) / (getHeight());


							float[] fPosition = new float[]{X, Y};
							NetDEVSDK.Scale(scaleEx, fPosition[0], fPosition[1], m_dwWinIndex);

							xLastMove = event.getX();
							yLastMove = event.getY();

						} else if (mode == MODE_ZOOM) {// 缩放
						mCurrentLength = (float) Math.sqrt(Math.pow(event.getX(0) - event.getX(1), 2) + Math.pow(event.getY(0) - event.getY(1), 2));
						if (Math.abs(mCurrentLength - mOriginalLength) > 10) {

							mCurrentRate = (float) (mOldRate * (mCurrentLength / mOriginalLength));

							//通过两个手指间距离判断放大还是缩小
							boolean isLager = (mCurrentLength > mOriginalLength);

							if (isLager) {
								scaleEx += 0.1f;
								//0.05为误差
								if (scaleEx >= 10.05f) {
									scaleEx = 10.0f;
								} else {
									//根据中心点放大
									NetDEVSDK.Scale(scaleEx, fCenterPosition[0], fCenterPosition[1], m_dwWinIndex);
								}
							} else {
								float[] fPosition = new float[]{0.5f, 0.5f};
								scaleEx -= 0.1f;
								//0.05为误差
								if (scaleEx <= 0.95f) {
									scaleEx = 1.0f;
								} else {
									//通过画面中心缩小，防止画面位置飘走
									NetDEVSDK.Scale(scaleEx, fPosition[0], fPosition[1], m_dwWinIndex);

								}
							}
							mOriginalLength = mCurrentLength;

							mOldRate = mCurrentRate;

							fTotal = 0.0f;
							}
						}
						/*NetDEVSDK.gdwWinIndex = 1;
						float percentX1 = 0.5f + event.getX()/m_oPlayer.getWidth();
						float percentY1 = 0.5f - event.getY()/m_oPlayer.getHeight();
						NetDEVSDK.Scale(scaleRatio[0], percentX1, percentY1, NetDEVSDK.gdwWinIndex);
						*/
						break;
					case MotionEvent.ACTION_UP:
						/*
						NetDEVSDK.gdwWinIndex = 1;
						float percentX = 0.5f + event.getX()/m_oPlayer.getWidth();
						float percentY = 0.5f -  event.getY()/m_oPlayer.getHeight();
						scaleRatio[0] += 0.5f;
						if (scaleRatio[0] > 10.05f)
						{
							scaleRatio[0] = 1.0f;
						}
						NetDEVSDK.Scale(scaleRatio[0], percentX, percentY, NetDEVSDK.gdwWinIndex);
						*/

						NetDEVSDK.gdwWinIndex = m_dwWinIndex;

						break;
				}
				return  true;
			}
		});
    }
    
	public CPlayView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		 //setEGLContextClientVersion(2);
		//Log.d("------------", "PlayView(Context context)");
	     //   init(false, 0, 0);

	}
	private void init(boolean translucent, int depth, int stencil) {
        /*
         * By default, GLSurfaceView() creates a RGB_565 opaque surface. If we
		 * want a translucent one, we should change the surface's format here,
		 * using PixelFormat.TRANSLUCENT for GL Surfaces is interpreted as any
		 * 32-bit surface with alpha by SurfaceFlinger.
		 */
        if (translucent) {
            this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        }
        
        //KLog.i(debug, KLog.wrapKeyValue("translucent", translucent));
		/*
		 * Setup the context factory for 2.0 rendering. See ContextFactory class
		 * definition below
		 */
        setEGLContextFactory(new ContextFactory());
		/*
		 * We need to choose an EGLConfig that matches the format of our surface
		 * exactly. This is going to be done in our custom config chooser. See
		 * ConfigChooser class definition below.
		 */
        setEGLConfigChooser(translucent ? new ConfigChooser(8, 8, 8, 8, depth,
                stencil) : new ConfigChooser(5, 6, 5, 0, depth, stencil));
		/* Set the renderer responsible for frame rendering */
;
        setRenderer(new Renderer());
    }
	
    private static class ContextFactory implements
    GLSurfaceView.EGLContextFactory {
    	private static int EGL_CONTEXT_CLIENT_VERSION = 0x3098;

    	public EGLContext createContext(EGL10 egl, EGLDisplay display,EGLConfig eglConfig) {
	   // KLog.w(true, "creating OpenGL ES 2.0 context");
	    checkEglError("Before eglCreateContext", egl);
	    int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, 2, EGL10.EGL_NONE};
	    EGLContext context = egl.eglCreateContext(display, eglConfig,
	            EGL10.EGL_NO_CONTEXT, attrib_list);
	    checkEglError("After eglCreateContext", egl);
	    return context;
    	}
    	
    	public void destroyContext(EGL10 egl, EGLDisplay display,
                   EGLContext context) {
    		   egl.eglDestroyContext(display, context);
    	}
    }
    
    private static void checkEglError(String prompt, EGL10 egl) {
        int error;
        while ((error = egl.eglGetError()) != EGL10.EGL_SUCCESS) {
           // KLog.e(true, String.format("%s: EGL error: 0x%x", prompt, error));
        }
    }
    
    private static class ConfigChooser implements
    GLSurfaceView.EGLConfigChooser {

public ConfigChooser(int r, int g, int b, int a, int depth, int stencil) {
    m_iRedSize = r;
    m_iGreenSize = g;
    m_iBlueSize = b;
    m_iAlphaSize = a;
    m_iDepthSize = depth;
    m_iStencilSize = stencil;
}

/*
 * This EGL config specification is used to specify 2.0 rendering. We
 * use a minimum size of 4 bits for red/green/blue, but will perform
 * actual matching in chooseConfig() below.
 */
private static int EGL_OPENGL_ES2_BIT = 4;
private static int[] s_configAttribs2 = {EGL10.EGL_RED_SIZE, 4,
        EGL10.EGL_GREEN_SIZE, 4, EGL10.EGL_BLUE_SIZE, 4,
        EGL10.EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT, EGL10.EGL_NONE};

	public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {

		/*
		 * Get the number of minimally matching EGL configurations
		 */
	    int[] num_config = new int[1];
	    egl.eglChooseConfig(display, s_configAttribs2, null, 0, num_config);
	
	    int numConfigs = num_config[0];
	
	    if (numConfigs <= 0) {
	        throw new IllegalArgumentException(
	                "No configs match configSpec");
	    }
	
		/*
		 * Allocate then read the array of minimally matching EGL configs
		 */
	    EGLConfig[] configs = new EGLConfig[numConfigs];
	    egl.eglChooseConfig(display, s_configAttribs2, configs, numConfigs,
	            num_config);
	
	    if (DEBUG) {
	        //printConfigs(egl, display, configs);
	    }
	/*
	 * Now return the "best" one
	 */
	    return chooseConfig(egl, display, configs);
	}
    public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display,
            EGLConfig[] configs) {
		for (EGLConfig config : configs) {
		int d = findConfigAttrib(egl, display, config,
		EGL10.EGL_DEPTH_SIZE, 0);
		int s = findConfigAttrib(egl, display, config,
		EGL10.EGL_STENCIL_SIZE, 0);
		
		// We need at least mDepthSize and mStencilSize bits
		if (d < m_iDepthSize || s < m_iStencilSize)
		continue;
		
		// We want an *exact* match for red/green/blue/alpha
		int r = findConfigAttrib(egl, display, config,
		EGL10.EGL_RED_SIZE, 0);
		int g = findConfigAttrib(egl, display, config,
		EGL10.EGL_GREEN_SIZE, 0);
		int b = findConfigAttrib(egl, display, config,
		EGL10.EGL_BLUE_SIZE, 0);
		int a = findConfigAttrib(egl, display, config,
		EGL10.EGL_ALPHA_SIZE, 0);
		
		if (r == m_iRedSize && g == m_iGreenSize && b == m_iBlueSize
		&& a == m_iAlphaSize)
		return config;
		}
		return null;
		}
		
		private int findConfigAttrib(EGL10 egl, EGLDisplay display,
		           EGLConfig config, int attribute, int defaultValue) {
		
		if (egl.eglGetConfigAttrib(display, config, attribute, mValue)) {
		return mValue[0];
		}
		return defaultValue;
		}
	
		private void printConfigs(EGL10 egl, EGLDisplay display,
		        EGLConfig[] configs) {
		int numConfigs = configs.length;
		//KLog.w(true, String.format("%d configurations", numConfigs));
		for (int i = 0; i < numConfigs; i++) {
		//KLog.w(true, String.format("Configuration %d:\n", i));
		printConfig(egl, display, configs[i]);
		}
		}
		
		private void printConfig(EGL10 egl, EGLDisplay display, EGLConfig config) {
		int[] attributes = {EGL10.EGL_BUFFER_SIZE, EGL10.EGL_ALPHA_SIZE,
		EGL10.EGL_BLUE_SIZE,
		EGL10.EGL_GREEN_SIZE,
		EGL10.EGL_RED_SIZE,
		EGL10.EGL_DEPTH_SIZE,
		EGL10.EGL_STENCIL_SIZE,
		EGL10.EGL_CONFIG_CAVEAT,
		EGL10.EGL_CONFIG_ID,
		EGL10.EGL_LEVEL,
		EGL10.EGL_MAX_PBUFFER_HEIGHT,
		EGL10.EGL_MAX_PBUFFER_PIXELS,
		EGL10.EGL_MAX_PBUFFER_WIDTH,
		EGL10.EGL_NATIVE_RENDERABLE,
		EGL10.EGL_NATIVE_VISUAL_ID,
		EGL10.EGL_NATIVE_VISUAL_TYPE,
		0x3030, // EGL10.EGL_PRESERVED_RESOURCES,
		EGL10.EGL_SAMPLES,
		EGL10.EGL_SAMPLE_BUFFERS,
		EGL10.EGL_SURFACE_TYPE,
		EGL10.EGL_TRANSPARENT_TYPE,
		EGL10.EGL_TRANSPARENT_RED_VALUE,
		EGL10.EGL_TRANSPARENT_GREEN_VALUE,
		EGL10.EGL_TRANSPARENT_BLUE_VALUE,
		0x3039, // EGL10.EGL_BIND_TO_TEXTURE_RGB,
		0x303A, // EGL10.EGL_BIND_TO_TEXTURE_RGBA,
		0x303B, // EGL10.EGL_MIN_SWAP_INTERVAL,
		0x303C, // EGL10.EGL_MAX_SWAP_INTERVAL,
		EGL10.EGL_LUMINANCE_SIZE, EGL10.EGL_ALPHA_MASK_SIZE,
		EGL10.EGL_COLOR_BUFFER_TYPE, EGL10.EGL_RENDERABLE_TYPE,
		0x3042 // EGL10.EGL_CONFORMANT
		};
		String[] names = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE",
		"EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE",
		"EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT",
		"EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT",
		"EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH",
		"EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID",
		"EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES",
		"EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE",
		"EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE",
		"EGL_TRANSPARENT_GREEN_VALUE",
		"EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB",
		"EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL",
		"EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE",
		"EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE",
		"EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
		int[] value = new int[1];
		for (int i = 0; i < attributes.length; i++) {
		int attribute = attributes[i];
		String name = names[i];
		if (egl.eglGetConfigAttrib(display, config, attribute, value)) {
		//KLog.w(true, String.format("  %s: %d\n", name, value[0]));
		} else {
		// Log.w(TAG, String.format("  %s: failed\n", name));
		while (egl.eglGetError() != EGL10.EGL_SUCCESS)
		;
		}
		}
		}
		
		protected int m_iRedSize;
		protected int m_iGreenSize;
		protected int m_iBlueSize;
		protected int m_iAlphaSize;
		protected int m_iDepthSize;
		protected int m_iStencilSize;
		private int[] mValue = new int[1];
		}
    
    private class Renderer implements GLSurfaceView.Renderer {

        public Renderer() {
            super();
          
                int ret = NetDEVSDK.initialize();
                if (ret == 1) {
                    m_bRenderInited = true;
               
            }
        }

        public void onDrawFrame(GL10 gl) {
            if (m_bCanDrawFrame && m_bRenderInited) {
            	NetDEVSDK.rendererRender(m_dwWinIndex);
//				KLog.i(debug, "onDrawFrame");
            }
			else
			{
				//清屏
				gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			}
        }

		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			// TODO Auto-generated method stub
			NetDEVSDK.setRendererViewport(width, height);
			
		}

		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			// TODO Auto-generated method stub
			NetDEVSDK.initializeRenderer(m_dwWinIndex);
			
		}
    }

}

