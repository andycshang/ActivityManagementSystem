package com.activity.mapper.file;

import com.activity.entity.file.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface FileMapper {
    @Select("SELECT stroage_path FROM file WHERE file_id = #{fileId} LIMIT 1;")
    String selectStoragePathById(@Param("fileId") Integer fileId);

}
