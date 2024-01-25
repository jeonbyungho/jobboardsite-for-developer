package com.jobboard.recruit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecruitBullWriteService {
	private static RecruitBullWriteService instance;
	
	private RecruitBullWriteService() {}
	
	public static RecruitBullWriteService getInstance() {
		if(instance == null) {
			instance = new RecruitBullWriteService();
		}
		return instance;
	}
	
	public void storePhoto(InputStream inputStream, String photoPath, String fileName) throws IOException {
		log.info(photoPath);
		File path = new File(photoPath);
		if (!path.exists()) {
			path.mkdirs();
			log.info("이미지 저장용 디렉토리 생성");
		}
		FileOutputStream outputStream = new FileOutputStream(path + "/" + fileName + ".jpeg");
		int size = 0;
		byte[] buf = new byte[1024];
		while ((size = inputStream.read(buf)) != -1) {
			outputStream.write(buf, 0, size);
		}
		outputStream.close();
		inputStream.close();
	}
	
	public void write(String title, String content) {
		log.info(title + "\n "+content);
	}
}
