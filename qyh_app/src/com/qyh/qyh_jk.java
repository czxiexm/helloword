package com.qyh;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class qyh_jk {
	
	private final static String CORPID = "ww40fde4dbfae20cd7";// 需要自己申请，官网有试用企业号
	private final static String AgentId = "1000003";
	private final static String CORPSECRET = "e-UQWiLTYYRc5SbLlRCMhKIRYmUeRK7aKRPbZnHX8lM";
	// 获取访问权限码URL
	private final static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+CORPID+"&corpsecret="+CORPSECRET;
	
	public String getAccessToken() {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(ACCESS_TOKEN_URL);
		post.releaseConnection();
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		String result = "";	
		try {
		client.executeMethod(post);
		result = new String(post.getResponseBodyAsString().getBytes("gbk"));	
		} catch (IOException e) {
		e.printStackTrace();
		}
		// 将数据转换成json
		net.sf.json.JSONObject jasonObject = JSONObject.fromObject(result);
		result = (String) jasonObject.get("access_token");
		post.releaseConnection();
		//System.out.println(result);
		return result;
		}
	
	public String getuserid(String code,String ACCESS_TOKEN) {
		String getuserid_URL="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+ACCESS_TOKEN+"&code="+code;
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(getuserid_URL);
		post.releaseConnection();
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		String result = "";	
		try {
		client.executeMethod(post);
		result = new String(post.getResponseBodyAsString().getBytes("gbk"));	
		System.out.println("接口-用户ID串："+result);
		} catch (IOException e) {
		e.printStackTrace();
		}
		// 将数据转换成json
		net.sf.json.JSONObject jasonObject = JSONObject.fromObject(result);
		result = (String) jasonObject.get("UserId");
		post.releaseConnection();
		System.out.println("接口-用户id:"+result);
		return result;		
		}
	
	public String[] getusermsg(String UserId,String ACCESS_TOKEN) {
		String getuserid_URL="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token="+ACCESS_TOKEN+"&userid="+UserId;
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(getuserid_URL);
		post.releaseConnection();
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		String[] result = new String[2];	
		try {
		client.executeMethod(post);
		result[0] = new String(post.getResponseBodyAsString().getBytes("gbk"));	
		System.out.println("接口-用户信息串："+result);
		} catch (IOException e) {
		e.printStackTrace();
		}
		// 将数据转换成json
		net.sf.json.JSONObject jasonObject = JSONObject.fromObject(result[0]);
		result[0] = (String) jasonObject.get("name").toString();
		result[1]=  (String) jasonObject.get("department").toString();
		result[1]=result[1].replace("[", "");
		result[1]=result[1].replace("]", "");
		post.releaseConnection();
		return result;		
		}
	
	public static void main(String[] args) {
		qyh_jk jk = new qyh_jk();
		String ACCESS_TOKEN =jk.getAccessToken();
		String[] msg=jk.getusermsg("10002",ACCESS_TOKEN);
		String name=msg[0];
		String[] bm=msg[1].split(","); 
		
		System.out.println(name);
		System.out.println(bm[0]);
		System.out.println(bm[1]);
		System.out.println(msg[1]);
	}
	
	

}
