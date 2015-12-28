若你要做模拟百度登录我这里分享一点我个人的想法。
1.你必须要准备一个HTTP抓包工具，你可以用火狐的firebug，也可以用HttpWatch，个人比较推荐后者。
2.模拟互联网的网站登录或表单请求，你肯定要了解它们登录的参数，这个过程是痛苦的，多看，多想，多试吧。
3.现在apache下有2个Httpclient可以用，推荐使用最新的Httpclient Core.

百度登录接口返回的一些状态说明，以下是我个人理解若有错误请莫怪。
switch (code) {
	case 0: // 登录成功。
		m.setStatusCode(200);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		break;
	case 1: // 帐号格式不对,或密码不对。
		m.setStatusCode(10);
		m.setO(json);
		break;
	case 2: // 登录异常，不在经常登录的区域登录，使用百度帐号在www.baidu.com登录并使用几分钟试试。此块频繁操作，可能需要验证码。
		m.setStatusCode(11);
		m.setO(json);
		break;
	case 4: // 密码错误。
		m.setStatusCode(6);
		m.setO(json);
		break;
	case 5: // 帐号被百度认定为异常，需要去百度(www.baidu.com)验证手机号。
		m.setStatusCode(5);
		break;
	case 6: // 验证码错误。
		m.setStatusCode(4);
		m.setO(json);
		break;
	case 257:// 需要填写验证码。
		m.setStatusCode(3);
		m.setO(json);
		break;
	case 120019: // 帐号被百度认定为异常，需要去百度(www.baidu.com)验证手机号。
		m.setStatusCode(5);
		break;
	default: // 其它原因，请联系工作人员。
		m.setStatusCode(500);
		break;
}