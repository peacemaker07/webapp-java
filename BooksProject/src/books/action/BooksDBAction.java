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

	private BooksModel model;	// �{����Model�N���X
	private String scopeKey;	// �Z�b�V�����ł�Model�I�u�W�F�N�g���ʃL�[
	List<BooksModel> books;		// �o�^�����{���̈ꎞ�i�[�p
	private String message;		// �f�[�^�x�[�X��O���b�Z�[�W�\���p

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
			// DAO�I�u�W�F�N�g�̐���
			BooksDAO dao = new BooksDAO();

			// ���͒l�̃f�[�^�x�[�X�o�^
			dao.register(model.getIsbn(), model.getTitle(), model.getAuthor());

			// �f�[�^�x�[�X����S�o�^�f�[�^���擾
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
