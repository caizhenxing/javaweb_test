����Ҫ��ģ��ٶȵ�¼���������һ���Ҹ��˵��뷨��
1.�����Ҫ׼��һ��HTTPץ�����ߣ�������û����firebug��Ҳ������HttpWatch�����˱Ƚ��Ƽ����ߡ�
2.ģ�⻥��������վ��¼���������϶�Ҫ�˽����ǵ�¼�Ĳ��������������ʹ��ģ��࿴�����룬���԰ɡ�
3.����apache����2��Httpclient�����ã��Ƽ�ʹ�����µ�Httpclient Core.

�ٶȵ�¼�ӿڷ��ص�һЩ״̬˵�����������Ҹ���������д�����Ī�֡�
switch (code) {
	case 0: // ��¼�ɹ���
		m.setStatusCode(200);
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		break;
	case 1: // �ʺŸ�ʽ����,�����벻�ԡ�
		m.setStatusCode(10);
		m.setO(json);
		break;
	case 2: // ��¼�쳣�����ھ�����¼�������¼��ʹ�ðٶ��ʺ���www.baidu.com��¼��ʹ�ü��������ԡ��˿�Ƶ��������������Ҫ��֤�롣
		m.setStatusCode(11);
		m.setO(json);
		break;
	case 4: // �������
		m.setStatusCode(6);
		m.setO(json);
		break;
	case 5: // �ʺű��ٶ��϶�Ϊ�쳣����Ҫȥ�ٶ�(www.baidu.com)��֤�ֻ��š�
		m.setStatusCode(5);
		break;
	case 6: // ��֤�����
		m.setStatusCode(4);
		m.setO(json);
		break;
	case 257:// ��Ҫ��д��֤�롣
		m.setStatusCode(3);
		m.setO(json);
		break;
	case 120019: // �ʺű��ٶ��϶�Ϊ�쳣����Ҫȥ�ٶ�(www.baidu.com)��֤�ֻ��š�
		m.setStatusCode(5);
		break;
	default: // ����ԭ������ϵ������Ա��
		m.setStatusCode(500);
		break;
}