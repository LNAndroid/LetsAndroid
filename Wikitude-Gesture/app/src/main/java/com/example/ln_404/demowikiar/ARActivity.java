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


        /*this.architectView = (ArchitectView)this.findViewById( R.id.architectView );
        final ArchitectStartupConfiguration config = new ArchitectStartupConfiguration();
        config.setLicenseKey(WikitudeSDKConstants.WIKITUDE_SDK_KEY);
        this.architectView.onCreate( config );

        this.architectView.onPostCreate();
        try {
            this.architectView.load("http://52.66.190.52/Dealsfinal/ar/01_Image$Tracking_1_Image$On$Target/");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        loadExample();
    }

    private void loadExample() {
        try {
            final Intent intent = new Intent(this, AutoHdSampleCamActivity.class);
            intent.putExtra(EXTRAS_KEY_ACTIVITY_TITLE_STRING,
                    "AR");
                intent.putExtra(EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL, "file:///android_asset/ar/14_Advanced$Image$Tracking_1_Gestures/index.html");

//            intent.putExtra(EXTRAS_KEY_ACTIVITY_ARCHITECT_WORLD_URL,
//                    "http://52.66.190.52/Dealsfinal/ar/14_Advanced$Image$Tracking_1_Gestures/");

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
