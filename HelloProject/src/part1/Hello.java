package part1;

public class Hello {

    private String replyMsg;

    public String getReplyMsg() {
        return replyMsg;
    }

    public void setReplyMsg(String message) {
        this.replyMsg = message;
    }

    public String execute() throws Exception {
        this.setReplyMsg( "Struts 2ÇÃê¢äEÇ÷ÇÊÇ§Ç±Çª" );
        return "success";
    }
}