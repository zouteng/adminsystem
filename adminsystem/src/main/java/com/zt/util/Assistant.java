/*
 * Name:Assistant.java
 * Version:1.0
 * Author:zot
 * Date:2013/11/12
 */
package com.zt.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import sun.misc.*;
import javax.servlet.http.HttpServletRequest;

public class Assistant {
	static Timer timer = new Timer();
	static final int BUFFER = 20480;
	public static final int _PAGESIZE = 10;

	public static String getSeqString() {
		SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		System.currentTimeMillis();
		String r1 = new Timestamp(System.currentTimeMillis()).toString();
		String r2 = String.valueOf(Math.random());
		r1 = r1.substring(r1.lastIndexOf(".") + 1, r1.length());
		r2 = r2.substring(r2.lastIndexOf(".") + 1, r2.lastIndexOf(".") + 3);
		if (r1.length() < 3) {
			for (int i = r1.length(); i < 3; i++) {
				r1 = "0" + r1;
			}
		}
		String seq = oDateFormat.format(date) + r1 + r2;
		return seq;
	}

	public static String getNowTimeString() {
		SimpleDateFormat oDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String seq = oDateFormat.format(date);
		return seq;
	}

	public static String getNowTimeStringtoDay() {
		SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String seq = oDateFormat.format(date);
		return seq;
	}

	public static String getDatetoMonth() {
		SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy-MM");
		Date date = new Date();
		String data = "";
		data = oDateFormat.format(date);
		return data;
	}

	public static int getDayByMonth(String date) {
		int days = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date d = sdf.parse(date);
			Calendar c = new GregorianCalendar();
			c.setTime(d);
			days = c.getActualMaximum(5);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.set(1, cal.get(1));
		cal.set(2, cal.get(2));
		cal.set(5, cal.get(5));
		cal.add(12, -5);
		Date dates = cal.getTime();
		return df.format(dates);
	}

	public static String string2Time(String dateString) throws ParseException {
		String seq = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",
				Locale.ENGLISH);
		SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);
		Timestamp dateTime = new Timestamp(timeDate.getTime());
		seq = oDateFormat.format(dateTime);
		return seq;
	}

	public static long getSeqNumber() {
		String seq = getSeqString();
		long ls = Long.parseLong(seq);
		return ls;
	}

	public static String Trim(Object obj) {
		if (obj == null) {
			return "";
		}
		return String.valueOf(obj).trim();
	}

	public static short ParseShort(Object obj) {
		short rtn = 0;
		try {
			String ss = String.valueOf(obj).trim();
			rtn = Short.valueOf(ss).shortValue();
		} catch (Exception e) {
			rtn = 0;
		}
		return rtn;
	}

	public static int ParseInt(Object obj) {
		int rtn = 0;
		try {
			String ss = String.valueOf(obj).trim();
			rtn = Integer.valueOf(ss).intValue();
		} catch (Exception e) {
			rtn = 0;
		}
		return rtn;
	}

	public static long ParseLong(Object obj) {
		long rtn = 0L;
		try {
			String ss = String.valueOf(obj).trim();
			rtn = Long.valueOf(ss).longValue();
		} catch (Exception e) {
			rtn = 0L;
		}
		return rtn;
	}

	public static String ChangeStr(String[] str) {
		String changeStr = "";
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				changeStr = changeStr + str[i] + ",";
			}
			changeStr = changeStr.substring(0, changeStr.length() - 1);
		}
		System.out.println("changeStr=" + changeStr);
		return changeStr;
	}

	public static String[] ChangeArr(String str) {
		StringTokenizer st = new StringTokenizer(str, ",");
		Vector v = new Vector();
		while (st.hasMoreTokens())
			v.add(st.nextToken());
		String[] strArr = new String[v.size()];
		v.copyInto(strArr);
		return strArr;
	}

	public static void Reminder() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(12, 2);
		calendar.set(13, 2);
		Date time = calendar.getTime();
		System.out.println("set time =" + time);
		Timer timer = new Timer();
		timer.schedule(new RemindTask(), time);
	}

	public static String getXmlPath(String configFile) {
		String xmlPath = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		xmlPath = xmlPath.substring(xmlPath.indexOf("/") + 1);
		xmlPath = xmlPath.substring(0, xmlPath.lastIndexOf("/"));
		xmlPath = xmlPath.substring(0, xmlPath.lastIndexOf("/"));
		xmlPath = xmlPath + configFile;
		return xmlPath;
	}

	public static String getSYSPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		path = path.substring(path.indexOf("/") + 1);
		path = path.substring(0, path.indexOf("WEB-INF"));
		return path;
	}

	public static void put(File f, ZipOutputStream out, String dir)
			throws IOException {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			dir = dir + (dir.length() == 0 ? "" : "/") + f.getName();
			for (File file : files)
				put(file, out, dir);
		} else {
			byte[] data = new byte[20480];
			FileInputStream fi = new FileInputStream(f);
			BufferedInputStream origin = new BufferedInputStream(fi, 20480);
			dir = dir + "/" + f.getName();
			ZipEntry entry = new ZipEntry(dir);
			out.putNextEntry(entry);
			int count;
			while ((count = origin.read(data, 0, 20480)) != -1) {
				// int count;
				out.write(data, 0, count);
			}
			origin.close();
		}
	}

	public static String getTime() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sf.format(d);
		return time;
	}

	public static String getDateString() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sf.format(d);
		return time;
	}

	public static String getComputerName(HttpServletRequest request) {
		return request.getRemoteHost();
	}

	public static String getComputerIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	public static boolean downLoadFile(String urlString, String localFile) {
		byte[] buffer = new byte[512];
		int size = 0;
		boolean success = false;
		try {
			URL url = new URL(urlString);
			BufferedInputStream stream = new BufferedInputStream(
					url.openStream());
			FileOutputStream fos = new FileOutputStream(localFile);
			while ((size = stream.read(buffer)) != -1) {
				fos.write(buffer, 0, size);
			}
			fos.close();
			stream.close();
			success = true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean checkXMLFileExist(String path) {
		File file = new File(path);
		return file.exists();
	}

	public static Timestamp getTimestamp() {
		Calendar calendar = Calendar.getInstance();
		return new Timestamp(calendar.getTimeInMillis());
	}

	public static Timestamp getTimestamp(String date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sf.parse(date);
		calendar.setTime(d);
		return new Timestamp(calendar.getTimeInMillis());
	}

	private static class RemindTask extends TimerTask {
		public void run() {
			System.out.println("Time's up!");
			Assistant.timer.cancel();
			System.out.println("timer has scanceled");
			System.out.println("noe time =" + Calendar.getInstance());
		}
	}

	public static String digestByMD5(String str) throws Exception {
		// 采用MD5加密算法，将任意长度字符串加密
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bts = md.digest(str.getBytes());
		// 采用Base64算法，将加密后的字节变成字符串
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(bts);
	}
}