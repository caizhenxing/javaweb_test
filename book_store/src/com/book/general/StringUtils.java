package com.book.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
 
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    public static void main(String[] args) {
        System.out.println(StringUtils.replaceBlank("just\t\\ do it!"));
    }
    /*-----------------------------------
 
    ��������String s = "��Ҫȥ�����ַ���";
 
            1.ȥ���ո�s = s.replace('\\s','');
 
            2.ȥ���س���s = s.replace('\n','');
 
    ����Ҳ���԰ѿո�ͻس�ȥ��������Ҳ��������������
 
    ע��\n �س�(\u000a) 
    \t ˮƽ�Ʊ��(\u0009) 
    \s �ո�(\u0008) 
    \r ����(\u000d)*/
}