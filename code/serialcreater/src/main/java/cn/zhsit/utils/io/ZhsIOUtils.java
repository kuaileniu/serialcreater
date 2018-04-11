package cn.zhsit.utils.io;

import cn.zhsit.utils.ZhsJsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 冯先生
 * 61947666@qq.com
 * 15652963646
 */
public class ZhsIOUtils {

    public static void writeJsonAndClose(HttpServletResponse resp, Object obj) {
        try {
            resp.setCharacterEncoding("UTF-8");
//            use browser
//            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print(ZhsJsonUtil.toJson(obj));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resp.getWriter().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
