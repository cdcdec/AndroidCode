/*
 * Copyright (C) 2017 Haoge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lzh.framework.updatepluginlib.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import org.lzh.framework.updatepluginlib.base.InstallStrategy;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.util.UpdateInstallProvider;

import java.io.File;

/**
 * 默认的安装策略实现类. 适配Android 7.0安装方案。
 *
 * @author haoge
 */
public class DefaultInstallStrategy extends InstallStrategy {

    private static String DEFAULT_AUTHOR = null;

    @Override
    public void install(Context context, String filename, final Update update) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        File apkFile = new File(filename);
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            // Adaptive with api version 24+
            uri = UpdateInstallProvider.getUriByFile(apkFile, getAuthor(context));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(apkFile);
        }
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(intent);

    }

    private String getAuthor(Context context) {
        if (TextUtils.isEmpty(DEFAULT_AUTHOR)) {
            DEFAULT_AUTHOR = "update.plugin." + context.getPackageName() + ".UpdateInstallProvider";
        }
        return DEFAULT_AUTHOR;
    }
}
