package com.yao.zookeeper;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaojian on 2021/10/12 15:28
 *
 * @author
 */
public class JiJinTest {

    public static void main(String[] args) {
        //003096
        List<String> codes = new ArrayList<>();
        codes.add("320007");
        codes.add("159995");
        codes.add("519674");
        codes.add("003096");
        codes.add("004813");
        codes.add("001632");
        codes.add("002199");
        codes.add("001553");
        codes.add("010364");
        codes.add("167301");
        codes.add("161725");
        codes.add("001838");
        codes.add("001475");
        codes.add("002207");
        codes.add("005969");
        codes.add("004855");
        codes.add("002190");
        codes.add("290011");
        codes.add("003634");
        codes.add("161028");
        codes.add("000939");
        codes.add("515030");
        codes.add("673101");
        codes.forEach(code->{
            String data = getInfo("http://fundgz.1234567.com.cn/js/"+code+".js?rt=1463558676006");
            JSONObject jsonObject = JSONObject.parseObject(data.substring(8,data.length()-2));
            String name = jsonObject.getString("name");
            String gszzl = jsonObject.getString("gszzl");
            String gztime = jsonObject.getString("gztime");
            //System.out.println(jsonObject.toString());
            String info = name + "  :  " + gszzl + "%" + "  " + gztime;
            System.out.println(info);
        });

        //String data = getInfo("https://api.apiopen.top/getWangYiNews");
        //String data = getInfo("https://api.apiopen.top/getJoke");
        //System.out.println(data);
    }


    //https://www.juhe.cn/docs/api/id/235

    public static String getInfo(String urlString){
        String outputStr = null;
        StringBuffer buffer=null;
        try{

            //创建url
            URL url=new URL(urlString);
            //创建http连接
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //设置方法类型
            conn.setRequestMethod("GET");
            //建立连接
            conn.connect();
            //往服务器端写内容 也就是发起http请求需要带的参数
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String data = buffer.toString();
        return data;
    }
}
