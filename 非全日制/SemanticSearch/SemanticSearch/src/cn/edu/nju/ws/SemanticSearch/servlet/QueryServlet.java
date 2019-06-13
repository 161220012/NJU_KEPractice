package cn.edu.nju.ws.SemanticSearch.servlet;

import cn.edu.nju.ws.SemanticSearch.service.QueryExecutor;
import virtuoso.jena.driver.VirtGraph;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "/QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // ������Virtuoso���ݿ�����ӣ���Ҫ����ʵ�ʵ����ݿ����ý����޸�
        VirtGraph g = new VirtGraph("http://YAGO.org", "jdbc:virtuoso:0.0.0.0:1111", "dba", "dba");

        // ��Ҫ��HTTP��������е�query�������н����õ��ؼ����б�
        List<String> keywords = new ArrayList<>();
        keywords.add(request.getParameter("query"));

        // ִ�о��������
        QueryExecutor executor = new QueryExecutor(g, keywords, new ArrayList<String>());
        response.setContentType("text/json; charset=UTF-8");
        response.getWriter().print(JSON.toJSON(executor.query()));
    }
}
