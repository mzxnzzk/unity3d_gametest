package com.example.hello3;

import com.example.hello3.CircleView.Dir;
import com.unity3d.player.UnityPlayer;

import android.R.string;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/*我们这里让我们定义的MainActivity继承自Unity导出项目中的UnityPlayerNativeActivity*/
public class MainActivity extends UnityPlayerActivity {
	private Button BtnUp,BtnDown,BtnLeft,BtnRight,BtnJump,BtnCrouch,BtnAttack;
	public static String TAG_UNITY="Main Person";
	public static String TAG_UNITY_PLAYER="Main Player";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 获取显示Unity视图的父控件
		LinearLayout mParent = (LinearLayout) findViewById(R.id.UnityView);
		// 获取Unity视图
		View mView = mUnityPlayer.getView();
		// 将Unity视图添加到Android视图中
		mParent.addView(mView);
		final CircleView cv = (CircleView) findViewById(R.id.cv);
		cv.dir=Dir.CENTER;
		cv.postInvalidate();
		// 放大
	/*	BtnUp = (Button) findViewById(R.id.but_up);
		BtnDown = (Button) findViewById(R.id.but_down);
		BtnLeft = (Button) findViewById(R.id.but_left);
		BtnRight = (Button) findViewById(R.id.but_right);*/
		BtnJump = (Button) findViewById(R.id.but_jump);
		BtnCrouch = (Button) findViewById(R.id.but_crouch);
		BtnAttack=(Button)findViewById(R.id.but_attack);
	/*	BtnUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();
				UnityPlayer.UnitySendMessage(TAG_UNITY, "forAndroidUp", "");

			}
		});

		BtnLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();
				UnityPlayer.UnitySendMessage(TAG_UNITY, "forAndroidLeft", "");

			}
		});
		BtnRight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();
				UnityPlayer.UnitySendMessage(TAG_UNITY, "forAndroidRight", "");

			}
		});
		BtnDown.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();
				UnityPlayer.UnitySendMessage(TAG_UNITY, "forAndroidDown", "");

			}
		});
		*/
		BtnJump.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			/*	Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();*/
				UnityPlayer.UnitySendMessage(TAG_UNITY, "forAndroidJump", "");
				UnityPlayer.UnitySendMessage(TAG_UNITY_PLAYER, "forAndroidJump", "");
				
			}
		});
		BtnCrouch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			/*	Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();*/
				UnityPlayer.UnitySendMessage(TAG_UNITY, "forAndroidCrouch", "");
				UnityPlayer.UnitySendMessage(TAG_UNITY_PLAYER, "forAndroidCrouch", "");
			}
		});
		BtnAttack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			/*	Log.v("tag", "zoom in");
				
				Toast.makeText(getApplicationContext(), "zoomin",
						Toast.LENGTH_SHORT).show();*/
				int i=(int)(Math.random()*6);
				
				UnityPlayer.UnitySendMessage(TAG_UNITY_PLAYER, "Attack", String.valueOf(i));

			}
		});

	}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    { 
        if(keyCode == KeyEvent.KEYCODE_BACK) 
        { 
            finish(); 
            Log.e("key", "key"); 
        } 
        // TODO Auto-generated method stub 
        return super.onKeyDown(keyCode, event); 
    } 
}
