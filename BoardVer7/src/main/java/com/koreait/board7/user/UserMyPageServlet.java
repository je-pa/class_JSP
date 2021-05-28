package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyFileUtils;
import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.getLoginUser(request)==null) {
			response.sendRedirect("login");
			return;
		}
		MyUtils.openJSP("마이페이지", "user/userMyPage", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String uploadPath= request.getRealPath("/res/img");
		//getRealPath가 request보다는 application이 나은가
		String uploadPath=request.getServletContext().getRealPath("/res/img");
		//WEB-INF까지 들어와줌 (톰켓주소)
		System.out.println(uploadPath);
		////D:\JavaBackendClass\WebWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\BoardVer7\res\img
		int maxFileSize=10_485_760;//10*1024*1024(10mb)
		try {
			MultipartRequest multi = new MultipartRequest(request
					, uploadPath+"/temp",maxFileSize,"UTF-8"
					, new DefaultFileRenamePolicy()/*중복된 파일이름이 있을시 파일이름을 바꿔줌*/);
			String fileNm = multi.getFilesystemName("profileImg");//바뀐파일명을 불러옴
			System.out.println(fileNm);
			if(fileNm==null) {
				doGet(request,response);
				return;
			}
			UserEntity loginUser = MyUtils.getLoginUser(request);
			int loginUserPk = loginUser.getIuser();
			String targetFolder = uploadPath + "/user/"+loginUserPk;
			//실제 이미지가 위치해야하는 폴더
			
			MyFileUtils.delFolder(targetFolder);
			//folder.delete();//파일 있는거 삭제 근데 안에 내용없으면 못삭제...
			File folder = new File(targetFolder);
			
	//		if(!folder.exists()) {
	//			folder.mkdirs();
	//			//s붙은거 안붙은거 차이는 중간에 없는파일까지 다 만들어준다 (user폴더)
	//		}
			folder.mkdirs();//없으면 파일 만들어줌 
			//어차피 있는지 확인하구 만들어주기에 if 없어도됨
			
			String ext = fileNm.substring(fileNm.lastIndexOf("."));//확장자구함
			String newFileNm = UUID.randomUUID().toString()+ext;
			
			File imgFile=new File(uploadPath+"/temp"+"/"+fileNm);
			imgFile.renameTo(new File(targetFolder+"/"+newFileNm));
			
			UserEntity param = new UserEntity();
			param.setIuser(loginUserPk);
			param.setProfileImg(newFileNm);
			
			UserDAO.updUser(param);
			
			loginUser.setProfileImg(newFileNm);
			//request.getSession().setAttribute("loginUser", loginUser);
			//레퍼런스변수라서 안해줘도됨
		}catch (Exception e) {
			
		}
		doGet(request,response);
	}
}
