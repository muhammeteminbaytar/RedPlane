package com.muhammeteminbaytar.survivorbird;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AndroidLauncher extends AndroidApplication {
	private RelativeLayout layout;
	private RelativeLayout.LayoutParams params;
	private AdView bannerAd;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new SurvivorBird(), config);

		hideNavigatonBar();

		View gameView=initializeForView(new SurvivorBird(),config);

		layout =new RelativeLayout(this);
		layout.addView(gameView, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
		params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);


		params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		bannerAd=new AdView(this);
		bannerAd.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
		bannerAd.setAdSize(AdSize.BANNER);
		layout.addView(bannerAd,params);
		setContentView(layout);
		AdRequest ad=new AdRequest.Builder().build();
		bannerAd.loadAd(ad);
	}

	@Override
	protected void onResume() {

		hideNavigatonBar();
		super.onResume();
	}

	private void hideNavigatonBar() {

		this.getWindow().getDecorView().setSystemUiVisibility
				(View.SYSTEM_UI_FLAG_FULLSCREEN |
						View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
						View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
						View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
						View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE

				)
		;

	}



}
