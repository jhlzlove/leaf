package com.example.common.utils;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @author clf
 * @time 2022/8/11 18:28
 * @desc: IpUtil
 */
public class IpUtil {

    public static String getLocalUrl() {
        String address = null;
        try {
            address = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        return address;
    }

}
