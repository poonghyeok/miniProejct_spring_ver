package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import board.bean.BoardDTO;

@Transactional
@Repository
public class BoardDAOImplMyBatis implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void boardWrite( Map<String,String> map ) {
		sqlSession.update("boardSQL.boardWrite", map);
		
	}
	
	@Override
	public List<BoardDTO> getBoardList(Map<String,Integer> map) {
		List<BoardDTO>list = sqlSession.selectList("boardSQL.getBoardRange", map);
		
		return list;
	}
	
	@Override
	public int getTotalA() {
	
		return (Integer)sqlSession.selectOne("boardSQL.getTotalBoardNum");
	}
}
