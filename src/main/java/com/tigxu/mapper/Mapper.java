package com.tigxu.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface Mapper {
    public List<Map<String,Object>> select(String sql);
    public Map<String,Object>   selectOne(String sql);
    public Integer  insert(String sql);
    public Integer  update(String sql);
}
