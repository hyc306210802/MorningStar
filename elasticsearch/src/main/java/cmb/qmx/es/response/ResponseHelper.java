package cmb.qmx.es.response;

import net.minidev.json.JSONObject;

/**
 * @author 80254142
 * @description
 * @date
 */
public class ResponseHelper {

    public static String getResponse(String msg, Object data) {
        JSONObject resp = new JSONObject();
        resp.put("msg", msg);
        resp.put("data", data);
        return resp.toJSONString();
    }

    public static String success(Object result) {
        if (result == null)
            return getResponse("the result is empty", "");
        return getResponse("success", result);
    }

    public static String failure(Object result) {
        if (result == null)
            return getResponse("the result is empty", "");
        return getResponse("failure", result);
    }
}
