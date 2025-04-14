package com.app.threetier.mapper;

import com.app.threetier.domain.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void insertTest() {
        TaskVO taskVO = new TaskVO();
        taskVO.setTaskKor(30);
        taskVO.setTaskEng(80);
        taskVO.setTaskMath(25);

        taskMapper.insert(taskVO);
    }

    @Test
    public void selectAllTest() {
        List<TaskVO> tasks = taskMapper.selectAll();
        tasks.stream().map(TaskVO::toString).forEach(log::info);
    }



}
