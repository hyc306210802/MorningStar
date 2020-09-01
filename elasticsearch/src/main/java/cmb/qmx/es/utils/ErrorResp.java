package cmb.qmx.es.utils;

/**
 * @author 80273433
 * @date 2020-3-26 09:22:50
 */
public class ErrorResp {
    private String errorCode;
    private String errorMsg;
    private String description;
    private Object result;

    public ErrorResp(String errorCode, String errorMsg, String description) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.description = description;
    }

    public ErrorResp(ResultEnum result) {
        this.errorCode = result.getCode();
        this.errorMsg = result.getMsg();
        this.description = result.getDescription();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ErrorResp{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", description='" + description + '\'' +
                ", result=" + result +
                '}';
    }
}
