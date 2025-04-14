package com.app.threetier.service;

import com.app.threetier.domain.TaskVO;
import com.app.threetier.repository.TaskDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Override
    public void register(TaskVO taskVO) {
        taskDAO.save(taskVO);
    }

    @Override
    public List<TaskVO> getList() {
        return taskDAO.findAll();
    }

}
