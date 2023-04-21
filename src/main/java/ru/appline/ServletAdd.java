package ru.appline;

import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/add")
public class ServletAdd {
    private AtomicInteger counter = new AtomicInteger(5);
    Model model = Model.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        User user = new User(name,surname,salary);
        model.add(user,counter.getAndIncrement());
        pw.print("<html>" + "<h1>Пользователь" + name + " "+ surname +" с зарплатой =" + salary + " успешно создан: :)</h3>"+
                "<a href=\"addUser.html\">Создать нового пользователя</a><br/>"
    + "<a href=\"index.jsp\">Домой</a>);" + "</html>");
    }

//    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
//        StringBuffer jb = new StringBuffer():
//        String line;
//        try {
//        BufferedReader reader = request.getReader();
//        while ((Line = reader.readline())) != null) {
//    jb.append(line);
//            }
//        } catch (Exception e){
//        System.out.println("Error");
//    }
//    JsonObject jObj = gson.fromJson(String.valueOf(jb), JsonObject.class);
//
//    request.setCharacterEncoding("UTF-8");
//
//    String name = jObj.get("name").getAsString();
//    String surname = jObj.get("surname").getAsString();
//    double salary = jObj.get("salary").getAsDouble();
//
//    User user = new User(name,surname,salary);
//    model.add(user, counter.getAndIncrement());
//
//    response.setContentType("application/json;charset=utf-8");
//    PrintWriter pw = response.getWriter();
//
//    pw.print(gson.toJson(model.getFromList()));
//    }
}
