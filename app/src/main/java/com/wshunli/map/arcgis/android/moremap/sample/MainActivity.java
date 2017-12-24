package com.wshunli.map.arcgis.android.moremap.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.android.map.MapView;
import com.wshunli.map.arcgis.android.moremap.MoreMapLayer;
import com.wshunli.map.arcgis.android.moremap.MoreMapLayerTypes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = findViewById(R.id.map);
        mapView.addLayer(new MoreMapLayer(MoreMapLayerTypes.AMAP_VECTOR));
//        mapView.addLayer(new ChinaMapLayer(ChinaMapLayerTypes.TENCENT_MAP_ROAD));
    }
}
