package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.*;

@WebServlet(urlPatterns="/client/captcha")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final char[] CHARS = {
			'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
	};  //設定隨機字串，除1, i, o, O不好辨識字元
	public static Random random = new Random();  //亂數
	
    public IdentityServlet() {
    }

	@SuppressWarnings("restriction")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg"); //輸出為jpeg類型
		
		String randomString = getRandomString(); //取得隨機字串
		request.getSession().setAttribute("randomString", randomString);
												//放到session中
		int width = 100;  //圖片寬度
		int height = 30;  //圖片高度
		
		Color color = getRandomColor();  //用於背景色
		Color reverse = getReverseColor(color); //前景色
		System.out.println("++++++++++++++++++++++++++");
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
											//建立圖片
		Graphics2D g = bi.createGraphics(); //取得繪圖物件
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width, height); //繪製背景
		g.setColor(reverse);
		g.drawString(randomString, 18, 20); //繪製前景字元
		for(int i = 0, n = random.nextInt(100); i < n; i++){
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		} //繪製噪點
		
		ServletOutputStream out = response.getOutputStream();
		
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		
		encoder.encode(bi);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static String getRandomString() {  //取得六位亂數
		StringBuffer buffer = new StringBuffer(); //字串快取物件
		for (int i = 0; i < 6; i++){
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		} //取出六個隨機字元
		return buffer.toString();
	}
	
	public static Color getRandomColor() { //取隨機顏色
		return new Color(random.nextInt(255), random.nextInt(255), 
				random.nextInt(255));
	}

	public static Color getReverseColor(Color c) { //取反色
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 
				255 - c.getBlue());
	}
}
