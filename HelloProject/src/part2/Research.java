package part2;
import com.opensymphony.xwork2.ActionSupport;

public class Research extends ActionSupport {

    private static final long serialVersionUID = 1L;

    // 入力フィールドに対応したメンバ変数
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

    // デフォルトのActionメソッド
    public String execute() throws Exception {
        return "success";
    }

    // submit時のActionメソッド
    public String confirm() throws Exception {
        return "success";
    }
}