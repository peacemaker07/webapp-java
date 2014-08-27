package part5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Servlet implementation class ViewSample
 */
public class ViewSample{

	// チェックボックス用
	private ArrayList<Integer> items1;
	private ArrayList<String> items2;

	// ダウンロード用
	private InputStream inputStream;

	// ダウンロードの文字表示フラグ
	private boolean downok;
	
	// setter,getter
	public ArrayList<Integer> getItems1(){ return this.items1; }
	public void setItems1(ArrayList<Integer> items1){ this.items1 = items1; }
	
	public ArrayList<String> getItems2(){ return this.items2; }
	public void setItems2(ArrayList<String> items2){ this.items2 = items2; }

	public boolean getDownok(){ return this.downok; }
	public void setDownok(boolean downok){ this.downok = downok; }

    private static final long serialVersionUID = 1L;

    public String execute() throws Exception {
        return "success";
    }
    
    // ダウンロード処理
	public String download() {
	    String tmp = "ワインは...";
	    this.inputStream = new ByteArrayInputStream(tmp.getBytes());
	    return "success";
	}

	public String submit() {

	    setDownok(false);

	    try {
	        // ワインがあるかどうか
	        for ( Integer i : this.items1 ) {
	            if ( i == 3 ) {
	                setDownok(true);
	                break;
	            }
	        }
	    }
	    catch(Exception e){
	    }

	    return "success";
	}
}
