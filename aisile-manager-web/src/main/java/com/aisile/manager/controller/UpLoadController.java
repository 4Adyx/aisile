package com.aisile.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aisile.oss.AliyunOSSClientUtils;
import com.aisile.pojo.entity.Result;

@RestController
public class UpLoadController {

	@RequestMapping("/upload")
	public Result upload(MultipartFile file) throws Exception{
		String imgUrl;
		try {
			AliyunOSSClientUtils aliyunOSSClientUtils = new AliyunOSSClientUtils();
			String uploadImg2Oss = aliyunOSSClientUtils.uploadImg2Oss(file);
			imgUrl = aliyunOSSClientUtils.getImgUrl(uploadImg2Oss);
			return new Result(true, 20000, imgUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Result(false, 20001, "上传失败");
	}
}
