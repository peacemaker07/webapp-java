package part4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {

	    // HttpServletRequest、HttpSessionの取得
	    HttpServletRequest request = ServletActionContext.getRequest();
	    HttpSession session = ServletActionContext.getRequest().getSession();

	    // (1) ログインしていれば、次のインターセプターへ
	    if ( session.getAttribute("userid") != null &&
	            session.getAttribute("userid").equals("part4") ){
	        return invocation.invoke();
	    }

	    // (2) リクエストパラメーターのuseridとpasswordを取得
	    String userid = request.getParameter("userid");
	    String passwd = request.getParameter("password");

	    System.out.println(userid);
	    System.out.println(passwd);

	    if ( userid != null && passwd != null &&
	            userid.equals("part4")  && passwd.equals("wings") ) {

	        // (3) 新たなセッションにuseridを設定する
	        ServletActionContext.getRequest().getSession(true).invalidate();
	        HttpSession newsession = ServletActionContext.getRequest().getSession(true);
	        newsession.setAttribute("userid", userid );
	        return "login-success";
	    }
	    return "login";
	}
}
