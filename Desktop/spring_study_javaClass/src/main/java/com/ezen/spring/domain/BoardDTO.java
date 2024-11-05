package com.ezen.spring.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private BoardVO bvo;
	private List<FileVO> fileList;
	
	private boolean hasImageFile;  // 이미지 파일 여부
    private boolean hasNonImageFile;  // 일반 파일 여부

    // 기존 필드와 생성자, Getter, Setter에 새로운 필드를 추가
    public BoardDTO(BoardVO bvo, List<FileVO> fileList) {
        this.bvo = bvo;
        this.fileList = fileList;

        // 파일 리스트에서 이미지와 일반 파일 여부 설정
        if (fileList != null) {
            for (FileVO file : fileList) {
                if (file.getFileType() == 1) {
                    this.hasImageFile = true;
                } else {
                    this.hasNonImageFile = true;
                }
            }
        }
    }
}
