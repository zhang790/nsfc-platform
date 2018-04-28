package com.nsfc.platform.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义属性读取
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/4/19
 */
@Component
public class SelfProperties {

    @Value("${com.nsfc.self.name}")
    private String authorName;

    @Value("${com.nsfc.auto.info}")
    private String authorPhone;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPhone() {
        return authorPhone;
    }

    public void setAuthorPhone(String authorPhone) {
        this.authorPhone = authorPhone;
    }

    @Override
    public String toString() {
        return "SelfProperties{" +
                "authorName='" + authorName + '\'' +
                ", authorPhone='" + authorPhone + '\'' +
                '}';
    }
}
