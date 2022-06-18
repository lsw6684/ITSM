package com.service.ITSM.controller.dto;

import com.service.ITSM.model.Board;
import com.service.ITSM.repository.BoardRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class BoardController {

    private final BoardRepository repository;

    BoardController(BoardRepository repository) {
        this.repository = repository;
    }


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

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));
    }

    @PutMapping("/boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

        return repository.findById(id)
                .map(board -> {
                    board.setID(newBoard.getID());
                    board.setC(newBoard.getRole());
                    return repository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setID(id);
                    return repository.save(newBoard);
                });
    }

    @DeleteMapping("/boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}