package com.service.ITSM.controller;

import com.service.ITSM.controller.dto.BoardDTO;
import com.service.ITSM.model.Board;
import com.service.ITSM.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long ID) {  // required : 필수인지 아닌지

        if(ID == null)
            model.addAttribute("board", new Board());
        else {
            Board board = boardRepository.findById(ID).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@Valid Board board, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "board/form";

        boardRepository.save(board);
        return "redirect:/board/list";
    }

}
