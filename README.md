# arcgis-android-moremap

[![Download](https://api.bintray.com/packages/wshunli/maven/arcgis-android-moremap/images/download.svg)](https://bintray.com/wshunli/maven/arcgis-android-moremap/_latestVersion)
[![Build Status](https://travis-ci.org/wshunli/arcgis-android-moremap.svg?branch=master)](https://travis-ci.org/wshunli/arcgis-android-moremap)
[![Author](https://img.shields.io/badge/Author-wshunli-0E7FBF.svg)](http://www.wshunli.com)
[![GitHub license](https://img.shields.io/github/license/wshunli/arcgis-android-moremap.svg)](https://github.com/wshunli/arcgis-android-moremap/blob/master/LICENSE)

基于 ArcGIS for Android 加载高德/百度/腾讯等切片底图

## 准备

使用之前需添加 ArcGIS for Android 依赖：

```groovy
repositories {
    jcenter()
    // Add the Esri public Bintray Maven repository
    maven {
        url 'https://esri.bintray.com/arcgis'
    }
}
dependencies {
    // Add ArcGIS Runtime SDK for Android dependency
    compile 'com.esri.arcgis.android:arcgis-android:10.2.9'
}
```

排除重复依赖：

```groovy
packagingOptions {
    exclude 'META-INF/LGPL2.1'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/NOTICE'
}
```

声明权限：

``` XML
<uses-feature android:glEsVersion="0x00020000" android:required="true" />

<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

更多信息可查看官方文档 : [Install and set up—ArcGIS Runtime SDK for Android](https://developers.arcgis.com/android/10-2/guide/install-and-set-up.htm)

## 使用

添加 arcgis-android-moremap 依赖：

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.wshunli.map:arcgis-android-moremap:1.0.1'
}
```

更多版本查看 [arcgis-android-moremap releases](https://github.com/wshunli/arcgis-android-moremap/releases)

## 示例

``` Java
MapView mMapView = (MapView) findViewById(R.id.map);
mMapView.addLayer(new MoreMapLayer(MoreMapLayerTypes.AMAP_VECTOR));
```

### 缓存切片图层

指定缓存路径即可缓存切片：

``` Java
MapView mMapView = (MapView) findViewById(R.id.map);
String cachePath = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/MoreMapCache";
MoreMapLayer vec_c = new MoreMapLayer(MoreMapLayerTypes.AMAP_VECTOR, cachePath);
mMapView.addLayer(vec_c);
```

### 支持图层

高德地图

- AMAP_VECTOR、高德矢量图层（含路网，含注记）
- AMAP_IMAGE、高德影像图层（不含路网，不含注记）
- AMAP_ROAD、高德路网图层（含路网，含注记）
- AMAP_TRAFFIC、高德实时交通图层

百度地图

- BAIDU_MAP_VECTOR、百度矢量图层（含路网，含注记）
- BAIDU_MAP_IMAGE、百度影像图层（不含路网，不含注记）
- BAIDU_MAP_ROAD、百度路网图层（含路网，含注记）
- BAIDU_MAP_TRAFFIC、百度实时交通图层

腾讯地图

- TENCENT_MAP_VECTOR、腾讯矢量图层（含路网，含注记）
- TENCENT_MAP_VECTOR_NIGHT、腾讯矢量图层（夜间，含路网，含注记）
- TENCENT_MAP_IMAGE、腾讯影像图层（不含路网，不含注记）
- TENCENT_MAP_TERRAIN、腾讯地形图层（不含路网，不含注记）
- TENCENT_MAP_ROAD 、腾讯路网图层（含路网，含注记）

谷歌地图

- GOOGLE_MAP_VECTOR、谷歌矢量地图服务
- GOOGLE_MAP_IMAGE、谷歌影像地图服务
- GOOGLE_MAP_TERRAIN、谷歌地形地图服务

### 更多

更多信息查看示例代码 [sample](https://github.com/wshunli/arcgis-android-moremap/tree/master/app)

## License

    Copyright 2017 wshunli

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
