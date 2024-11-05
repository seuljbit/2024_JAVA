package com.ezen.spring.handler;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.ezen.spring.dao.FileDAO;
import com.ezen.spring.domain.FileVO;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableScheduling
public class FileSweeper {
	// 직접 DB 접속해서 처리
	private final FileDAO fdao;
	private final String BASE_PATH = "D:\\_myProject\\_java\\_fileUpload\\";
	
	
	/* 매일 정해진 시간에 스케줄러를 실행
	 * 해당 일자의 폴더에 있는 파일과 DB에 등록된 파일을 비교
	 * 일치하는 파일은 유지하고, 일치하지 않는 파일은 삭제
	   -> DB에는 없는데, 폴더에 남아있는 파일이 있다면 삭제
	 * fileHandler - file.delete() - fileRemoveHandler 사용하여 삭제해도 무방함 */
	
	// 스케쥴 기록 cron : 초 분 시 일 월 요일 년도(생략가능)
	// (cron="59 59 23 * * *") : 매일 23시59분59초에 실행
	@Scheduled(cron="0 15 13 * * *")
	public void fileSweeper() {
		log.info(">>> FileSweeper Running Start~! : {}", LocalDateTime.now());
		
		// 처리
		
		// db에 등록된 모든 파일 목록 가져오기
		List<FileVO> dbList = fdao.selectListAllfile();
		// D:\\_myProject\\_java\\_fileUpload\\2024\\11\\04\\uuid_파일명
		// D:\\_myProject\\_java\\_fileUpload\\2024\\11\\04\\uuid_th_파일명 -> 이미지파일만
		
		// 파일 경로 + 파일명을 붙인 실제 존재해야하는 파일 리스트
		List<String> currFiles = new ArrayList<String>();
		
		for(FileVO fvo : dbList) {
			String filePath = fvo.getSaveDir() + File.separator + fvo.getUuid();
			String fileName = fvo.getFileName();
			currFiles.add(BASE_PATH + File.separator + filePath + File.separator + fileName);
			
			// 만약 이미지라면? 썸네일 경로 추가(이미지 파일 = 1)
			if(fvo.getFileType() > 0 ) {
				currFiles.add(BASE_PATH + File.separator + filePath + File.separator + "th_" + fileName);
			}
		}
		
		log.info(">>> currfile : {}", currFiles);
		
		// 실제 파일 경로를 설정
		LocalDate now = LocalDate.now();
		String today = now.toString();
		today = today.replace("-", File.separator);
		
		// 경로를 기반으로 저장되어있는 파일을 검색
		// D:\\_myProject\\_java\\_fileUpload\\2024\\11\\04
		File dir = Paths.get(BASE_PATH + today).toFile();
		
		// listFiles() : 경로 안에 있는 모든 파일을 배열로 리턴
		File[] allFileObject = dir.listFiles();
		
		// 실제 저장되어 있는 파일 목록과 DB의 존재 파일을 비교하여 DB에 없는 파일은 삭제 진행
		for(File file : allFileObject) {
			String storedFileName = file.toPath().toString();
			
			if(!currFiles.contains(storedFileName)) {
				file.delete(); // 파일 삭제
				log.info(">>> delete files : {}", storedFileName);
			}
		}
		
		
		log.info(">>> FileSweeper Running End~! : {}", LocalDateTime.now());
	}
	
}
