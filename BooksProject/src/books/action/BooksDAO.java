package books.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.java.ao.EntityManager;

public class BooksDAO {

	private static EntityManager manager;

	public BooksDAO(){
		manager =
			new EntityManager("jdbc:mysql://localhost/books", "root", "test");
	}

	// 登録
	public void register(String isbn, String title, String author ) throws SQLException{

		Books book = manager.create(Books.class);

		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAuthor(author);
		book.save();
	}

	// 全データ取得
	public List<BooksModel> getAll() throws SQLException{

		List<BooksModel> b = new ArrayList<BooksModel>();
		Books[] books = manager.find(Books.class);
		for (Books element : books) {
			BooksModel tmp = new BooksModel();
			tmp.setIsbn(element.getIsbn());
			tmp.setTitleNoencode(element.getTitle());
			tmp.setAuthorNoencode(element.getAuthor());
			b.add(tmp);
		}
		return b;
	}
}
