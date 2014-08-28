package books.action;

public class BooksModel {
	private String isbn;
	private String title;
	private String author;

	public void setBooksModel(BooksModel model) {
		this.isbn = model.getIsbn();
		this.title = model.getTitle();
		this.author = model.getAuthor();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = FixString.encoding(title);
	}

	public void setTitleNoencode(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = FixString.encoding(author);
	}

	public void setAuthorNoencode(String author) {
		this.author = author;
	}

}
