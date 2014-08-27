package part5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Servlet implementation class ViewSample
 */
public class ViewSample{

	// �`�F�b�N�{�b�N�X�p
	private ArrayList<Integer> items1;
	private ArrayList<String> items2;

	// �_�E�����[�h�p
	private InputStream inputStream;

	// �_�E�����[�h�̕����\���t���O
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
    
    // �_�E�����[�h����
	public String download() {
	    String tmp = "���C����...";
	    this.inputStream = new ByteArrayInputStream(tmp.getBytes());
	    return "success";
	}

	public String submit() {

	    setDownok(false);

	    try {
	        // ���C�������邩�ǂ���
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
