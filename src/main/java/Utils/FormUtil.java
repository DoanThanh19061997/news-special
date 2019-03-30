package Utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {
    // nhận về đối tg từ client cho server
    public static <T> T mapToModel(Class<T> tClass, HttpServletRequest request){
        T object = null;
        try {
            object = tClass.newInstance();
            BeanUtils.populate(object,request.getParameterMap());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

}
