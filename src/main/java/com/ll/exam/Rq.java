package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
        // 들어오는 파라미터를 UTF-8로 해석
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
        resp.setCharacterEncoding("UTF-8");
        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
        resp.setContentType("text/html; charset=utf-8");
    }

    public int getIntParam(String paraName, int defalutValue) {
        String value = req.getParameter(paraName);

        if (value == null) {
            return defalutValue;
        }

        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e) {
            return defalutValue;
        }
    }

    public void appendBody(String formatted) {
        try {
            resp.getWriter().append(formatted);
        } catch (IOException e) {
            throw new RuntimeException(e);
            // 종료 (종료 안나게 하려면 이 throw문 지우면 됨)
        }
    }
}
