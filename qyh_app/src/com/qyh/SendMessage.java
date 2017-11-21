package com.qyh;
import java.io.IOException;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;


/**微信企业号给关注的用户主动发送推送消息 企业号发消息条数没有限制
* @author flyman 2015-8-7
*/
public class SendMessage {
	

	// 发送消息分组所有成员
	// private final static String TOPARTY = "@all";
	// 获取配置文件中的值
	private final static String CORPID = "ww40fde4dbfae20cd7";// 需要自己申请，官网有试用企业号
	// 可以申请试用
	private final static String AgentId = "1000003";
	private final static String CORPSECRET = "e-UQWiLTYYRc5SbLlRCMhKIRYmUeRK7aKRPbZnHX8lM";
	// 获取访问权限码URL
	private final static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+CORPID+"&corpsecret="+CORPSECRET;
	// 创建会话请求URL
	private final static String CREATE_SESSION_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
	//带参数
	//private final static String ACCESS_TOKEN_URL1 = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ww40fde4dbfae20cd7&corpsecret=e-UQWiLTYYRc5SbLlRCMhKIRYmUeRK7aKRPbZnHX8lM";

	// 获取接口访问权限码
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
	// 请求链接
	String url = CREATE_SESSION_URL + ACCESS_TOKEN;
	PostMethod post = new PostMethod(url);
	post.releaseConnection();
	post.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	// 设置策略，防止报cookie错误
	// DefaultHttpParams.getDefaultParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
	// 给post设置参数
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
