package cmb.qmx.es.utils;


import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


/**
 * @author 80273433
 */
public class ResData {

    private ResData() {
    }

    public static ResponseEntity success(Object body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }

    public static ResponseEntity success(MultiValueMap<String, String> headers, HttpStatus status) {
        return new ResponseEntity<>(headers, status);
    }

    public static ResponseEntity success(HttpStatus status) {
        return new ResponseEntity<>(Maps.newHashMap(), status);
    }

    public static ResponseEntity success() {
        return new ResponseEntity<>(Maps.newHashMap(), HttpStatus.OK);
    }

    public static ResponseEntity error(ErrorResp errorResp, HttpStatus status) {
        return new ResponseEntity<>(errorResp, status);
    }
}
