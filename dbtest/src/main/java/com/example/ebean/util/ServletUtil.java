package com.example.ebean.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet工具类
 *
 * @author christ
 * @date 2015/11/2
 */
public class ServletUtil extends jodd.servlet.ServletUtil {


    /**
     * 获得当前请求线程对应的HttpServletRequest
     *
     * @return
     */
    public static HttpServletRequest getCurrentRequest() {

        return RequestContextHolder.getRequestAttributes() == null
                ? null
                : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获得当前请求线程对应的HttpServletResponse
     *
     * @return
     */
    public static HttpServletResponse getCurrentResponse() {

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获得request
     *
     * @param request
     * @return
     */
    public static HttpServletRequest getRequest(ServletRequest request) {

        return (HttpServletRequest) request;
    }

    /**
     * 获得response
     *
     * @param response
     * @return
     */
    public static HttpServletResponse getResponse(ServletResponse response) {

        return (HttpServletResponse) response;
    }

    /**
     * 获得服务端ip地址
     *
     * @return
     */
    public static String getLocalAddr() {

        return getLocalAddr(getCurrentRequest());
    }

    /**
     * 获得服务端ip地址
     *
     * @param request
     * @return
     */
    public static String getLocalAddr(ServletRequest request) {

        return request.getLocalAddr();
    }

    /**
     * 获得请求路径
     *
     * @return
     */
    public static String getRequestURI() {

        return getRequestURI(getCurrentRequest());
    }

    /**
     * 获得请求路径
     *
     * @param request
     * @return
     */
    public static String getRequestURI(ServletRequest request) {

        return getRequest(request).getRequestURI();
    }

    /**
     * 获得method
     *
     * @return
     */
    public static String getMethod() {

        return getMethod(getCurrentRequest());
    }

    /**
     * 获得method
     *
     * @param request
     * @return
     */
    public static String getMethod(ServletRequest request) {

        return getRequest(request).getMethod();
    }

    /**
     * 获得cookie
     *
     * @return
     */
    public static Cookie[] getCookies() {

        return getCookies(getCurrentRequest());
    }

    /**
     * 获得cookie
     *
     * @param request
     * @return
     */
    public static Cookie[] getCookies(ServletRequest request) {

        return getRequest(request).getCookies();
    }

    /**
     * 获得查询参数
     *
     * @return
     */
    public static String getQueryString() {

        return getQueryString(getCurrentRequest());
    }

    /**
     * 获得查询参数
     *
     * @param request
     * @return
     */
    public static String getQueryString(ServletRequest request) {

        return getRequest(request).getQueryString();
    }

    /**
     * 设置头信息
     *
     * @param name
     * @param value
     */
    public static void setHeader(String name, String value) {

        getCurrentResponse().setHeader(name, value);
    }

    /**
     * 设置头信息
     *
     * @param response
     * @param name
     * @param value
     */
    public static void setHeader(ServletResponse response, String name, String value) {

        getResponse(response).setHeader(name, value);
    }


    /**
     * 获得头部信息
     *
     * @param name
     * @return
     */
    public static String getHeader(String name) {

        return getHeader(getCurrentRequest(), name);
    }

    /**
     * 获得头部信息
     *
     * @param request
     * @param name
     * @return
     */
    public static String getHeader(ServletRequest request, String name) {

        return getRequest(request).getHeader(name);
    }

    /**
     * redirect
     *
     * @param url
     */
    public static void redirect(String url) {

        redirect(getCurrentRequest(), getCurrentResponse(), url);
    }

    /**
     * redirect
     *
     * @param request
     * @param response
     * @param url
     */
    public static void redirect(ServletRequest request, ServletResponse response, String url) {

        try {

            getResponse(response).sendRedirect(getRequest(request).getContextPath() + url);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * 获得当前请求的ip
     *
     * @return
     */
    public static String getClientIP() {

        return getClientIP(getCurrentRequest());
    }

    public static String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (isUnknownIP(ip)) {
            ip = request.getHeader("X-Cluster-Client-IP");
        }

        if (isUnknownIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (isUnknownIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (isUnknownIP(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (isUnknownIP(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (isUnknownIP(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip.length() > 15) {
            String[] ips = ip.split(",");

            for (int index = 0; index < ips.length; ++index) {
                String strIp = ips[index];
                if (!"unknown".equalsIgnoreCase(strIp)) {
                    ip = strIp;
                    break;
                }
            }
        }

        return ip;
    }

    private static boolean isUnknownIP(String ip) {
        return ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip);
    }

    /**
     * 返回json内容
     *
     * @param json
     * @throws IOException
     */
    public static void jsonOut(Object json) throws IOException {

        jsonOut(getCurrentResponse(), json);
    }

    /**
     * 返回json内容
     *
     * @param response
     * @param json
     * @throws IOException
     */
    public static void jsonOut(ServletResponse response, Object json) throws IOException {

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONUtil.serialize(json));
        response.flushBuffer();
    }

    /**
     * 获取body部分
     *
     * @param request
     * @return
     */
    public static String readRequestBody(ServletRequest request) {
        try {
            return readRequestBody((HttpServletRequest) request);
        } catch (IOException e) {
            return null;
        }
    }
}
