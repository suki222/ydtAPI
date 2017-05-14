package com.yidiantong.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by wujw on 17/4/28.
 */
@SuppressWarnings("deprecation")
public class HttpUtils {

    /**
     * @param @param  reqUrl
     * @param @param  params
     * @param @return
     * @param @throws Exception
     * @Description: http get请求共用方法
     * @author dapengniao
     * @date 2016年3月10日 下午3:57:39
     */
    @SuppressWarnings("resource")
    public static String sendGet(String reqUrl, Map<String, String> params,boolean isWX)
            throws Exception {
        InputStream inputStream = null;
        HttpGet request = new HttpGet();
        String url="";
        try {
            if(isWX){
                 url = buildUrl(reqUrl, params);//微信的拼接方式
            }else{
                 url = buildUrl_(reqUrl, params);//ylz的拼接方式
            }
            System.out.println("======请求地址======"+url);
            HttpClient client = new DefaultHttpClient();

            request.setHeader("Accept-Encoding", "gzip");
            request.setURI(new URI(url));

            HttpResponse response = client.execute(request);

            inputStream = response.getEntity().getContent();
            String result ="";
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = getJsonStringFromGZIP(inputStream);
                System.out.println("请求服务器成功，做相应处理");
            } else {
                System.out.println("请求服务器失败==="+result);
                result=response.getStatusLine().getStatusCode()+"";
                System.out.println("状态码====="+result);
            }
            return result;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            request.releaseConnection();
        }

    }

    /**
     * @param @param  reqUrl
     * @param @param  params
     * @param @return
     * @param @throws Exception
     * @Description: http post请求共用方法
     * @author dapengniao
     * @date 2016年3月10日 下午3:57:53
     */
    @SuppressWarnings("resource")
    public static String sendPost(String reqUrl, Map<String, String> params)
            throws Exception {
        try {
            Set<String> set = params.keySet();
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (String key : set) {
                list.add(new BasicNameValuePair(key, params.get(key)));
            }
            if (list.size() > 0) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpPost request = new HttpPost(reqUrl);

                    request.setHeader("Accept-Encoding", "gzip");
                    request.setHeader("Content-Type", "application/x-www-form-urlencoded");
                    request.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));

                    HttpResponse response = client.execute(request);

                    InputStream inputStream = response.getEntity().getContent();
                    try {
                        String result ="";
                        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                            result = getJsonStringFromGZIP(inputStream);
                            System.out.println("请求服务器成功，做相应处理");
                        } else {
                            System.out.println("请求服务器失败==="+result);
                            result=response.getStatusLine().getStatusCode()+"";
                            System.out.println("状态码====="+result);
                        }

                        return result;
                    } finally {
                        inputStream.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new Exception("网络连接失败,请连接网络后再试");
                }
            } else {
                throw new Exception("参数不全，请稍后重试");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("发送未知异常");
        }
    }

    /**
     * @param @param  urls
     * @param @param  params
     * @param @return
     * @param @throws ClientProtocolException
     * @param @throws IOException
     * @Description: http post请求json数据
     * @author dapengniao
     * @date 2016年3月10日 下午3:58:15
     */
    public static String sendPostBuffer(String urls, String params)
            throws ClientProtocolException, IOException {
        HttpPost request = new HttpPost(urls);

        StringEntity se = new StringEntity(params, HTTP.UTF_8);
        request.setEntity(se);
        // 发送请求
        @SuppressWarnings("resource")
        HttpResponse httpResponse = new DefaultHttpClient().execute(request);
        // 得到应答的字符串，这也是一个 JSON 格式保存的数据
        String retSrc = EntityUtils.toString(httpResponse.getEntity());
        request.releaseConnection();
        return retSrc;

    }

    /**
     * @param @param  urlStr
     * @param @param  xmlInfo
     * @param @return
     * @Description: http请求发送xml内容
     * @author dapengniao
     * @date 2016年3月10日 下午3:58:32
     */
    public static String sendXmlPost(String urlStr, String xmlInfo) {
        // xmlInfo xml具体字符串

        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Pragma:", "no-cache");
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");
            OutputStreamWriter out = new OutputStreamWriter(
                    con.getOutputStream());
            out.write(new String(xmlInfo.getBytes("utf-8")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String lines = "";
            for (String line = br.readLine(); line != null; line = br
                    .readLine()) {
                lines = lines + line;
            }
            return lines; // 返回请求结果
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    private static String getJsonStringFromGZIP(InputStream is) {
        String jsonString = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            bis.mark(2);
            // 取前两个字节
            byte[] header = new byte[2];
            int result = bis.read(header);
            // reset输入流到开始位置
            bis.reset();
            // 判断是否是GZIP格式
            int headerData = getShort(header);
            // Gzip 流 的前两个字节是 0x1f8b
            if (result != -1 && headerData == 0x1f8b) {
                // LogUtil.i("HttpTask", " use GZIPInputStream  ");
                is = new GZIPInputStream(bis);
            } else {
                // LogUtil.d("HttpTask", " not use GZIPInputStream");
                is = bis;
            }
            InputStreamReader reader = new InputStreamReader(is, "utf-8");
            char[] data = new char[100];
            int readSize;
            StringBuffer sb = new StringBuffer();
            while ((readSize = reader.read(data)) > 0) {
                sb.append(data, 0, readSize);
            }
            jsonString = sb.toString();
            bis.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    private static int getShort(byte[] data) {
        return (data[0] << 8) | data[1] & 0xFF;
    }

    /**
     * 构建get方式的url
     *
     * @param reqUrl 基础的url地址
     * @param params 查询参数
     * @return 构建好的url
     */
    public static String buildUrl(String reqUrl, Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        Set<String> set = params.keySet();
        for (String key : set) {
            query.append(String.format("%s=%s&", key, params.get(key)));
        }
        return reqUrl + "?" + query.toString();
    }

    /**
     * 构建get方式的url
     * @param reqUrl 基础的url地址
     * @param params 参数
     * @return 构建好的url
     */
    public static String buildUrl_(String reqUrl, Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        Set<String> set = params.keySet();
        for (String key : set) {
            query.append(String.format("/%s",params.get(key)));
        }
        return reqUrl + query.toString();
    }

    /**
     * post请求
     * @param url
     * @param json 参数
     * @return
     */
    public static String sendJsonPost(String url, JSONObject json) {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        post.setHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Basic YWRtaW46");
        String result = "";

        try {

            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            post.setEntity(s);

            // 发送请求
            HttpResponse httpResponse = client.execute(post);

            // 获取响应输入流
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inStream, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
                strber.append(line + "\n");
            inStream.close();

            result = strber.toString();

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK||httpResponse.getStatusLine().getStatusCode() == 201) {
                System.out.println("请求服务器成功，做相应处理");
            } else {
                System.out.println("请求服务器失败==="+result);
                result=httpResponse.getStatusLine().getStatusCode()+"";
                System.out.println("状态码====="+result);
            }
        } catch (Exception e) {
            System.out.println("请求异常");
            throw new RuntimeException(e);
        }

        return result;
    }
    /**
     * put请求
     * @param url
     * @param json 参数
     * @return
     */
    public static String sendJsonPut(String url, JSONObject json) {

        HttpClient client = new DefaultHttpClient();
        HttpPut put = new HttpPut(url);

        put.setHeader("Content-Type", "application/json");
        put.addHeader("Authorization", "Basic YWRtaW46");
        String result = "";
        try {
            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
                    "application/json"));
            put.setEntity(s);

            // 发送请求
            HttpResponse httpResponse = client.execute(put);

            // 获取响应输入流
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inStream, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
                strber.append(line + "\n");
            inStream.close();

            result = strber.toString();

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK||httpResponse.getStatusLine().getStatusCode() == 201) {
                System.out.println("请求服务器成功，做相应处理");
            } else {
                System.out.println("请求服务器失败==="+result);
                result=httpResponse.getStatusLine().getStatusCode()+"";
                System.out.println("状态码====="+result);
            }
        } catch (Exception e) {
            System.out.println("请求异常");
            throw new RuntimeException(e);
        }

        return result;
    }
}