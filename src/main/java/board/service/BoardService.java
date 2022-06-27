package board.service;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;
import board.bean.BoardPaging;

public interface BoardService {

	public void boardWrite(Map<String, String> map);

	public List<BoardDTO> getBoardList(Map<String,Integer> map);

	public int getTotalA();

	public BoardPaging getBoardPaging(int page);
	
}
