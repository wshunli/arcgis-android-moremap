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
package com.wshunli.map.moremap.sample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.esri.arcgisruntime.geometry.GeometryEngine;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.layers.WebTiledLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.impl.BottomListPopupView;
import com.lxj.xpopup.impl.CenterListPopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.wshunli.map.moremap.MoreMapLayer;
import com.wshunli.map.moremap.core.IMapLayer;
import com.wshunli.map.moremap.core.IMapType;
import com.wshunli.map.moremap.layer.AMapLayer;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MapView mMapView;

    private IMapLayer iMapLayer = new AMapLayer();
    private IMapType iMapType = AMapLayer.Type.AMAP_VECTOR;;

    private BottomListPopupView selectPopupView = null;
    private CenterListPopupView layerPopupView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mMapView = findViewById(R.id.mapView);
        mMapView.setAttributionTextVisible(false);

        updateMap();

    }

    // 添加底图
    private void updateMap() {
        Log.d(TAG, "updateMap: ");
        if (iMapLayer == null || iMapType == null) {
            return;
        }
        MoreMapLayer instance = MoreMapLayer.getInstance();
        WebTiledLayer webTiledLayer = instance.getLayer(iMapLayer, iMapType);
        webTiledLayer.loadAsync();
        Basemap basemap = new Basemap(webTiledLayer);
        if (mMapView.getMap() == null) {
            mMapView.setMap(new ArcGISMap(basemap));
        } else {
            mMapView.getMap().setBasemap(basemap);
        }

        Point point = (Point) GeometryEngine.project(new Point(113.943179, 22.54704), SpatialReference.create(4326));
        mMapView.setViewpointCenterAsync(point, 500000);

    }

    // 选择操作
    public void showPopMenu(View view) {

        if (selectPopupView == null) {
            selectPopupView = new XPopup.Builder(this)
                    .asBottomList("请选择操作",
                            new String[]{"选择高德图层（矢量、影像、路网、交通）", "选择百度图层", "选择腾讯图层"},
                            new OnSelectListener() {
                                @Override
                                public void onSelect(int position, String text) {
                                    Log.d(TAG, "onSelect: " + text);
                                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                    switch (position) {
                                        case 0:
                                            showAMapLayerPopMenu();
                                            break;
                                        case 1:
                                            updateMap();
                                            break;
                                        case 2:
                                            updateMap();
                                            break;
                                        default:
                                            Log.w(TAG, "onSelect: " + text + "not support");
                                    }
                                }
                            });
        }

        selectPopupView.show();
    }

    // 选择图层
    private void showAMapLayerPopMenu() {
        if (layerPopupView == null) {
            layerPopupView = new XPopup.Builder(this)
                    .asCenterList("请选择图层",
                            new String[]{"高德矢量图层", "高德影像图层", "高德路网图层", "高德实时交通图层"},
                            new OnSelectListener() {
                                @Override
                                public void onSelect(int position, String text) {
                                    Log.d(TAG, "onSelect: " + text);
                                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                    iMapLayer = new AMapLayer();
                                    switch (position) {
                                        case 0:
                                            iMapType = AMapLayer.Type.AMAP_VECTOR;
                                            break;
                                        case 1:
                                            iMapType = AMapLayer.Type.AMAP_IMAGE;
                                            break;
                                        case 2:
                                            iMapType = AMapLayer.Type.AMAP_ROAD;
                                            break;
                                        case 3:
                                            iMapType = AMapLayer.Type.AMAP_TRAFFIC;
                                            break;
                                        default:
                                            Log.w(TAG, "onSelect: " + text + "not support");
                                    }
                                    updateMap();
                                }
                            });
        }
        layerPopupView.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.pause();
    }

    @Override
    protected void onDestroy() {
        mMapView.dispose();
        super.onDestroy();
    }
}
