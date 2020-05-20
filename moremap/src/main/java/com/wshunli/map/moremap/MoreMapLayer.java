/*
 * Copyright 2017 wshunli
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
package com.wshunli.map.moremap;

import android.content.Context;
import android.util.Log;

import com.esri.arcgisruntime.layers.WebTiledLayer;
import com.wshunli.map.moremap.core.IMapLayer;
import com.wshunli.map.moremap.core.IMapType;

public class MoreMapLayer {

    private static final String TAG = "MoreMapLayer";

    private Context context = null;
    private String cachePath = null;

    private MoreMapLayer() {
    }

    private volatile static MoreMapLayer instance = null;

    public static MoreMapLayer getInstance() {
        if (instance == null) {
            synchronized (MoreMapLayer.class) {
                if (instance == null) {
                    instance = new MoreMapLayer();
                }
            }
        }
        return instance;
    }

    // 初始化
    public void init(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        this.init(context, getDefaultCachePath(context));
    }

    // 初始化
    public void init(Context context, String cachePath) {
        if (context == null) {
            Log.e(TAG, "context is null, please check it");
            throw new NullPointerException();
        }
        if (cachePath == null || cachePath.isEmpty()) {
            Log.w(TAG, "cachePath is null or empty , set default value");
            cachePath = getDefaultCachePath(context);
        }
        this.context = context;
        this.cachePath = cachePath;
        Log.i(TAG, "init cachePath: " + cachePath);
    }

    /**
     * 获取 WebTiledLayer 图层
     *
     * @param iMapLayer 图层实例
     * @param iMapType  图层类型
     * @return ArcGIS Android 对应图层
     */
    public WebTiledLayer getLayer(IMapLayer iMapLayer, IMapType iMapType) {
        return iMapLayer.getLayer(iMapType);
    }

    private Context getContext() {
        return context;
    }

    private String getCachePath() {
        return cachePath;
    }

    private String getDefaultCachePath(Context context) {
        return context.getCacheDir().getAbsolutePath() + "/tdt";
    }

}
