package board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void boardWrite(Map<String, String> map) {
		
		boardDAO.boardWrite(map);
		
		return;
	}
	
	@Override
	public List<BoardDTO> getBoardList(Map<String,Integer> map) {
	
		return boardDAO.getBoardList(map);
	}
		
	@Override
	public int getTotalA() {
		
		return boardDAO.getTotalA();
	}
	
	@Override
	public BoardPaging getBoardPaging(int page) {
		
		int totalA = getTotalA();
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(page);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		return boardPaging;
	}
	
	
}
