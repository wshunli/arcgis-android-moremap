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

import com.esri.arcgisruntime.arcgisservices.LevelOfDetail;
import com.esri.arcgisruntime.arcgisservices.TileInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * author : wshunli
 * email : wshunli@qq.com
 * date : 2020/5/19 23:33
 * description ： 支持的地图类型
 */
public enum MoreMapLayerType {

//    private static final String AMAP_VECTOR_NAME = "7";
//    private static final String AMAP_IMAGE_NAME = "6";
//    private static final String AMAP_ROAD_NAME = "8";
//
//    private static final String BAIDU_MAP_VECTOR_NAME = "pl";
//    private static final String BAIDU_MAP_ROAD_NAME = "sl";
//
//    private static final String TENCENT_MAP_VECTOR_NAME = "0";
//    private static final String TENCENT_MAP_VECTOR_NIGHT_NAME = "1";
//    private static final String TENCENT_MAP_ROAD_NAME = "3";
//    private static final String TENCENT_MAP_IMAGE_NAME = "sateTiles";
//    private static final String TENCENT_MAP_TERRAIN_NAME = "demTiles";
//
//    private static final String GOOGLE_MAP_VECTOR_NAME = "m";
//    private static final String GOOGLE_MAP_IMAGE_IMAGE = "s,h";
//    private static final String GOOGLE_MAP_TERRAIN_NAME = "t,r";


    // 百度矢量图层（含路网，含注记）
    BAIDU_MAP_VECTOR,
    // 百度影像图层（不含路网，不含注记）
    BAIDU_MAP_IMAGE,
    // 百度路网图层（含路网，含注记）
    BAIDU_MAP_ROAD,
    // 百度实时交通图层

    BAIDU_MAP_TRAFFIC,
    // 腾讯矢量图层（含路网，含注记）
    TENCENT_MAP_VECTOR,
    // 腾讯矢量图层（夜间，含路网，含注记）
    TENCENT_MAP_VECTOR_NIGHT,
    // 腾讯影像图层（不含路网，不含注记）
    TENCENT_MAP_IMAGE,
    // 腾讯地形图层（不含路网，不含注记）
    TENCENT_MAP_TERRAIN,
    // 腾讯路网图层（含路网，含注记）

    TENCENT_MAP_ROAD,
    // 谷歌矢量地图服务
    GOOGLE_MAP_VECTOR,
    // 谷歌影像地图服务
    GOOGLE_MAP_IMAGE,
    // 谷歌地形地图服务
    GOOGLE_MAP_TERRAIN;

    /**
     * 获取图层切片信息
     *
     * @return 切片信息
     */
    public static TileInfo getTileInfo() {

        return new TileInfo(
                MoreLayerConstants.TILE_DPI,
                MoreLayerConstants.TILE_FORMAT,
                getLevelOfDetails(),
                MoreLayerConstants.ORIGIN,
                MoreLayerConstants.SRID,
                MoreLayerConstants.TILE_HEIGHT,
                MoreLayerConstants.TILE_WIDTH
        );
    }

    private static List<LevelOfDetail> getLevelOfDetails() {
        List<LevelOfDetail> levelOfDetail = new ArrayList<>(MoreLayerConstants.LEVEL_MAX);
        for (int i = MoreLayerConstants.LEVEL_MIN; i < MoreLayerConstants.LEVEL_MAX; i++) {
            LevelOfDetail item = new LevelOfDetail(i, MoreLayerConstants.RESOLUTIONS[i - 1], MoreLayerConstants.SCALES[i - 1]);
            levelOfDetail.add(item);
        }
        return levelOfDetail;
    }

}
