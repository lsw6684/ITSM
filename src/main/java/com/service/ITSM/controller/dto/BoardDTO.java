package com.service.ITSM.controller.dto;

import com.service.ITSM.model.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private Long ID;
    private String TITLE;
    private String CLASSIFICATION;
    private String TYPE;
    private String NAME;
    private String CONTENT;
    private String CREATE_DATE;
    private String UPDATE_DATE;
    private String total;


    public static BoardDTO toDto(Board board){
         BoardDTO boardDTO = new BoardDTO();
         boardDTO.ID = board.getId();
         boardDTO.CLASSIFICATION = board.getClassification();
         boardDTO.CONTENT = board.getContent();
         if(board.getCreateDate() != null) boardDTO.CREATE_DATE = board.getCreateDate().toString().split("T")[0];
         boardDTO.TITLE = board.getTitle();
         boardDTO.NAME = board.getName();
         boardDTO.TYPE = board.getType();
         return boardDTO;
    }

    public Board of(Board board){
        board.setId(this.ID);
        board.setClassification(this.CLASSIFICATION);
        board.setTitle(this.getTITLE());
        board.setName(this.getNAME());
        board.setContent(this.getCONTENT());
        board.setType(this.getTYPE());
        return board;
    }
}
