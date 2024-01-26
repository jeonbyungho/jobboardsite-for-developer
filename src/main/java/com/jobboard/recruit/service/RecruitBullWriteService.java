package com.jobboard.recruit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.jobboard.recruit.dao.RecruitBullDao;
import com.jobboard.recruit.domain.RecruitmentBulletin;

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
	
	private final RecruitBullDao recruitBullDao = RecruitBullDao.getInstance();
	
	public int write(RecruitmentBulletin recruitBull) {
		recruitBullDao.insert(recruitBull);
		return -1;
	}
	
	public int write(RecruitmentBulletin recruitBull, List<InputStream> photoInputStreams) {
		String photosPath = recruitBull.getPhotosPath();
		if(photosPath == null || photosPath.isBlank() || photoInputStreams.size() <= 0) {
			return -1;
		}
		
		// 이미지 디렉토리 생성
		File path = new File(photosPath);
		if (!path.exists()) {
			path.mkdirs();
			log.info("이미지 저장용 디렉토리 생성");
		}
		
		// 이미지 저장
		try {
			for(int i = 0; i < photoInputStreams.size(); i++) {
				System.out.println(i);
				InputStream inputStream = photoInputStreams.get(i);
				FileOutputStream outputStream = new FileOutputStream(path + "/" + i + ".jpeg");
				byte[] buf = new byte[1024];
				int size;
				while ((size = inputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, size);
				}
				outputStream.close();
				inputStream.close();
			}
			return write(recruitBull);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
