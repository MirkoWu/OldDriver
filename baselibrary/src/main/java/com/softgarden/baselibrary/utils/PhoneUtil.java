package com.softgarden.baselibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.softgarden.baselibrary.BaseApplication;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by DELL on 2017/9/23.
 */

public class PhoneUtil {
    private PhoneUtil() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    /**
     * 获取设备系统版本号
     *
     * @return 设备系统版本号
     */

    public static int getSDKVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    @SuppressLint("HardwareIds")

    public static String getPhoneStatus() {

        TelephonyManager tm = (TelephonyManager) BaseApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
        String str = "";
        str += "DeviceId(IMEI) = " + tm.getDeviceId() + "\n";
        str += "DeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion() + "\n";
        str += "Line1Number = " + tm.getLine1Number() + "\n";
        str += "NetworkCountryIso = " + tm.getNetworkCountryIso() + "\n";
        str += "NetworkOperator = " + tm.getNetworkOperator() + "\n";
        str += "NetworkOperatorName = " + tm.getNetworkOperatorName() + "\n";
        str += "NetworkType = " + tm.getNetworkType() + "\n";
        str += "PhoneType = " + tm.getPhoneType() + "\n";
        str += "SimCountryIso = " + tm.getSimCountryIso() + "\n";
        str += "SimOperator = " + tm.getSimOperator() + "\n";
        str += "SimOperatorName = " + tm.getSimOperatorName() + "\n";
        str += "SimSerialNumber = " + tm.getSimSerialNumber() + "\n";
        str += "SimState = " + tm.getSimState() + "\n";
        str += "SubscriberId(IMSI) = " + tm.getSubscriberId() + "\n";
        str += "VoiceMailNumber = " + tm.getVoiceMailNumber() + "\n";
        return str;

    }
}
