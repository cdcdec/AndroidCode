package com.cdc.androidcode.log

import android.util.Log
import com.cdc.androidcode.BuildConfig
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

object LogUtil {
    private var LOG = BuildConfig.DEBUG
    private val LOGV = true
    private val LOGD = true
    private val LOGI = true
    private val LOGW = true
    private val LOGE = true
    private val tag: String
        get() {
            val trace = Throwable().fillInStackTrace().stackTrace
            var callingClass = ""
            for (i in 2 until trace.size) {
                val clazz = trace[i].javaClass
                if (clazz != LogUtil::class.java) {
                    callingClass = trace[i].className
                    callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1)

                    break
                }
            }
            return callingClass
        }

    fun setLogEnable(enable: Boolean) {
        LOG = enable
    }

    fun v(mess: String) {
        if (LOG && LOGV) {
            Log.v(tag, buildMessage(mess, tag))
        }
    }

    fun d(mess: String) {
        if (LOG && LOGD) {
            Log.d(tag, buildMessage(mess, tag))
        }
    }

    fun i(mess: String) {
        if (LOG && LOGI) {
            Log.i(tag, buildMessage(mess, tag))
        }
    }

    fun w(mess: String) {
        if (LOG && LOGW) {
            Log.w(tag, buildMessage(mess, tag))
        }
    }

    fun e(mess: String) {
        if (LOG && LOGE) {
            log(tag, buildMessage(mess, tag))
        }
    }

    fun g(msg: String) {
        if (LOG) {
            log("code", buildMessage(msg, tag))
        }
    }

    fun l(tag: String, msg: String) {
        if (msg.length > 4000) {
            var i = 0
            while (i < msg.length) {
                if (i + 4000 < msg.length)
                    Log.e(tag, msg.substring(i, i + 4000))
                else
                    Log.e(tag, msg.substring(i, msg.length))
                i += 4000
            }
        } else
            Log.e(tag, msg + ":" + LogUtil.tag)
    }

    fun log(tag: String, msg: String) {
        if (msg.length > 4000) {
            var i = 0
            while (i < msg.length) {
                if (i + 4000 < msg.length)
                    Log.e(tag, msg.substring(i, i + 4000))
                else
                    Log.e(tag, msg.substring(i, msg.length))
                i += 4000
            }
        } else
            Log.e(tag, msg + ":" + LogUtil.tag)
    }

    private fun buildMessage(msg: String, tag: String): String {
        val trace = Throwable().fillInStackTrace()
            .stackTrace
        var caller = ""
        var lineNum = 0
        for (i in 2 until trace.size) {
            val clazz = trace[i].javaClass
            if (clazz != LogUtil::class.java) {
                caller = trace[i].methodName
                lineNum = trace[i].lineNumber
                break
            }
        }
        var backStr = String.format(
            Locale.US, "%s_[%d]_%s_%s行_%s", tag, Thread.currentThread()
                .id, caller, lineNum.toString(), msg
        )
        if (BuildConfig.DEBUG) {
            writeLogtoFile(backStr)
        }
        return backStr
    }


    //===保存日志相关======
    var MYLOG_WRITE_TO_FILE: Boolean? = true// 日志写入文件
    private const val MYLOG_PATH_SDCARD_DIR = "AndroidCode"// 日志文件在sdcard中的路径
    private const val SDCARD_LOG_FILE_SAVE_DAYS = 0// sd卡中日志文件的最多保存天数
    private const val MYLOGFILEName = "code.txt"// 本类输出的日志文件名称
    private val myLogSdf = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss"
    )// 日志的输出格式
    private val logfile = SimpleDateFormat("yyyy-MM-dd")// 日志文件格式

    private// 获取扩展SD卡设备状态
    // 拥有可读可写权限
    // 获取扩展存储设备的文件目录
    val logPath: String
        get() {
            var path = ""
            val sDStateString = android.os.Environment.getExternalStorageState()
            if (sDStateString == android.os.Environment.MEDIA_MOUNTED) {
                val SDFile = android.os.Environment.getExternalStorageDirectory()
                path = (SDFile.absolutePath + File.separator
                        + MYLOG_PATH_SDCARD_DIR)
            }
            return path

        }

    /**
     * 得到现在时间前的几天日期，用来得到需要删除的日志文件
     */
    private val dateBefore: Date
        get() {
            val nowtime = Date()
            val now = Calendar.getInstance()
            now.time = nowtime
            now.set(Calendar.DATE, now.get(Calendar.DATE) - SDCARD_LOG_FILE_SAVE_DAYS)
            return now.time
        }

    /**
     * 打开日志文件并写入日志
     *
     * @return
     */
    private fun writeLogtoFile(text: String) {// 新建或打开日志文件
        val nowtime = Date()
        val needWriteFiel = logfile.format(nowtime)
        val needWriteMessage = (myLogSdf.format(nowtime) + " "
                + text)

        // 取得日志存放目录
        val path = logPath
        if ("" != path) try {
            // 创建目录
            val dir = File(path)
            if (!dir.exists())
                dir.mkdir()
            // 打开文件
            val file = File(
                path + File.separator + needWriteFiel
                        + MYLOGFILEName
            )
            val filerWriter = FileWriter(file, true)// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
            val bufWriter = BufferedWriter(filerWriter)
            bufWriter.write(needWriteMessage)
            bufWriter.newLine()
            bufWriter.close()
            filerWriter.close()
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
    }

    /**
     * 删除制定的日志文
     */
    fun delFile() {// 删除日志文件
        // 取得日志存放目录
        val path = logPath
        if (path != null && "" != path) {
            val needDelFiel = logfile.format(dateBefore)
            val file = File(path, needDelFiel + MYLOGFILEName)
            if (file.exists()) {
                file.delete()
            }
        }
    }
    //===保存日志相关======
}