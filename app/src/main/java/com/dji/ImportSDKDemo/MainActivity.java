package com.dji.ImportSDKDemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dji.common.error.DJIError;
import dji.common.error.DJISDKError;
import dji.common.util.DJICommonCallbacks;
import dji.sdk.base.DJIBaseComponent;
import dji.sdk.base.DJIBaseProduct;
import dji.sdk.flightcontroller.DJIFlightController;
import dji.sdk.flightcontroller.DJIFlightControllerDelegate;
import dji.sdk.products.DJIAircraft;
import dji.sdk.sdkmanager.DJISDKManager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    public static final String FLAG_CONNECTION_CHANGE = "dji_sdk_connection_change";
    private static DJIBaseProduct mProduct;
    private Handler mHandler;

    private Button ActiveBtn;
    private Button TakeOffBtn;
    private Button SearchBtn;
    private Button StopBtn;
    private Button CameraOnBtn;
    private Button CameraOffBtn;

    private DJIAircraft mAircraft;
    DJIFlightController mFlightController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler(Looper.getMainLooper());
        DJISDKManager.getInstance().initSDKManager(this, mDJISDKManagerCallback);

        ActiveBtn=(Button)findViewById(R.id.active_btn);
        TakeOffBtn=(Button)findViewById(R.id.takeoff_btn);
        SearchBtn=(Button)findViewById(R.id.search_btn);
        StopBtn=(Button)findViewById(R.id.stop_btn);
        CameraOnBtn=(Button)findViewById(R.id.camera_on_btn);
        CameraOffBtn=(Button)findViewById(R.id.camera_off_btn);

        /*
        try{
            mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
            mFlightController = mAircraft.getFlightController();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
        }
        */

        ActiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"获取控制权",Toast.LENGTH_LONG).show();
                //TODO:
                try {
                    byte[] data = {0};
                    mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
                    mFlightController = mAircraft.getFlightController();
                    if(mFlightController.isOnboardSDKDeviceAvailable()) {
                        DJICommonCallbacks.DJICompletionCallback callback = new DJICommonCallbacks.DJICompletionCallback() {
                            @Override
                            public void onResult(DJIError djiError) {
                                if (djiError != null) {
                                    //ActiveRet.setText("Error");
                                    Toast.makeText(MainActivity.this, djiError.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    //ActiveRet.setText("No Error");
                                    Toast.makeText(MainActivity.this, "获取控制权", Toast.LENGTH_LONG).show();
                                }
                            }
                        };
                        mFlightController.sendDataToOnboardSDKDevice(data, callback);
                    }else{
                        Toast.makeText(MainActivity.this, "OnBoard unavailable!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
                }
            }
        });

        TakeOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:
                try {
                    byte[] data = {1};
                    mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
                    mFlightController = mAircraft.getFlightController();
                    if(mFlightController.isOnboardSDKDeviceAvailable()) {
                        mFlightController.sendDataToOnboardSDKDevice(data, new DJICommonCallbacks.DJICompletionCallback() {
                            @Override
                            public void onResult(DJIError djiError) {
                                if (djiError != null) {
                                    Toast.makeText(MainActivity.this, djiError.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "起飞", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }else{
                        Toast.makeText(MainActivity.this, "OnBoard unavailable!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
                }
            }
        });

        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:
                try {
                    byte[] data = {2};
                    mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
                    mFlightController = mAircraft.getFlightController();
                    if(mFlightController.isOnboardSDKDeviceAvailable()) {
                        mFlightController.sendDataToOnboardSDKDevice(data, new DJICommonCallbacks.DJICompletionCallback() {
                            @Override
                            public void onResult(DJIError djiError) {
                                if (djiError != null) {
                                    Toast.makeText(MainActivity.this, djiError.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "开始搜索", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(MainActivity.this, "OnBoard unavailable!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
                }
            }
        });

        StopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:
                try {
                    byte[] data = {3};
                    mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
                    mFlightController = mAircraft.getFlightController();
                    if(mFlightController.isOnboardSDKDeviceAvailable()) {
                        mFlightController.sendDataToOnboardSDKDevice(data, new DJICommonCallbacks.DJICompletionCallback() {
                            @Override
                            public void onResult(DJIError djiError) {
                                if (djiError != null) {
                                    Toast.makeText(MainActivity.this, djiError.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "停止", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(MainActivity.this, "OnBoard unavailable!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
                }
            }
        });

        CameraOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    byte[] data = {4};
                    mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
                    mFlightController = mAircraft.getFlightController();
                    if(mFlightController.isOnboardSDKDeviceAvailable()) {
                        mFlightController.sendDataToOnboardSDKDevice(data, new DJICommonCallbacks.DJICompletionCallback() {
                            @Override
                            public void onResult(DJIError djiError) {
                                if (djiError != null) {
                                    Toast.makeText(MainActivity.this, djiError.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "开启相机", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(MainActivity.this, "OnBoard unavailable!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
                }
            }
        });

        CameraOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    byte[] data = {5};
                    mAircraft = (DJIAircraft) DJISDKManager.getInstance().getDJIProduct();
                    mFlightController = mAircraft.getFlightController();
                    if(mFlightController.isOnboardSDKDeviceAvailable()) {
                        mFlightController.sendDataToOnboardSDKDevice(data, new DJICommonCallbacks.DJICompletionCallback() {
                            @Override
                            public void onResult(DJIError djiError) {
                                if (djiError != null) {
                                    Toast.makeText(MainActivity.this, djiError.toString(), Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "关闭相机", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(MainActivity.this, "OnBoard unavailable!", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Flight!", Toast.LENGTH_LONG).show();
                }
            }
        });

        try {
            mFlightController.setReceiveExternalDeviceDataCallback(new DJIFlightControllerDelegate.FlightControllerReceivedDataFromExternalDeviceCallback() {
                @Override
                public void onResult(byte[] bytes) {
                    String re = bytes.toString();
                    Toast.makeText(MainActivity.this, re, Toast.LENGTH_LONG).show();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private DJISDKManager.DJISDKManagerCallback mDJISDKManagerCallback = new DJISDKManager.DJISDKManagerCallback() {
        @Override
        public void onGetRegisteredResult(DJIError error) {
            Log.d(TAG, error == null ? "success" : error.getDescription());
            if(error == DJISDKError.REGISTRATION_SUCCESS) {
                DJISDKManager.getInstance().startConnectionToProduct();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Register App Successful", Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Register App Failed! Please enter your App Key and check the network.", Toast.LENGTH_LONG).show();
                    }
                });
            }
            Log.e("TAG", error.toString());
        }
        @Override
        public void onProductChanged(DJIBaseProduct oldProduct, DJIBaseProduct newProduct) {
            mProduct = newProduct;
            if(mProduct != null) {
                mProduct.setDJIBaseProductListener(mDJIBaseProductListener);
            }
            notifyStatusChange();
        }
    };
    private DJIBaseProduct.DJIBaseProductListener mDJIBaseProductListener = new DJIBaseProduct.DJIBaseProductListener() {
        @Override
        public void onComponentChange(DJIBaseProduct.DJIComponentKey key, DJIBaseComponent oldComponent, DJIBaseComponent newComponent) {
            if(newComponent != null) {
                newComponent.setDJIComponentListener(mDJIComponentListener);
            }
            notifyStatusChange();
        }
        @Override
        public void onProductConnectivityChanged(boolean isConnected) {
            notifyStatusChange();
        }
    };
    private DJIBaseComponent.DJIComponentListener mDJIComponentListener = new DJIBaseComponent.DJIComponentListener() {
        @Override
        public void onComponentConnectivityChanged(boolean isConnected) {
            notifyStatusChange();
        }
    };
    private void notifyStatusChange() {
        mHandler.removeCallbacks(updateRunnable);
        mHandler.postDelayed(updateRunnable, 500);
    }
    private Runnable updateRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(FLAG_CONNECTION_CHANGE);
            sendBroadcast(intent);
        }
    };

}
