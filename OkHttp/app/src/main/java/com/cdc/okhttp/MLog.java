package com.cdc.okhttp;
import android.app.Application;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MLog {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final int V = 0x1;
    private static final int D = 0x2;
    private static final int I = 0x3;
    private static final int W = 0x4;
    private static final int E = 0x5;
    private static final int A = 0x6;

    private static final String TOP = "╔═══════════════════════════════════════════════════════════════════════════════════════";
    private static final String BOTTOM = "╚═══════════════════════════════════════════════════════════════════════════════════════";

    private static final String SHORT_TOP = "╔════════════════════";
    private static final String SHORT_BOTTOM = "╚════════════════════";

    private static final Config config = new Config();
    private static SimpleDateFormat simpleDateFormat;

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private static Application sApplication;


    public static Config getConfig() {
        return config;
    }

    public static void init(final Application app) {
        sApplication = app;
    }


    public static void v(String msg) {
        printLog(V, config.getGlobalTag(), msg);
    }

    public static void v(String tag, Object... msg) {
        String message = formatString(msg);
        printLog(V, tag, message);
    }


    public static void v(Object... msg) {
        String message = formatString(msg);
        printLog(V, config.getGlobalTag(), message);
    }


    public static void vFile(String filePath, Object... msg) {
        String message = formatString(msg);
        printLog(V, config.getGlobalTag(), message);
        writeToFile(filePath, message);
    }


    public static void d(String msg) {
        printLog(D, config.getGlobalTag(), msg);
    }

    public static void d(String tag, Object... msg) {
        String message = formatString(msg);
        printLog(D, tag, message);
    }


    public static void d(Object... msg) {
        String message = formatString(msg);
        printLog(D, config.getGlobalTag(), message);
    }


    public static void dFile(String filePath, Object... msg) {
        String message = formatString(msg);
        printLog(D, config.getGlobalTag(), message);
        writeToFile(filePath, message);
    }


    public static void i(String msg) {
        printLog(I, config.getGlobalTag(), msg);
    }

    public static void i(String tag, Object... msg) {
        String message = formatString(msg);
        printLog(I, tag, message);
    }


    public static void i(Object... msg) {
        String message = formatString(msg);
        printLog(I, config.getGlobalTag(), message);
    }


    public static void iFile(String filePath, Object... msg) {
        String message = formatString(msg);
        printLog(I, config.getGlobalTag(), message);
        writeToFile(filePath, message);
    }


    public static void w(String msg) {
        printLog(W, config.getGlobalTag(), msg);
    }

    public static void w(String tag, Object... msg) {
        String message = formatString(msg);
        printLog(W, tag, message);
    }


    public static void w(Object... msg) {
        String message = formatString(msg);
        printLog(W, config.getGlobalTag(), message);
    }


    public static void wFile(String filePath, Object... msg) {
        String message = formatString(msg);
        printLog(W, config.getGlobalTag(), message);
        writeToFile(filePath, message);
    }


    public static void a(String msg) {
        printLog(A, config.getGlobalTag(), msg);
    }

    public static void a(String tag, Object... msg) {
        String message = formatString(msg);
        printLog(A, tag, message);
    }


    public static void a(Object... msg) {
        String message = formatString(msg);
        printLog(A, config.getGlobalTag(), message);
    }


    public static void aFile(String filePath, Object... msg) {
        String message = formatString(msg);
        printLog(A, config.getGlobalTag(), message);
        writeToFile(filePath, message);
    }




    public static void e(String msg) {
        printLog(E, config.getGlobalTag(), msg);
    }

    public static void e(String tag, Object... msg) {
        String message = formatString(msg);
        printLog(E, tag, message);
    }


    public static void e(Object... msg) {
        String message = formatString(msg);
        printLog(E, config.getGlobalTag(), message);
    }


    public static void eFile(String filePath, Object... msg) {
        String message = formatString(msg);
        writeToFile(filePath, message);
    }

    private static void printType(int type, String tag, String logStr) {
        switch (type) {
            case V:
                android.util.Log.v(tag, logStr);
                break;
            case D:
                android.util.Log.d(tag, logStr);
                break;
            case I:
                android.util.Log.i(tag, logStr);
                break;
            case W:
                android.util.Log.w(tag, logStr);
                break;
            case E:
                android.util.Log.e(tag, logStr);
                break;
            case A:
                android.util.Log.wtf(tag, logStr);
                break;
        }
    }

    public static void printLine(int type, String tag, boolean isTop) {
        if (isTop) {
            printType(type, tag, TOP);
        } else {
            printType(type, tag, BOTTOM);
        }
    }

    private static void printLog(int type, String tag, String message) {
        if (config.isLogSwitch()) {
            StringBuilder stringBuilderFile = new StringBuilder();
            StringBuilder stringBuilderFileResult = new StringBuilder();
            StringBuilder stringBuilder = new StringBuilder();
            if (config.mLogConsoleSwitch) {
                printLine(type, tag, true);
            }
            stringBuilderFile.append(SHORT_TOP);
            stringBuilderFile.append(LINE_SEPARATOR);
            String methodName = getMethodName();
            stringBuilder.append(methodName);
            stringBuilder.append(getTimeStr());
            stringBuilder.append(LINE_SEPARATOR);
            stringBuilderFile.append(methodName);
            stringBuilderFile.append(getTimeStr());
            stringBuilderFile.append(LINE_SEPARATOR);
            if (message != null && message.length() > 0) {
                stringBuilder.append(formatJson(message));
                stringBuilderFile.append(formatJson(message));
            }
            String logStr = stringBuilder.toString();
            String[] lines = logStr.split(LINE_SEPARATOR);
            if (config.mLogConsoleSwitch) {
                for (String line : lines) {
                    printType(type, tag, "║ " + line);
                }
                printLine(type, tag, false);
            }
            if (config.ismLogFileTotalSwitch()) {
                String logStrFile = stringBuilderFile.toString();
                String[] linesFile = logStrFile.split(LINE_SEPARATOR);
                for (String line : linesFile) {
                    stringBuilderFileResult.append(LINE_SEPARATOR);
                    stringBuilderFileResult.append(line);
                }
                stringBuilderFileResult.append(LINE_SEPARATOR);
                stringBuilderFileResult.append(SHORT_BOTTOM);
                writeToFile(stringBuilderFileResult.toString());
            }
        }
    }

    private static void writeToFile(final String filePath, final String message) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                File file = new File(filePath);
                if (file.exists() && file.isFile()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(SHORT_TOP);
                    stringBuilder.append(LINE_SEPARATOR);
                    stringBuilder.append(getMethodName());
                    stringBuilder.append(LINE_SEPARATOR);
                    stringBuilder.append(message);
                    stringBuilder.append(LINE_SEPARATOR);
                    stringBuilder.append(SHORT_BOTTOM);
                    BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
                        bw.write(stringBuilder.toString());
                    } catch (Exception e) {

                    } finally {
                        try {
                            if (bw != null) {
                                bw.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        throw new Exception("文件不存在,请检查文件路径");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 返回当前时间 11:08:12
     *
     * @return
     */
    private static String getTimeStr() {
        String format = getSdf().format(new Date());
        return format.substring(11);
    }

    /**
     * 返回当前时间 2019_09_28
     *
     * @return
     */
    private static String getDateStr() {
        String format = getSdf().format(new Date());
        return format.substring(0, 10);
    }

    private static void writeToFile(final String message) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                BufferedWriter bw = null;
                String filePath = "";
                if (config.getDir().length() == 0) {
                    if (sApplication != null) {
                        filePath = sApplication.getExternalCacheDir().getAbsolutePath() + FILE_SEPARATOR + config.getFilePrefix() + FILE_SEPARATOR + getDateStr() + "_log" + config.getFileExtension();
                    } else {
                        try {
                            throw new Exception("init MLog in Application");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    String tempDir = config.getDir();
                    File file = new File(tempDir);
                    if (file.exists() && file.isDirectory()) {
                        filePath = tempDir + FILE_SEPARATOR + config.getFilePrefix() + FILE_SEPARATOR + getDateStr() + "_log" + config.getFileExtension();
                    } else {
                        boolean hasCreate = new File(tempDir).mkdirs();
                        if (hasCreate) {
                            filePath = tempDir + FILE_SEPARATOR + config.getFilePrefix() + FILE_SEPARATOR + getDateStr() + "_log" + config.getFileExtension();
                        }
                    }
                }

                File file = new File(filePath);
                if(file!=null){
                    File parentFile=file.getParentFile();
                    if(parentFile!=null && !parentFile.exists()){
                        parentFile.mkdirs();
                    }
                }
                try {
                    bw = new BufferedWriter(new FileWriter(filePath, true));
                    bw.write(message);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static String getMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index = 5;
        String className = stackTrace[index].getFileName();
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ (").append(className).append(":").append(lineNumber).append(")#").append(methodName).append(" ] ");
        String logStr = stringBuilder.toString();
        return logStr;
    }

    private static String formatJson(String message) {
        try {
            if (message.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(message);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (message.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(message);
                message = jsonArray.toString(4);
            } else {

            }
        } catch (JSONException e) {

        }

        return message;
    }


    private static SimpleDateFormat getSdf() {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss", Locale.getDefault());
        }
        return simpleDateFormat;
    }


    private static String formatString(Object... contents) {
        String body = "";
        if (contents != null) {
            if (contents.length == 1) {
                body = contents[0].toString();
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0, len = contents.length; i < len; ++i) {
                    Object content = contents[i];
                    sb.append("args")
                            .append("[")
                            .append(i)
                            .append("]")
                            .append(" = ")
                            .append(formatJson(content.toString()))
                            .append(LINE_SEPARATOR);
                }
                body = sb.toString();
            }
        }
        return body;
    }




    public static final class Config {
        /**
         * log文件保存的位置
         */
        private String mDir ="";
        /**
         * 控制log的开关
         */
        private boolean mLogSwitch = true;  //控制log的开关
        /**
         * 控制log是否在控制台显示
         */
        private boolean mLogConsoleSwitch = true;//控制log是否在控制台显示

        /**
         * 控制log是否保存在文件中  默认将所有的保存在文件中
         */
        private boolean mLogFileTotalSwitch = true;
        private String mGlobalTag = "MLog";    // The global tag of log.
        /**
         * log文件的前缀
         */
        private String mFilePrefix = "log";
        /**
         * log文件的后缀
         */
        private String mFileExtension = ".txt";

        private boolean mTagIsSpace = true;


        public String getmGlobalTag() {
            return mGlobalTag;
        }

        public final Config setmGlobalTag(String mGlobalTag) {
            this.mGlobalTag = mGlobalTag;
            return this;
        }

        public String getFilePrefix() {
            return mFilePrefix;
        }

        public final Config setFilePrefix(String mFilePrefix) {
            this.mFilePrefix = mFilePrefix;
            return this;
        }

        public String getFileExtension() {
            return mFileExtension;
        }

        public void setFileExtension(String mFileExtension) {
            this.mFileExtension = mFileExtension;
        }

        public boolean ismLogFileTotalSwitch() {
            return mLogFileTotalSwitch;
        }

        public final Config setLogFileTotalSwitch(boolean mLogFileTotalSwitch) {
            this.mLogFileTotalSwitch = mLogFileTotalSwitch;
            return this;
        }

        public final String getGlobalTag() {
            return mGlobalTag;
        }

        public boolean isLogConsoleSwitch() {
            return mLogConsoleSwitch;
        }

        public final Config setLogConsoleSwitch(boolean mLogConsoleSwitch) {
            this.mLogConsoleSwitch = mLogConsoleSwitch;
            return this;
        }

        public final Config setGlobalTag(final String tag) {
            mGlobalTag = tag;
            return this;
        }

        public final Config setLogSwitch(final boolean logSwitch) {
            mLogSwitch = logSwitch;
            return this;
        }

        public final boolean isLogSwitch() {
            return mLogSwitch;
        }

        public String getDir() {
            return mDir;
        }

        public final Config  setDir(String mDir) {
            this.mDir = mDir;
            return this;
        }
    }

}

