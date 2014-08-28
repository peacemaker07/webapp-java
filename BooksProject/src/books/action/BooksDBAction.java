package books.action;

import java.sql.SQLException;
import java.util.List;

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
public class BooksDBAction extends ActionSupport implements ScopedModelDriven<BooksModel> {

	private static final long serialVersionUID = 1L;

	private BooksModel model;	// 本情報のModelクラス
	private String scopeKey;	// セッションでのModelオブジェクト識別キー
	List<BooksModel> books;		// 登録した本情報の一時格納用
	private String message;		// データベース例外メッセージ表示用

	@Action(
		value = "/booksDB",
		results = {
			@Result(name = "success", location = "booksResult3.jsp" )
		}
	)
	public String execute() throws Exception {
        return "success";
	}

	@Action(
		value = "/registerDB",
		results = {
			@Result(name = "success", location = "booksRegisterDB.jsp" )
		}
	)
	public String register() throws Exception {

		try{
			// DAOオブジェクトの生成
			BooksDAO dao = new BooksDAO();

			// 入力値のデータベース登録
			dao.register(model.getIsbn(), model.getTitle(), model.getAuthor());

			// データベースから全登録データを取得
			books = dao.getAll();
		}
		catch(SQLException e) {
			setMessage(e.getMessage());
		}
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

	public String getMessage() {
	    return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}

	public List<BooksModel> getBooks() {
	    return this.books;
	}

}
