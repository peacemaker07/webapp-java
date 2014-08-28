package books.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BooksAction extends ActionSupport implements ModelDriven<BooksModel> {

	private static final long serialVersionUID = 1L;

	private BooksModel model = new BooksModel();

	@Override
	public BooksModel getModel() {
    	return model;
	}

	@Action(
		value = "/books",
		results = {
			@Result(name = "success", location = "booksResult1.jsp" )
		}
	)
	public String execute() throws Exception {
        return "success";
	}

	@Action(
		value = "/register",
		results = {
			@Result(name = "success", location = "booksRegister.jsp" )
		}
	)
	public String register() throws Exception {
        return "success";
	}

}
