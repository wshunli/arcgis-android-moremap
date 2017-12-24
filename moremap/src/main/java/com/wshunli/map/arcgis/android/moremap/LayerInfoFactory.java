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
package com.wshunli.map.arcgis.android.moremap;

import com.esri.core.geometry.Point;

import java.util.Calendar;
import java.util.TimeZone;

public class LayerInfoFactory {

    private static final String TAG = "LayerInfoFactory";

    private static final String AMAP_VECTOR_NAME = "7";
    private static final String AMAP_IMAGE_NAME = "6";
    private static final String AMAP_ROAD_NAME = "8";

    private static final String BAIDU_MAP_VECTOR_NAME = "pl";
    private static final String BAIDU_MAP_ROAD_NAME = "sl";

    private static final String TENCENT_MAP_VECTOR_NAME = "0";
    private static final String TENCENT_MAP_VECTOR_NIGHT_NAME = "1";
    private static final String TENCENT_MAP_ROAD_NAME = "3";
    private static final String TENCENT_MAP_IMAGE_NAME = "sateTiles";
    private static final String TENCENT_MAP_TERRAIN_NAME = "demTiles";

    private static final String GOOGLE_MAP_VECTOR_NAME = "m";
    private static final String GOOGLE_MAP_IMAGE_IMAGE = "s,h";
    private static final String GOOGLE_MAP_TERRAIN_NAME = "t,r";

    private static final Point ORIGIN = new Point(-20037508.342787, 20037508.342787);

    private static final int SRID = 102113;

    private static final double X_MIN = -22041257.773878;
    private static final double Y_MIN = -32673939.6727517;
    private static final double X_MAX = 22041257.773878;
    private static final double Y_MAX = 20851350.0432886;


    private static final double[] SCALES = {591657527.591555,
            295828763.79577702, 147914381.89788899, 73957190.948944002,
            36978595.474472001, 18489297.737236001, 9244648.8686180003,
            4622324.4343090001, 2311162.217155, 1155581.108577, 577790.554289,
            288895.277144, 144447.638572, 72223.819286, 36111.909643,
            18055.954822, 9027.9774109999998, 4513.9887049999998, 2256.994353,
            1128.4971760000001};
    private static final double[] RESOLUTIONS = {156543.03392800014,
            78271.516963999937, 39135.758482000092, 19567.879240999919,
            9783.9396204999593, 4891.9698102499797, 2445.9849051249898,
            1222.9924525624949, 611.49622628138, 305.748113140558,
            152.874056570411, 76.4370282850732, 38.2185141425366,
            19.1092570712683, 9.55462853563415, 4.7773142679493699,
            2.3886571339746849, 1.1943285668550503, 0.59716428355981721,
            0.29858214164761665};

    public static MoreMapLayerInfo getLayerInfo(int layerType) {
        MoreMapLayerInfo layerInfo = new MoreMapLayerInfo();
        layerInfo.setLayerType(layerType);
        handleLayerInfo(layerInfo);
        switch (layerType) {
            case MoreMapLayerTypes.AMAP_VECTOR:
                layerInfo.setLayerName(LayerInfoFactory.AMAP_VECTOR_NAME);
                layerInfo.setCachePathName("AMAP_VECTOR");
                break;
            case MoreMapLayerTypes.AMAP_IMAGE:
                layerInfo.setLayerName(LayerInfoFactory.AMAP_IMAGE_NAME);
                layerInfo.setCachePathName("AMAP_IMAGE");
                break;
            case MoreMapLayerTypes.AMAP_ROAD:
                layerInfo.setLayerName(LayerInfoFactory.AMAP_ROAD_NAME);
                layerInfo.setCachePathName("AMAP_ROAD");
                break;
            case MoreMapLayerTypes.AMAP_TRAFFIC:
                layerInfo.setCachePathName("AMAP_TRAFFIC");
                break;
            case MoreMapLayerTypes.BAIDU_MAP_VECTOR:
                layerInfo.setLayerName(LayerInfoFactory.BAIDU_MAP_VECTOR_NAME);
                layerInfo.setCachePathName("BAIDU_MAP_VECTOR");
                layerInfo.setMinZoomLevel(3);
                layerInfo.setMaxZoomLevel(19);
                break;
            case MoreMapLayerTypes.BAIDU_MAP_IMAGE:
                layerInfo.setCachePathName("BAIDU_MAP_IMAGE");
                layerInfo.setMinZoomLevel(3);
                layerInfo.setMaxZoomLevel(19);
                break;
            case MoreMapLayerTypes.BAIDU_MAP_ROAD:
                layerInfo.setLayerName(LayerInfoFactory.BAIDU_MAP_ROAD_NAME);
                layerInfo.setCachePathName("BAIDU_MAP_ROAD");
                layerInfo.setMinZoomLevel(3);
                layerInfo.setMaxZoomLevel(19);
                break;
            case MoreMapLayerTypes.BAIDU_MAP_TRAFFIC:
                layerInfo.setCachePathName("BAIDU_MAP_TRAFFIC");
                layerInfo.setMinZoomLevel(3);
                layerInfo.setMaxZoomLevel(19);
                break;
            case MoreMapLayerTypes.TENCENT_MAP_VECTOR:
                layerInfo.setLayerName(LayerInfoFactory.TENCENT_MAP_VECTOR_NAME);
                layerInfo.setCachePathName("TENCENT_MAP_VECTOR");
                break;
            case MoreMapLayerTypes.TENCENT_MAP_VECTOR_NIGHT:
                layerInfo.setLayerName(LayerInfoFactory.TENCENT_MAP_VECTOR_NIGHT_NAME);
                layerInfo.setCachePathName("TENCENT_MAP_VECTOR_NIGHT");
                break;
            case MoreMapLayerTypes.TENCENT_MAP_IMAGE:
                layerInfo.setLayerName(LayerInfoFactory.TENCENT_MAP_IMAGE_NAME);
                layerInfo.setCachePathName("TENCENT_MAP_IMAGE");
                break;
            case MoreMapLayerTypes.TENCENT_MAP_TERRAIN:
                layerInfo.setLayerName(LayerInfoFactory.TENCENT_MAP_TERRAIN_NAME);
                layerInfo.setCachePathName("TENCENT_MAP_TERRAIN");
                break;
            case MoreMapLayerTypes.TENCENT_MAP_ROAD:
                layerInfo.setLayerName(LayerInfoFactory.TENCENT_MAP_ROAD_NAME);
                layerInfo.setCachePathName("TENCENT_MAP_ROAD");
                break;
            case MoreMapLayerTypes.GOOGLE_MAP_VECTOR:
                layerInfo.setLayerName(LayerInfoFactory.GOOGLE_MAP_VECTOR_NAME);
                layerInfo.setCachePathName("GOOGLE_MAP_VECTOR");
                layerInfo.setMaxZoomLevel(21);
                break;
            case MoreMapLayerTypes.GOOGLE_MAP_IMAGE:
                layerInfo.setLayerName(LayerInfoFactory.GOOGLE_MAP_IMAGE_IMAGE);
                layerInfo.setCachePathName("GOOGLE_MAP_IMAGE");
                layerInfo.setMaxZoomLevel(21);
                break;
            case MoreMapLayerTypes.GOOGLE_MAP_TERRAIN:
                layerInfo.setLayerName(LayerInfoFactory.GOOGLE_MAP_TERRAIN_NAME);
                layerInfo.setCachePathName("GOOGLE_MAP_TERRAIN");
                layerInfo.setMaxZoomLevel(21);
                break;
        }
        return layerInfo;
    }

    public static String getLayerUrl(MoreMapLayerInfo layerInfo, int level, int col, int row) {
        String layerUrl = null;
        switch (layerInfo.getLayerType()) {
            // http://webst01.is.autonavi.com/appmaptile?style=6&x=13417&y=6499&z=14
            case MoreMapLayerTypes.AMAP_VECTOR:
            case MoreMapLayerTypes.AMAP_IMAGE:
            case MoreMapLayerTypes.AMAP_ROAD:
                layerUrl = "http://webst0" + ((col + row) % 4 + 1) + ".is.autonavi.com/appmaptile?style="
                        + layerInfo.getLayerName()
                        + "&x=" + col + "&y=" + row + "&z=" + level;
                break;
            // http://history.traffic.amap.com/traffic?type=2&day=7&hh=13&mm=27&x=13417&y=6499&z=14
            case MoreMapLayerTypes.AMAP_TRAFFIC:
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                int hh = calendar.get(Calendar.HOUR_OF_DAY);
                int mm = calendar.get(Calendar.MINUTE);
                layerUrl = "http://history.traffic.amap.com/traffic?type=2"
                        + "&day=" + day + "&hh=" + hh + "&mm=" + mm
                        + "&x=" + col + "&y=" + row + "&z=" + level;
                break;
            // http://online0.map.bdimg.com/tile/?qt=tile&x=6178&y=2010&z=15&styles=pl
            // http://online2.map.bdimg.com/tile/?qt=tile&x=49372&y=16074&z=18&styles=sl
            case MoreMapLayerTypes.BAIDU_MAP_VECTOR:
            case MoreMapLayerTypes.BAIDU_MAP_ROAD:
                int offsetV = (int) (Math.pow(2, level - 1));
                layerUrl = "http://online" + ((col + row) % 8 + 1) + ".map.bdimg.com/onlinelabel/?qt=tile"
                        + "&x=" + (col - offsetV) + "&y=" + (offsetV - row - 1) + "&z=" + level
                        + "&styles=" + layerInfo.getLayerName();
                break;
            // http://shangetu1.map.bdimg.com/it/u=x=1543;y=502;z=13;v=009;type=sate&fm=46
            case MoreMapLayerTypes.BAIDU_MAP_IMAGE:
                int offsetI = (int) (Math.pow(2, level - 1));
                layerUrl = "http://shangetu" + ((col + row) % 8 + 1) + ".map.bdimg.com/it/u="
                        + "x=" + (col - offsetI) + ";y=" + (offsetI - row - 1) + ";z=" + level
                        + ";v=009;type=sate&fm=46";
                break;
            // http://its.map.baidu.com:8002/traffic/TrafficTileService?level=13&x=1542&y=500&time=1488447740075
            case MoreMapLayerTypes.BAIDU_MAP_TRAFFIC:
                int offsetT = (int) (Math.pow(2, level - 1));
                layerUrl = "http://its.map.baidu.com:8002/traffic/TrafficTileService?"
                        + "level=" + level + "&x=" + (col - offsetT) + "&y=" + (offsetT - row - 1)
                        + "&time=" + System.currentTimeMillis();
                break;
            // http://rt2.map.gtimg.com/tile?z=11&x=1671&y=1207&type=vector&styleid=0
            // http://rt2.map.gtimg.com/tile?z=11&x=1671&y=1207&type=vector&styleid=1
            // http://rt2.map.gtimg.com/tile?z=11&x=1671&y=1207&type=vector&styleid=3

            case MoreMapLayerTypes.TENCENT_MAP_VECTOR:
            case MoreMapLayerTypes.TENCENT_MAP_VECTOR_NIGHT:
            case MoreMapLayerTypes.TENCENT_MAP_ROAD:
                row = (int) Math.pow(2, level) - 1 - row;

                layerUrl = "http://rt" + (col % 4) + ".map.gtimg.com/tile?"
                        + "z=" + level + "&x=" + col + "&y=" + row
                        + "&type=vector&styleid=" + layerInfo.getLayerName();
                break;

            // http://p0.map.gtimg.com/demTiles/11/104/75/1671_1207.jpg
            // http://p1.map.gtimg.com/sateTiles/11/104/75/1671_1206.jpg
            case MoreMapLayerTypes.TENCENT_MAP_IMAGE:
            case MoreMapLayerTypes.TENCENT_MAP_TERRAIN:
                row = (int) Math.pow(2, level) - 1 - row;
                layerUrl = "http://p" + (col % 4) + ".map.gtimg.com/"
                        + layerInfo.getLayerName()
                        + "/" + level + "/" + (int) Math.floor(col / 16) + "/" + (int) Math.floor(row / 16)
                        + "/" + col + "_" + row + ".jpg";
                break;

            // http://mt2.google.cn/vt/lyrs=m&hl=zh-CN&gl=cn&x=420&y=193&z=9
            case MoreMapLayerTypes.GOOGLE_MAP_VECTOR:
            case MoreMapLayerTypes.GOOGLE_MAP_IMAGE:
            case MoreMapLayerTypes.GOOGLE_MAP_TERRAIN:
                row = (int) Math.pow(2, level) - 1 - row;
                layerUrl = "http://mt" + (col % 4) + ".google.cn/vt/lyrs="
                        + layerInfo.getLayerName() + "&hl=zh-CN&gl=cn&"
                        + "x=" + col + "&" + "y=" + row + "&" + "z=" + level;
                break;

        }
        return layerUrl;
    }

    private static void handleLayerInfo(MoreMapLayerInfo layerInfo) {


        layerInfo.setOrigin(LayerInfoFactory.ORIGIN);
        layerInfo.setSrid(LayerInfoFactory.SRID);
        layerInfo.setxMin(LayerInfoFactory.X_MIN);
        layerInfo.setyMin(LayerInfoFactory.Y_MIN);
        layerInfo.setxMax(LayerInfoFactory.X_MAX);
        layerInfo.setyMax(LayerInfoFactory.Y_MAX);
        layerInfo.setScales(LayerInfoFactory.SCALES);
        layerInfo.setResolutions(LayerInfoFactory.RESOLUTIONS);

    }


}
