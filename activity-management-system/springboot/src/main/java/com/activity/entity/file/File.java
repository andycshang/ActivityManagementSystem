package com.activity.entity.file;

import com.activity.entity.activity.Activity;
import lombok.Data;


@Data
public class File {
    private Integer id;
    private String name;
    private String storagePath;

    private FileType type;
    private Activity activity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialId=" + id +
                ", materialName='" + name + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", materialType=" + type +
                ", activity=" + activity +
                '}';
    }

}
