package com.app.threetier.repository;

import com.app.threetier.domain.TaskVO;
import com.app.threetier.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskDAO {

    private final TaskMapper taskMapper;

    public void save(TaskVO taskVO) {
        taskMapper.insert(taskVO);
    }

    public List<TaskVO> findAll() {
        return taskMapper.selectAll();
    }

}
