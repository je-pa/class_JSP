package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("마이페이지", "user/userMyPage", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String uploadPath= request.getRealPath("/res/img");
		String uploadPath=request.getServletContext().getRealPath("/res/img");
		int maxFileSize=10_485_760;//10*1024*1024(10mb)
		//WEB-INF까지 들어와줌 (톰켓주소)
		System.out.println(uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request
				, uploadPath+"/temp",maxFileSize,"UTF-8"
				, new DefaultFileRenamePolicy()/*중복된 이름이 있을시 이름을 바꿔줌*/);
		int loginUserPk = MyUtils.getLoginUserPK(request);
		String targetFolder = uploadPath + "/user/"+loginUserPk;
		File folder = new File(targetFolder);
//		if(!folder.exists()) {
//			folder.mkdirs();
//			//s붙은거 안붙은거 차이는 중간에 없는것까지 다 만들어준다 (user폴더)
//		}
		folder.mkdirs();//어차피 있는지 확인하구 만들어줌
		
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println(fileNm);
		String ext = fileNm.substring(fileNm.lastIndexOf("."));//확장자구함
		String newFileNm = UUID.randomUUID().toString()+ext;
		
		File imgFile=new File(uploadPath+"/temp"+"/"+fileNm);
		imgFile.renameTo(new File(targetFolder+"/"+newFileNm));
	}
}
