package org.bravo.code.note.plus.action.org.bravo.code.note.plus.extension.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijian
 * @since 2021/10/25
 */
public class MyData {

    private String id;
    private String name;
    private Map<String, String> caches = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getCaches() {
        return caches;
    }

    public void setCaches(Map<String, String> caches) {
        this.caches = caches;
    }
}
