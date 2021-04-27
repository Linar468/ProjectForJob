/**
 * Назначение cookies, конфигурация сервлета указана в web.xml
 */
package Cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("some_id", "123");
        cookie1.setMaxAge(24*60*60);
        response.addCookie(cookie1);

        Cookie cookie2 = new Cookie("some_name", "Tom");
        cookie2.setMaxAge(24*60*60);
        response.addCookie(cookie2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
