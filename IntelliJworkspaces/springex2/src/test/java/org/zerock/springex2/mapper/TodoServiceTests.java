package org.zerock.springex2.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex2.dto.PageRequestDTO;
import org.zerock.springex2.dto.PageResponseDTO;
import org.zerock.springex2.dto.TodoDTO;
import org.zerock.springex2.service.TodoService;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void testResgister() {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("Test.......")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();

        log.info(todoDTO);

        todoService.register(todoDTO);

    }


    @Test
    public void testPaging() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);

        log.info(responseDTO);

        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));

    }

}
