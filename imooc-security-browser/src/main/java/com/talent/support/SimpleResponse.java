package com.talent.support;

import java.io.Serializable;

/**
 * @author guobing
 * @Title: SimpleResponse
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/2/13下午2:56
 */
public class SimpleResponse implements Serializable {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
