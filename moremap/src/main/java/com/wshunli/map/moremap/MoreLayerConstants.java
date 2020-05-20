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

import com.esri.arcgisruntime.arcgisservices.TileInfo;
import com.esri.arcgisruntime.geometry.Envelope;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;

import java.util.Arrays;
import java.util.List;

/**
 * author : wshunli
 * email : wshunli@qq.com
 * date : 2020/5/17 18:22
 * description ： 图层相关常量
 */
class MoreLayerConstants {

    // 子域名
    static final List<String> SUB_DOMAIN = Arrays.asList("webst01", "webst02", "webst03", "webst04");

    // 切片相关信息
    static final int TILE_DPI = 96;
    static final TileInfo.ImageFormat TILE_FORMAT = TileInfo.ImageFormat.PNG24;
    static final int TILE_WIDTH = 256, TILE_HEIGHT = 256;

    // 坐标系
    static final SpatialReference SRID = SpatialReference.create(102113);
    static final Point ORIGIN = new Point(-20037508.342787, 20037508.342787, SRID);

    private static final double X_MIN = -20037508.342789244;
    private static final double Y_MIN = -20037508.342789244;
    private static final double X_MAX = 20037508.342789244;
    private static final double Y_MAX = 20037508.342789244;
    static final Envelope ENVELOPE = new Envelope(X_MIN, Y_MIN, X_MAX, Y_MAX, SRID);

    // 缩放等级边界值
    static final int LEVEL_MIN = 1, LEVEL_MAX = 18;
    static final double[] SCALES = {
            591657527.591555, 295828763.795777, 147914381.897889,
            73957190.948944, 36978595.474472, 18489297.737236,
            9244648.868618, 4622324.434309, 2311162.217155,
            1155581.108577, 577790.554289, 288895.277144,
            144447.638572, 72223.819286, 36111.909643,
            18055.954822, 9027.977411, 4513.98870,
            2256.994353, 1128.497176, 564.248588};

    static final double[] RESOLUTIONS = {
            156543.03392800014, 78271.516963999937, 39135.758482000092,
            19567.879240999919, 9783.9396204999593, 4891.9698102499797,
            2445.9849051249898, 1222.9924525624949, 611.49622628138,
            305.748113140558, 152.874056570411, 76.4370282850732,
            38.2185141425366, 19.1092570712683, 9.55462853563415,
            4.7773142679493699, 2.3886571339746849, 1.1943285668550503};

}
