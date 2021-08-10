package com.example.springboot_activiti.common.utils.ip;


import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;



import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *  获取地址
 *
 */
@Slf4j
public final class AddressUtils {


    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";
/*
*
* 获取用户系统，版本，浏览器
*
*/
    public static String userAgent(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        Version browserVersion = userAgent.getBrowserVersion();
        log.info("浏览器"+browser.getName());
        log.info("系统"+operatingSystem.getName());
//        log.info("版本"+browserVersion.getVersion());
        return browser.getName();

    }

    /**
     * 获取ip所在地
     */
    public static String getAddress(String ip)
    {
        String address = "";
        try
        {
            address = sendPost("ip=" + ip, "UTF-8");

            JSONObject json = JSONObject.parseObject(address);
            JSONObject object = json.getObject("data", JSONObject.class);
            String region = object.getString("region");
            String country = object.getString("country");
            String city = object.getString("city");
            address =country+" "+ region + " " + city;
        }
        catch (Exception e)
        {
            log.error("根据IP获取所在位置----------错误消息：[{}]" , e.getMessage());
        }
        return address==null?"获取地址失败":address;
    }

    /**
     * 获取查询结果
     */
    private static String sendPost(String content, String encoding)
    {
        URL url = null;
        HttpURLConnection connection = null;
        try
        {
            url = new URL(IP_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(content);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        }
        catch (IOException e)
        {
            System.out.println("温馨提醒：您的主机已经断网，请您检查主机的网络连接");
            System.out.println("根据IP获取所在位置----------错误消息：" + e.getMessage());
        }
        finally
        {
            if (connection != null)
            {
                connection.disconnect();
            }
        }
        return null;
    }

}
