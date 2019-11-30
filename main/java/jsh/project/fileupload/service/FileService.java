package jsh.project.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService{
	private static final Logger logger = LoggerFactory.getLogger(FileService.class);
	
	private final String rootDirectory = "/Users/jangsehun/Documents/fileDirectory/";
	
	public boolean save(MultipartFile file) {
		String savePath = setFileDirectory();
		String fileName = setSaveName(file.getOriginalFilename());
		return writerFile(savePath, file, fileName);
	}
	
	//년월일시분 기준으로 해당 폴더가 있는지 확인 후 저장경로 리턴
	public String setFileDirectory() {
		Calendar calendar = Calendar.getInstance();
		String savePath = rootDirectory	+ calendar.get(Calendar.YEAR) + "/"
										+ (calendar.get(Calendar.MONTH)+1) + "/" 
										+ calendar.get(Calendar.DATE) + "/"
										+ calendar.get(Calendar.HOUR) + "/"
										+ calendar.get(Calendar.MINUTE);
		File fileDateDirectory = new File(savePath);
		if(!fileDateDirectory.exists()) {
			fileDateDirectory.mkdirs();
			logger.info(savePath + " 경로에 폴더 생성");
		}
		logger.info("저장 경로 : " + savePath);
		return savePath;
	}
	
	//현재 날짜 + 파일 이름으로 만든 후 리턴
	public String setSaveName(String originfileName) {
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += (calendar.get(Calendar.MONTH)+1);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		//fileName += "."+calendar.get(Calendar.SECOND);
		//fileName += "."+calendar.get(Calendar.MILLISECOND);
		fileName += "-"+originfileName;
		
		return fileName;
	}
	
	//실제 파일 저장
	public boolean writerFile(String savePath, MultipartFile file, String fileName) {
		boolean result = true;
		FileOutputStream fos = null;

		byte[] data;
		
		try {
			data = file.getBytes();
			fos = new FileOutputStream(savePath + "/" + fileName);
			fos.write(data);
		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
