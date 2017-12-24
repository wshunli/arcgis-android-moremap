# arcgis-android-moremap

[![Download](https://api.bintray.com/packages/wshunli/maven/arcgis-android-moremap/images/download.svg)](https://bintray.com/wshunli/maven/arcgis-android-moremap/_latestVersion)
[![Build Status](https://travis-ci.org/wshunli/arcgis-android-moremap.svg?branch=master)](https://travis-ci.org/wshunli/arcgis-android-moremap)
[![Author](https://img.shields.io/badge/Author-wshunli-0E7FBF.svg)](http://www.wshunli.com)
[![GitHub license](https://img.shields.io/github/license/wshunli/arcgis-android-moremap.svg)](https://github.com/wshunli/arcgis-android-moremap/blob/master/LICENSE)

基于 ArcGIS for Android 加载高德/百度/腾讯等切片底图

## Download

Install the needed dependencies and the ArcGIS Runtime SDK for Android (ArcGIS Android SDK)  binaries from Bintray Esri repostiory.

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

App module build.gradle file, within android block

```groovy
packagingOptions {
    exclude 'META-INF/LGPL2.1'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/NOTICE'
}
```

For more information : [Install and set up—ArcGIS Runtime SDK for Android](https://developers.arcgis.com/android/10-2/guide/install-and-set-up.htm)

Install arcgis-android-moremap library.

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'com.wshunli.map:arcgis-android-moremap:1.0.0'
}
```

Check out [arcgis-android-moremap releases](https://github.com/wshunli/arcgis-android-moremap/releases) to see more unstable versions.

## How do I use arcgis-android-moremap?

#### Permission

The library requires three permissions:

``` XML
<uses-feature android:glEsVersion="0x00020000" android:required="true" />

<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

So if you are targeting Android 6.0+, you need to handle runtime permission request before next step.

Note that OpenGL is included as a feature.

#### Simple usage snippet

``` Java
MapView mMapView = (MapView) findViewById(R.id.map);
MoreMapLayer vec_c = new MoreMapLayer(MoreMapLayerTypes.AMAP_VECTOR);
mMapView.addLayer(vec_c);
```

#### Cache tile layers

Just specify the cache path

``` Java
MapView mMapView = (MapView) findViewById(R.id.map);
String cachePath = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/MoreMapCache";
MoreMapLayer vec_c = new MoreMapLayer(MoreMapLayerTypes.AMAP_VECTOR, cachePath);
mMapView.addLayer(vec_c);
```

File will be cached to the specified path

#### More

Find more details about arcgis-android-moremap in [sample](https://github.com/wshunli/arcgis-android-moremap/tree/master/app).

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
