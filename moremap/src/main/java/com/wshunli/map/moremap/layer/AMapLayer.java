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
package com.wshunli.map.moremap.layer;

import com.esri.arcgisruntime.io.RequestConfiguration;
import com.esri.arcgisruntime.layers.WebTiledLayer;
import com.wshunli.map.moremap.core.IMapLayer;
import com.wshunli.map.moremap.core.IMapType;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * author : wshunli
 * email : wshunli@qq.com
 * date : 2020/5/20 09:01
 * description ： 高德地图图层
 */
public class AMapLayer implements IMapLayer {

    private static final List<String> SUB_DOMAIN = Arrays.asList("webst01", "webst02", "webst03", "webst04");

    @Override
    public WebTiledLayer getLayer(IMapType layerType) {
        if (layerType instanceof AMapLayer.Type) {
            AMapLayer.Type type = (AMapLayer.Type) layerType;
            String templateUri = type.getTemplateUri();
            WebTiledLayer webTiledLayer = new WebTiledLayer(templateUri, SUB_DOMAIN);
            webTiledLayer.setName(type.name());
            // 配置请求头
            RequestConfiguration requestConfiguration = new RequestConfiguration();
            requestConfiguration.getHeaders().put("referer", "https://lbs.amap.com/");
            webTiledLayer.setRequestConfiguration(requestConfiguration);
            return webTiledLayer;
        }
        return null;
    }

    public enum Type implements IMapType {

        // 高德矢量图层（含路网，含注记）
        AMAP_VECTOR {
            @Override
            String getTemplateUri() {
                // https://webst01.is.autonavi.com/appmaptile?style=6&x=13417&y=6499&z=14
                // https://webst01.is.autonavi.com/appmaptile?style=7&x=13417&y=6499&z=14&size=1&lang=zh_cn&scl=2&ltype=11
                return "https://{subDomain}.is.autonavi.com/appmaptile?style=7&x={col}&y={row}&z={level}&lang=zh_cn&scl=2&ltype=11";
            }
        },
        // 高德影像图层（不含路网，不含注记）
        AMAP_IMAGE {
            @Override
            String getTemplateUri() {
                return "https://{subDomain}.is.autonavi.com/appmaptile?style=6&x={col}&y={row}&z={level}&lang=zh_cn&scl=2&ltype=11";
            }
        },
        // 高德路网图层（含路网，含注记）
        AMAP_ROAD {
            @Override
            String getTemplateUri() {
                return "https://{subDomain}.is.autonavi.com/appmaptile?style=8&x={col}&y={row}&z={level}&lang=zh_cn&scl=2&ltype=11";
            }
        },
        // 高德实时交通图层
        AMAP_TRAFFIC {
            @Override
            String getTemplateUri() {
                // http://history.traffic.amap.com/traffic?type=2&day=7&hh=13&mm=27&x=13417&y=6499&z=14
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                int hh = calendar.get(Calendar.HOUR_OF_DAY);
                int mm = calendar.get(Calendar.MINUTE);
                return "http://history.traffic.amap.com/traffic?type=2"
                        + "&day=" + day + "&hh=" + hh + "&mm=" + mm
                        + "&x={col}&y={row}&z={level}";
            }
        };

        // 获取图层标识
        abstract String getTemplateUri();
    }

}
