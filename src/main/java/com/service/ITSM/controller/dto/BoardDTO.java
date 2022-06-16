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
         boardDTO.ID = board.getID();
         boardDTO.CLASSIFICATION = board.getCLASSIFICATION();
         boardDTO.CONTENT = board.getCONTENT();
         if(boardDTO.CREATE_DATE != "")
             boardDTO.CREATE_DATE = board.getCREATE_DATE();//.split(" ")[0];
         boardDTO.TITLE = board.getTITLE();
         boardDTO.NAME = board.getNAME();
         boardDTO.TYPE = board.getTYPE();
         return boardDTO;
    }
}
