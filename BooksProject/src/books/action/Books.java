package books.action;

import net.java.ao.Entity;

public interface Books extends Entity {
    public String getIsbn();
	public void setIsbn(String isbn);
	public String getTitle();
	public void setTitle(String title);
	public String getAuthor();
	public void setAuthor(String author);
}
