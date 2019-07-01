#  dpi与density与屏幕宽高

像素密度是屏幕上单位面积内的像素数，称为 dpi（每英寸的点数）。 它与分辨率不同，分辨率是屏幕上像素的总数。


密度无关像素:在指定尺寸时，请务必使用 dp 或 sp 单位。dp 是一种密度无关像素，对应于 160 dpi 下像素的物理尺寸。 sp 是相同的基本单位，但它会按用户首选的文本尺寸进行缩放（属于缩放无关像素）.


* xxxhdpi   4.0
* xxhdpi    3.0
* xhdpi：  2.0
* hdpi：  1.5
* mdpi： 1.0（基准）
* ldpi：   0.75

```
//Metrics 指标  度量；  Display：显示
var dm:DisplayMetrics=DisplayMetrics()
windowManager.defaultDisplay.getMetrics(dm)
Log.e("123","densit=" +dm.density)//3.0
Log.e("123","densityDpi=" +dm.densityDpi)//480
Log.e("123","widthPixels=" +dm.widthPixels)//1080
Log.e("123","heightPixels=" +dm.heightPixels)//1920

widthDp:widthPx/density+0.5
heightDp:heightPx/density+0.5

widthPx=widthDp*density+0.5
heightPx=heightDp*density+0.5
```

### java获取Android设备的屏幕信息

```
public class ScreenInfo {
    private float density;
    private int densityDpi;
    private int widthPixels;
    private int heightPixels;
    private float widthDpi;
    private float heightDpi;
    /**
     *横竖屏
     */
    private String orientation;
    /**
     *Android系统版本号
     */
    private String systemVersion;
    /**
     *手机型号
     */
    private String systemModel;
    /**
     *手机厂商
     */
    private String deviceBrand;

    /**
     *设备制造商
     */
    private String  facturer;

    /**
     *整个产品的名称
     */
    private String product;

    /**
     *api level
     */
    private int sdkLevel;


    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public int getWidthPixels() {
        return widthPixels;
    }

    public void setWidthPixels(int widthPixels) {
        this.widthPixels = widthPixels;
    }

    public int getHeightPixels() {
        return heightPixels;
    }

    public void setHeightPixels(int heightPixels) {
        this.heightPixels = heightPixels;
    }

    public float getWidthDpi() {
        return widthDpi;
    }

    public void setWidthDpi(float widthDpi) {
        this.widthDpi = widthDpi;
    }

    public float getHeightDpi() {
        return heightDpi;
    }

    public void setHeightDpi(float heightDpi) {
        this.heightDpi = heightDpi;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(String systemModel) {
        this.systemModel = systemModel;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getFacturer() {
        return facturer;
    }

    public void setFacturer(String facturer) {
        this.facturer = facturer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getSdkLevel() {
        return sdkLevel;
    }

    public void setSdkLevel(int sdkLevel) {
        this.sdkLevel = sdkLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "density:" + density +
                ", densityDpi:" + densityDpi +
                ", widthPixels:" + widthPixels +
                ", heightPixels:" + heightPixels +
                ", widthDpi:" + widthDpi +
                ", heightDpi:" + heightDpi +
                ", orientation:\"" + orientation + "\"" +
                ", systemVersion:\"" + systemVersion + "\"" +
                ", systemModel:\"" + systemModel + "\"" +
                ", deviceBrand:\"" + deviceBrand + "\"" +
                ", facturer:\"" + facturer + "\"" +
                ", product:\"" + product + "\"" +
                ", sdkLevel:" + sdkLevel +
                '}';
    }
}



import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class ScreenUtil {
        private final  String TAG="dpi";
        public  ScreenInfo screen(Activity activity){
            DisplayMetrics displayMetrics=new DisplayMetrics();
            WindowManager windowManager=activity.getWindowManager();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            ScreenInfo screenInfo=new ScreenInfo();
            float density=displayMetrics.density;
            int dpi=displayMetrics.densityDpi;
            screenInfo.setDensity(density);
            screenInfo.setDensityDpi(dpi);
            int widthPix= displayMetrics.widthPixels;
            int heightPix=displayMetrics.heightPixels;
            screenInfo.setWidthPixels(widthPix);
            screenInfo.setHeightPixels(heightPix);
            float xDpi=displayMetrics.xdpi;
            float yDpi=displayMetrics.ydpi;
            Log.e(TAG,"xDpi="+xDpi+",yDpi="+yDpi);//268.941  268.694
            float widthDpi=widthPix/density+0.5f;
            float heightDpi=heightPix/density+0.5f;
            screenInfo.setWidthDpi(widthDpi);
            screenInfo.setHeightDpi(heightDpi);
            if(activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                screenInfo.setOrientation("横屏");
            } else if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                screenInfo.setOrientation("竖屏");
            }
            screenInfo.setDeviceBrand(android.os.Build.BRAND);
            screenInfo.setSdkLevel(android.os.Build.VERSION.SDK_INT);
            screenInfo.setSystemModel(android.os.Build.MODEL);
            screenInfo.setFacturer(android.os.Build.MANUFACTURER);
            screenInfo.setProduct(android.os.Build.PRODUCT);
            screenInfo.setSystemVersion(android.os.Build.VERSION.RELEASE);
            Log.e(TAG, screenInfo.toString());
            return screenInfo;
        }
    }
```

### 生成dimens.xml文件

```
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateDimen {
    private static void createDimens() throws IOException{
        File file=new File("E:/dimens_960.xml");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        out.write("<resources>");
        out.write("\r\n");
        Double scale=Double.parseDouble("960.000000")/Double.parseDouble("960.000000");

        System.out.println(scale);
        float ii=0f;
        for(int i=1;i<=960;i++){
            out.write("<dimen name=\"dp"+i+"\">");

            out.write(i*scale+"dp");
            out.write("</dimen>");
            out.write("\r\n");
        }

        out.write("</resources>");
        out.close();
        System.out.println("文件创建成功！");
    }

    public static void main(String[] args)  {
        try {
            createDimens();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

