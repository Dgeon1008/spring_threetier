package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.TaskVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {

    public void insert(TaskVO taskVO);

    public List<TaskVO> selectAll();
}
