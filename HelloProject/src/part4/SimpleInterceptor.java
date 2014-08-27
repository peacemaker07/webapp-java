package part4;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SimpleInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    // �C���^�[�Z�v�^�[�̏����i�R���\�[���ɕ�������o�͂���j
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println("intercept����");

        // ���̃C���^�[�Z�v�^�[����
        String result_code = invocation.invoke();

        // Result��̃C���^�[�Z�v�^�[����
        System.out.println("intercept����2");

        return result_code;
    }
}
