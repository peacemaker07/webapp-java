package part3;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;

@Validation
public class ResearchWithValidation extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private int age;
    private String career;

    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }

    @EmailValidator(message = "有効なメールアドレスを入力してください")
    public String getEmail(){ return this.email; }
    public void setEmail(String email){ this.email = email; }

    public int getAge(){ return this.age; }
    public void setAge(int age){ this.age = age; }

    public String getCareer(){ return this.career; }
    public void setCareer(String career){ this.career = career; }

    public String execute() throws Exception {
        return "success";
    }

    public void validate() {
        if ( name == null || name.length() == 0 ) {
            addActionError(getText("errors.required.name") );
        }
        if ( email==null || email.length() == 0 ) {
            addActionError("メールアドレスを入力してください");
        }
        if ( age < 18 || age > 99 ) {
            addActionError("18歳以上（99歳以下）の方が対象です");
        }
        if ( career == null ) {
            addActionError("キャリアを選択してください");
        }
    }

}