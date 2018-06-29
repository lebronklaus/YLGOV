package com.nwsuaf.mob.download;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;



public class DownloadUtils {

	public static String getDownloadFileName(String agent, String filename) throws UnsupportedEncodingException {
		if (agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");

		} else if (agent.contains("Firefox")) {
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}

		return filename;
	}
}
