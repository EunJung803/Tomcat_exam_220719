package com.ll.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        int dan = rq.getIntParam("dan", 9);
        int limit = rq.getIntParam("limit", 9);

        // request에 정보를 담기
        // 이유 : 나중에 gugudan2.jsp에서 해당 내용을 꺼낼 수 있기 때문에 담아준다.
        // 즉, gugudan2.jsp에서 위에 선언한 dan, limit 변수를 사용할 수 있게 해줘야 하기 때문!
        req.setAttribute("dan", dan);
        req.setAttribute("limit", limit);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp"); // 이게 토스해주는 역할, 내가 여기까지 했으니까 너가 나머지 해 !
        requestDispatcher.forward(req, resp);

    }
}

