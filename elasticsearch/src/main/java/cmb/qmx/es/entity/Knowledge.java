package cmb.qmx.es.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Knowledge {
    private String name;
    private String content;
    private String createuser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "GMT+8")
    private Date createitme;

    public Knowledge(String name, String content, String createuser, Date createitme) {
        this.name = name;
        this.content = content;
        this.createuser = createuser;
        this.createitme = createitme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getCreateime() {
        return createitme;
    }

    public void setCreateime(Date createime) {
        this.createitme = createime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatuser() {
        return createuser;
    }

    public void setCreatuser(String creatuser) {
        this.createuser = creatuser;
    }
}
