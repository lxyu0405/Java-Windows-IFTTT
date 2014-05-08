/**https://api.weibo.com/oauth2/authorize?client_id=579143534&redirect_uri=http://www.baidu.com&response_type=code&state=&scope=
*Hit enter when it's done.[Enter]:03ae2a4dd2e674590a519543fa7a25c2
0    INFO  [2013-11-14 16:18:16]  code: 03ae2a4dd2e674590a519543fa7a25c2
2    DEBUG [2013-11-14 16:18:16]  Request:
2    DEBUG [2013-11-14 16:18:16]  POSThttps://api.weibo.com/oauth2/access_token
891  DEBUG [2013-11-14 16:18:16]  Response:
891  DEBUG [2013-11-14 16:18:16]  https StatusCode:200
891  DEBUG [2013-11-14 16:18:16]  Server:nginx/1.2.0
891  DEBUG [2013-11-14 16:18:16]  Date:Thu, 14 Nov 2013 08:18:16 GMT
891  DEBUG [2013-11-14 16:18:16]  Content-Type:text/plain;charset=UTF-8
892  DEBUG [2013-11-14 16:18:16]  Content-Length:117
892  DEBUG [2013-11-14 16:18:16]  Connection:keep-alive
892  DEBUG [2013-11-14 16:18:16]  Pragma:No-cache
892  DEBUG [2013-11-14 16:18:16]  Cache-Control:no-cache
892  DEBUG [2013-11-14 16:18:16]  Expires:Thu, 01 Jan 1970 00:00:00 GMT
892  DEBUG [2013-11-14 16:18:16]  Api-Server-IP:10.75.25.114
892  DEBUG [2013-11-14 16:18:16]  SINA-LB:c3NsLjEzMi5nMS5xaC5sYi5zaW5hbm9kZS5jb20=
892  DEBUG [2013-11-14 16:18:16]  SINA-TS:NGQ4OGMzNjggMCAxIDEgNyAzNDQK
895  DEBUG [2013-11-14 16:18:16]  {"access_token":"2.00UFwQZC0kgBMdf5bf88c9200KpFcH","remind_in":"157679999","expires_in":157679999,"uid":"2353473964"}

AccessToken [accessToken=2.00UFwQZC0kgBMdf5bf88c9200KpFcH, expireIn=157679999, refreshToken=,uid=2353473964]
*/

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class WeiboAction {

	public static void SendWeibo(String content) {
		String access_token = "2.00UFwQZC0kgBMdf5bf88c9200KpFcH";
		String statuses = content;
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			Status status = tm.UpdateStatus(statuses);
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}	
	}
}
