package books.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class FixString {

	static public String encoding(String str) {
    	try {
            HttpServletRequest request = ServletActionContext.getRequest();
            return new String(str.getBytes("iso-8859-1"),
                        request.getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

}
