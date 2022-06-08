package com.service.ITSM.controller;

import com.service.ITSM.controller.dto.BoardDTO;
import com.service.ITSM.model.Board;
import com.service.ITSM.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> boards = boardRepository.findAll()
                .stream().map(b->BoardDTO.toDto(b)).toList();
        model.addAttribute("boards", boards);
        return "board/list";
    }
}