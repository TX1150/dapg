package com.tigxu.tool;

import com.tigxu.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Supper {
    @Autowired(required = true)
    protected Mapper              mapper;
    @Autowired(required = true)
    protected ResourceOperation resource;

}
