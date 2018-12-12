package com.hanul.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	//1. Spring���� �����ϴ� FileCopyUtils�� copy�޼��� ���
		public String saveFile(String realPath, MultipartFile multipartFile) throws Exception {
			String fileSystemName="";
			//1. ������ ��θ� realPath
			//2. ������ ���ϸ�
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			fileSystemName = UUID.randomUUID().toString();
			String oname = multipartFile.getOriginalFilename();
			oname=oname.substring(oname.lastIndexOf('.'));
			fileSystemName=fileSystemName+oname;
			System.out.println(fileSystemName);
			file = new File(realPath, fileSystemName);
			
			FileCopyUtils.copy(multipartFile.getBytes(), file);
			
			return fileSystemName;
		}
		
		//2. OutPutStream �̿�
		public String saveFile2(String realPath, MultipartFile multipartFile)throws Exception{
			String fileSystemName="";
			//1. ������ ��θ� realPath
			//2. ������ ���ϸ�
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			fileSystemName = UUID.randomUUID().toString();
			String oname = multipartFile.getOriginalFilename();
			oname=oname.substring(oname.lastIndexOf('.'));
			fileSystemName=fileSystemName+oname;
			file = new File(realPath, fileSystemName);
			
			FileOutputStream fo = new FileOutputStream(file);
			fo.write(multipartFile.getBytes());
			
			return fileSystemName;
		}
		
		
		//3. MultipartFile�� transferTo �޼��� ���
		public String saveFile3(String realPath, MultipartFile multipartFile)throws Exception{
			String fileSystemName="";
			//1. ������ ��θ� realPath
			//2. ������ ���ϸ�
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			fileSystemName = UUID.randomUUID().toString();
			String oname = multipartFile.getOriginalFilename();
			oname=oname.substring(oname.lastIndexOf('.'));
			fileSystemName=fileSystemName+oname;
			file = new File(realPath, fileSystemName);
			
			multipartFile.transferTo(file);
			
			return fileSystemName;
		}
	
}
