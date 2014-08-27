package part4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {

	    // HttpServletRequest�AHttpSession�̎擾
	    HttpServletRequest request = ServletActionContext.getRequest();
	    HttpSession session = ServletActionContext.getRequest().getSession();

	    // (1) ���O�C�����Ă���΁A���̃C���^�[�Z�v�^�[��
	    if ( session.getAttribute("userid") != null &&
	            session.getAttribute("userid").equals("part4") ){
	        return invocation.invoke();
	    }

	    // (2) ���N�G�X�g�p�����[�^�[��userid��password���擾
	    String userid = request.getParameter("userid");
	    String passwd = request.getParameter("password");

	    System.out.println(userid);
	    System.out.println(passwd);

	    if ( userid != null && passwd != null &&
	            userid.equals("part4")  && passwd.equals("wings") ) {

	        // (3) �V���ȃZ�b�V������userid��ݒ肷��
	        ServletActionContext.getRequest().getSession(true).invalidate();
	        HttpSession newsession = ServletActionContext.getRequest().getSession(true);
	        newsession.setAttribute("userid", userid );
	        return "login-success";
	    }
	    return "login";
	}
}
