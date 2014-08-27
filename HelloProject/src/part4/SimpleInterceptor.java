package part4;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SimpleInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    // インターセプターの処理（コンソールに文字列を出力する）
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println("intercept処理");

        // 次のインターセプター処理
        String result_code = invocation.invoke();

        // Result後のインターセプター処理
        System.out.println("intercept処理2");

        return result_code;
    }
}
