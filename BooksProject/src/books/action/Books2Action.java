package books.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ScopedModelDriven;

@InterceptorRefs({
	@InterceptorRef(value="scopedModelDriven",params={"scope","session"}),
	@InterceptorRef("defaultStack")
})
public class Books2Action extends ActionSupport implements ScopedModelDriven<BooksModel> {

	private static final long serialVersionUID = 1L;

	private BooksModel model;
	private String scopeKey;

	@Action(
		value = "/books2",
		results = {
			@Result(name = "success", location = "booksResult2.jsp" )
		}
	)
	public String execute() throws Exception {
        return "success";
	}

	@Action(
		value = "/register2",
		results = {
			@Result(name = "success", location = "booksRegister.jsp" )
		}
	)
	public String register() throws Exception {
        return "success";
	}

	@Override
	public BooksModel getModel() {
    	return model;
	}

	@Override
	public void setModel(BooksModel model) {
	    this.model = model;
	}

	@Override
	public String getScopeKey() {
		return this.scopeKey;
	}

	@Override
	public void setScopeKey(String key) {
	    this.scopeKey = key;
	}
}
