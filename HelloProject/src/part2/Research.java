package part2;
import com.opensymphony.xwork2.ActionSupport;

public class Research extends ActionSupport {

    private static final long serialVersionUID = 1L;

    // ���̓t�B�[���h�ɑΉ����������o�ϐ�
    private String name;
    private String email;
    private int age;
    private String career;

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public int getAge(){ return age; }
    public void setAge(int age){ this.age = age; }

    public String getCareer(){ return career; }
    public void setCareer(String career){ this.career = career; }

    // �f�t�H���g��Action���\�b�h
    public String execute() throws Exception {
        return "success";
    }

    // submit����Action���\�b�h
    public String confirm() throws Exception {
        return "success";
    }
}