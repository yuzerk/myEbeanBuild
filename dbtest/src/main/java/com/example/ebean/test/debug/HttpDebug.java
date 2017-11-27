package com.example.ebean.test.debug;

import com.example.ebean.common.basic.BaseProsessor;
import com.example.ebean.util.StringUtil;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuzk
 * @date 2017/11/25
 */
public class HttpDebug extends BaseProsessor{

    private String defaultHost = "127.0.0.1";
    private Integer defaultport = 8080;
    private MediaType defaultType = MediaType.APPLICATION_JSON_UTF8;
    private HttpHeaders headers;
    private HttpEntity<Object> entity;
    private HttpMethod method;
    private Map<String,Object> params;
    private String url;

    public static final RestTemplate template = new RestTemplate();

    //====================== set method ========================
    public HttpDebug setPort(Integer defaultport) {
        this.defaultport = defaultport;
        return this;
    }

    public HttpDebug setHost(String host) {
        if(!(StringUtil.isIPAddress(host) || host.equals("localhost"))) {
            System.out.println("Ip address format error");
            return this;
        }
        this.defaultHost = host;
        return this;
    }

    public HttpDebug setType(MediaType type) {
        this.defaultType = type;
        return this;
    }

    public HttpDebug setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public HttpDebug setEntity(Object body) {

        if(isEmpty(headers)) {
            defaultHeaders();
        }
        entity = new HttpEntity<>(body,headers);
        return this;
    }

    public HttpDebug setUrl(String url) {
        this.url = spliceUrl(url);
        return this;
    }
    //=========================  default property ==============================

    private HttpDebug defaultHeaders() {
        if(isEmpty(headers)) {
            headers = new HttpHeaders();
        }
        headers.setContentType(defaultType);
        return this;
    }

    private HttpDebug defaultEntity() {
        if(isEmpty(entity)) {
            entity = new HttpEntity<>(headers);
        }
        return this;
    }

    private HttpDebug defaultMethod() {
        if(isEmpty(method)) {
            method = HttpMethod.GET;
        }
        return this;
    }

    //====================   param get =======================
    public HttpDebug addParam(String name, Object value) {
        if (isEmpty(params)) {
            params = new HashMap<>();
        }
        params.put(name, value);
        return this;
    }

    /**
     * the send method
     * @return
     */
    public ResponseEntity<Object> send(Class<?> clazz) {
        if(isEmpty(headers)) {
            defaultHeaders();
        }
        if(isEmpty(entity)) {
            defaultEntity();
        }
        if(isEmpty(method)) {
            defaultMethod();
        }
        ResponseEntity response = null;
        try{
            if(method.equals(HttpMethod.GET)) {
                generateGetUrlWithParams();
                response = template.exchange(url,method,entity,clazz);
            }
            if(method.equals(HttpMethod.POST)) {
                response = template.exchange(url,method,entity,clazz);
            }
        }catch (Exception e) {
            //TODO 弹出http请求失败的异常
        }finally {
            if(isNotEmpty(params)) {
                params.clear();
            }
        }
        return response;
    }

    private String spliceUrl(String path) {
        path = path.trim();
        if(!path.startsWith("/")) {
            path = "/" + path;
        }
        path = "http://" + defaultHost + ":" + defaultport + path;
        if(StringUtil.isUrl(path)){
            //TODO 弹出url格式不对的异常
        }
        return path;
    }

    private void generateGetUrlWithParams() {
        if(isEmpty(params)) {
            return;
        }
        url += "?";
        for(String key : params.keySet()) {
            url += (key + "=" + params.get(key) + "&");
        }
    }
}
