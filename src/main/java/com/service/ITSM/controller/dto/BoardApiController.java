package com.service.ITSM.controller.dto;

import com.service.ITSM.model.Board;
import com.service.ITSM.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class BoardApiController {

    @Autowired
    private BoardRepository repository;


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/boards")
    List<Board> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/boards")
    Board newBoard(@RequestBody Board newBoard) {
        return repository.save(newBoard);
    }

    // Single item

    @GetMapping("/boards/{ID}")
    Board one(@PathVariable Long ID) {

        return repository.findById(ID).orElse(null);
    }

    @PutMapping("/boards/{ID}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long ID) {

        return repository.findById(ID)
                .map(board -> {
                    board.setId(newBoard.getId());
                    board.setClassification(newBoard.getClassification());
                    board.setTitle(newBoard.getTitle());
                    board.setName(newBoard.getName());
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return repository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setId(ID);
                    return repository.save(newBoard);
                });
    }

    @DeleteMapping("/boards/{ID}")
    void deleteBoard(@PathVariable Long ID) {
        repository.deleteById(ID);
    }
}