package top.cj466.JavaUtils.Face;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import top.cj466.JavaUtils.http.HttpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class cmapi022049 {

    public static final String APPCODE = "c48cb15c2d52410994f1c3d4b904b652";

    /**
     * 身份证二要素
     *
     * @param
     * @return void
     */
    @Test
    public void test01() throws Exception {
        String host = "https://idcert.market.alicloudapi.com";
        String path = "/idcard";
        String appcode = APPCODE;
        String idCard = "429006199711070917";
        String name = "刘腾飞";
        String urlSend = host + path + "?idCard=" + idCard + "&name=" + name;
        URL url = new URL(urlSend);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);//格式Authorization:APPCODE (中间是英文空格)
        int httpCode = httpURLConnection.getResponseCode();
        String json = read(httpURLConnection.getInputStream());
        System.out.println("/* 获取服务器响应状态码 200 正常；400 权限错误 ； 403 次数用完； */ ");
        System.out.println(httpCode);
        System.out.println("/* 获取返回的json   */ ");
        System.out.print(json);
    }

    /**
     * 银行卡三要素
     *
     * @param
     * @return void
     */
    @Test
    public void test02() throws Exception {
        String host = "https://yunyidata3.market.alicloudapi.com";
        String path = "/bankAuthenticate3";
        String method = "POST";
        String appcode = APPCODE;
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();

        bodys.put("cardNo", "6217000010145050657");
        bodys.put("idNo", "429006199711070917");
        bodys.put("name", "刘腾飞");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 银行卡四要素
     *
     * @param
     * @return void
     */
    @Test
    public void test03() throws Exception {
        String host = "https://yunyidata.market.alicloudapi.com";
        String path = "/bankAuthenticate4";
        String method = "POST";
        String appcode = APPCODE;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("ReturnBankInfo", "YES"); // 是否返回银行信息

        bodys.put("cardNo", "6217000010145050657");
        bodys.put("idNo", "429006199711070917");
        bodys.put("name", "刘腾飞");
        bodys.put("phoneNo", "17607130783");

        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        读取返回结果
     */
    private String read(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = new String(line.getBytes(), "utf-8");
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    @Test
    public void sasa( ) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (int i = 0; i < list.size(); i++) {
            if(list.size()-1==i){
                System.out.println(list.get(i));
            }
        }
    }
}