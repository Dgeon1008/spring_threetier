package com.app.threetier.service;

import com.app.threetier.domain.TaskVO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public void register(TaskVO taskVO);

    public List<TaskVO> getList();

}
