package com.example.ln_404.demowikiar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wikitude.architect.ArchitectView;

import java.io.File;

public class ARActivity extends AppCompatActivity {

    public static final String EXTRAS_KEY_ACTIVITY_TITLE_STRING = "activityTitle";
    public static final String EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL = "activityArchitectWorldUrl";

    public static final String EXTRAS_KEY_ACTIVITY_IR = "activityIr";
    public static final String EXTRAS_KEY_ACTIVITY_GEO = "activityGeo";
    public static final String EXTRAS_KEY_ACTIVITY_INSTANT = "activityInstant";

    public static final String EXTRAS_KEY_ACTIVITIES_ARCHITECT_WORLD_URLS_ARRAY = "activitiesArchitectWorldUrls";
    public static final String EXTRAS_KEY_ACTIVITIES_TILES_ARRAY = "activitiesTitles";
    public static final String EXTRAS_KEY_ACTIVITIES_CLASSNAMES_ARRAY = "activitiesClassnames";

    public static final String EXTRAS_KEY_ACTIVITIES_IR_ARRAY = "activitiesIr";
    public static final String EXTRAS_KEY_ACTIVITIES_GEO_ARRAY = "activitiesGeo";
    public static final String EXTRAS_KEY_ACTIVITIES_INSTANT_ARRAY = "activitiesInstant";

    private ArchitectView architectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        loadExample();
    }

    private void loadExample() {
        try {
            final Intent intent = new Intent(this, AutoHdSampleCamActivity.class);
            intent.putExtra(EXTRAS_KEY_ACTIVITY_TITLE_STRING,
                    "AR");
                intent.putExtra(EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL, "file:///android_asset/ar/03_Multiple$Targets_1_Multiple$Targets/index.html");


            /*intent.putExtra(EXTRAS_KEY_ACTIVITY_IR,
                    "2020");
            intent.putExtra(EXTRAS_KEY_ACTIVITY_GEO,
                    "true");
            intent.putExtra(EXTRAS_KEY_ACTIVITY_INSTANT,
                    "true");*/

				/* launch activity */
            this.startActivity(intent);
        } catch (Exception e) {
			/*
			 * may never occur, as long as all SampleActivities exist and are
			 * listed in manifest
			 */
            //final String className = getListActivities()[_lastSelectedListItemPosition];
            Toast.makeText(this, AutoHdSampleCamActivity.class + "\nnot defined/accessible",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
