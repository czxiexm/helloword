package com.qyh;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;


/**΢����ҵ�Ÿ���ע���û���������������Ϣ ��ҵ�ŷ���Ϣ����û������
* @author flyman 2015-8-7
*/
public class SendMessage {
	

	// ������Ϣ�������г�Ա
	// private final static String TOPARTY = "@all";
	// ��ȡ�����ļ��е�ֵ
	private final static String CORPID = "ww40fde4dbfae20cd7";// ��Ҫ�Լ����룬������������ҵ��
	// ������������
	private final static String AgentId = "1000003";
	private final static String CORPSECRET = "e-UQWiLTYYRc5SbLlRCMhKIRYmUeRK7aKRPbZnHX8lM";
	// ��ȡ����Ȩ����URL
	private final static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+CORPID+"&corpsecret="+CORPSECRET;
	// �����Ự����URL
	private final static String CREATE_SESSION_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
	//������
	//private final static String ACCESS_TOKEN_URL1 = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ww40fde4dbfae20cd7&corpsecret=e-UQWiLTYYRc5SbLlRCMhKIRYmUeRK7aKRPbZnHX8lM";

	// ��ȡ�ӿڷ���Ȩ����
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
	// ������ת����json
	net.sf.json.JSONObject jasonObject = JSONObject.fromObject(result);
	result = (String) jasonObject.get("access_token");
	post.releaseConnection();
	//System.out.println(result);
	return result;
	

	}

	
	@SuppressWarnings("deprecation")
	public String sendWeChatMessage(String ACCESS_TOKEN,String touser, String toparty, String totag, String content) {
	HttpClient client = new HttpClient();
	//String ACCESS_TOKEN =getAccessToken();
	StringBuffer sb = new StringBuffer();
	sb.append("{");
	sb.append("\"touser\":" + "\"" + touser + "\",");
	sb.append("\"toparty\":" + "\"" + toparty + "\",");
	sb.append("\"totag\":" + "\"" + totag + "\",");
	sb.append("\"msgtype\":" + "\"" + "text" + "\",");
	sb.append("\"agentid\":" + "\"" + AgentId + "\",");
	sb.append("\"text\":" + "{");
	sb.append("\"content\":" + "\"" + content + "\"},");
	sb.append("\"debug\":" + "\"" + "1" + "\"");
	sb.append("}");
	// ��������
	String url = CREATE_SESSION_URL + ACCESS_TOKEN;
	PostMethod post = new PostMethod(url);
	post.releaseConnection();
	post.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	// ���ò��ԣ���ֹ��cookie����
	// DefaultHttpParams.getDefaultParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
	// ��post���ò���
	post.setRequestBody(sb.toString());
	String result = "";
	try {
	client.executeMethod(post);
	result = new String(post.getResponseBodyAsString().getBytes("gbk"));
	} catch (IOException e) {
	e.printStackTrace();
	}
	//System.out.println(result);

	post.releaseConnection();

	return result;

	}

	

	public static void main(String[] args) {
		SendMessage weChat = new SendMessage();
		String ACCESS_TOKEN =weChat.getAccessToken();
		String a ="http://192.168.80.19:8080/test/login.jsp";
		String bm="8";	
		weChat.sendWeChatMessage(ACCESS_TOKEN,"", bm, "", a);		
	}

}
