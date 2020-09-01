package cmb.qmx.es.utils;



/**
 * @author 80273433
 */
public enum ResultEnum {

    NOT_NULL("000000", "Fields Null Error", "参数空值错误"),
    /**
     * RPC调用鉴权失败
     */
    RPC_AUTH_FAIL("100001", "rpc auth is fail", "远程调用鉴权失败"),
    /**
     * RPC调用网络错误
     */
    NETWORK_BAD("100002", "network is not no work", "网络异常"),
    /**
     * 路径编码错误
     */
    ENCODER_ERROR("100005", "encoder url error", "路径编码错误"),

    /*
     * 输入请求错误
     */
    REQUEST_BAD_TYPE_NULL("200000", "input request type null", "必填Type参数为空"),

    /*
     * 请求requestId重复
     */
    REQUEST_BAD_REQUESTID_REPEAT("200001", "request id error", "已有重复RequestId"),

    /*
     * 请求requestId重复
     */
    REQUEST_BAD_USERID_NULL("200002", "createUser Id is null", "createUserId为空"),

    /*
     * 必填parameter参数为空
     */
    REQUEST_BAD_PARAMETER_NULL("200003", "input request parameter null", "必填parameter参数为空"),

    /*
     * 必填az参数为空
     */
    REQUEST_BAD_AZ_NULL("200004", "input request az null", "必填az参数为空"),

    /*
     * 没有找到指定id的RpJob
     */
    NOT_FOUND_RPJOB("200005", "not find rpjob", "没有找到指定id的RpJob"),

    /**
     * 没有定义的错误
     */
    SYSTEM_ERROR("999999", "System Error", "系统错误"),
    ;

    private String code;

    private String msg;

    private String description;

    ResultEnum(String code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
