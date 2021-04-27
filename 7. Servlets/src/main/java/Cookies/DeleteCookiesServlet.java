/**
 * Удаление cookies, конфигурация сервлета указана в web.xml
 */
package Cookies;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("some_id", "");
        cookie.setMaxAge(0);
        //cookie.setMaxAge(-1); - удалить куки после закрытия

        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
