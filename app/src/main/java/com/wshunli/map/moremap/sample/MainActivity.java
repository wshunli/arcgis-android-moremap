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

import androidx.appcompat.app.AppCompatActivity;

import com.esri.arcgisruntime.geometry.GeometryEngine;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.layers.WebTiledLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.wshunli.map.moremap.MoreMapLayer;
import com.wshunli.map.moremap.layer.AMapLayer;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mMapView = findViewById(R.id.mapView);
        mMapView.setAttributionTextVisible(false);

        MoreMapLayer instance = MoreMapLayer.getInstance();
        WebTiledLayer vecLayer = instance.getLayer(new AMapLayer(), AMapLayer.Type.AMAP_VECTOR);
        WebTiledLayer trafficLayer = instance.getLayer(new AMapLayer(), AMapLayer.Type.AMAP_TRAFFIC);
        Basemap basemap = new Basemap(vecLayer);
        basemap.getBaseLayers().add(trafficLayer);
        mMapView.setMap(new ArcGISMap(basemap));

        Point point = (Point) GeometryEngine.project(new Point(113.943179, 22.54704), SpatialReference.create(4326));
        mMapView.setViewpointCenterAsync(point, 500000);
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
