package com.ezen.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.spring.dao.BoardDAO;
import com.ezen.spring.dao.FileDAO;
import com.ezen.spring.domain.BoardDTO;
import com.ezen.spring.domain.BoardVO;
import com.ezen.spring.domain.FileVO;
import com.ezen.spring.domain.PagingVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardDAO bdao;
    private final FileDAO fdao;

    // 게시글과 파일 정보 삽입
    @Transactional
    @Override
    public int insert(BoardDTO bdto) {
        // 게시글 등록
        int isOk = bdao.insert(bdto.getBvo());

        if (isOk > 0 && bdto.getFileList() != null && !bdto.getFileList().isEmpty()) {
            long bno = bdao.getOneBno(); // 가장 최근에 추가된 게시글 번호 가져오기
            for (FileVO fvo : bdto.getFileList()) {
                fvo.setBno(bno);
                isOk *= fdao.insertFile(fvo); // 파일 정보 삽입
            }
        }
        return isOk;
    }

    // 게시글 목록 조회
    @Override
    public List<BoardDTO> getList(PagingVO pgvo) {
        List<BoardVO> boardList = bdao.getList(pgvo);
        List<BoardDTO> dtoList = new ArrayList<>();

        for (BoardVO bvo : boardList) {
            List<FileVO> fileList = fdao.getFilesByBno(bvo.getBno()); // 게시글에 연결된 파일 목록 조회
            dtoList.add(new BoardDTO(bvo, fileList));
        }
        return dtoList;
    }

    // 게시글 상세 조회
    @Transactional
	@Override
	public BoardDTO getDetail(long bno) {
		// bdao > bvo   / fdao > fvo  묶어서 BoardDTO 로 리턴
		BoardVO bvo = bdao.getDetail(bno);
		List<FileVO> flist = fdao.getList(bno);
		
		BoardDTO bdto = new BoardDTO(bvo, flist);
		
		return bdto;
	}

    // 게시글과 파일 정보 수정
    @Transactional
    @Override
    public int modify(BoardDTO boardDTO) {
        int isOk = bdao.update(boardDTO.getBvo());
        
        if (isOk > 0 && boardDTO.getFileList() != null && !boardDTO.getFileList().isEmpty()) {
            for (FileVO fvo : boardDTO.getFileList()) {
                fvo.setBno(boardDTO.getBvo().getBno());
                isOk *= fdao.insertFile(fvo); // 파일 정보 삽입
            }
        }
        return isOk;
    }

    // 게시글 삭제
    @Transactional
    @Override
    public int delete(int bno) {
        return bdao.delete(bno);
    }

    // 게시글 총 개수 조회
    @Override
    public int getTotal(PagingVO pgvo) {
        return bdao.getTotal(pgvo);
    }

    // 파일 삭제
    @Override
    public int removeFile(String uuid) {
        return fdao.removeFile(uuid);
    }

	@Override
	public int readCountUp(long bno) {
		return bdao.incrementReadCount(bno); 
	}
}