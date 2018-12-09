package com.infoshareacademy.web;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = "/infoShareAcademy")
public class infoShareAcademyServlet extends HttpServlet {

    @Inject
    private com.infoshareacademy.freemarker.TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Map<String, Object> model = new HashMap<>();

        model.put("name", "Michal");
        model.put("lastName", "Kostyk");
        model.put("team", "jjdd5-niewiem");
        model.put("date", LocalDateTime.now());

        Template template = templateProvider.getTemplate(getServletContext(), "isaGET");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> model = new HashMap<>();

        model.put("query", req.getParameterMap());

        Template template = templateProvider.getTemplate(getServletContext(), "isaPOST");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}

