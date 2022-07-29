package com.thread.scheduled.mappers;

import com.thread.scheduled.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVO> selectList();

    List<BoardVO> getAllBoard();


    void createBoardData(BoardVO boardVO);
}
