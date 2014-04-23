package com.wangxin.dang.actions.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.wangxin.dang.utils.Constant;


public class StreamAction{

	private static int WIDTH = 200;

	private static int HEIGHT = 80;

	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	public  InputStream getInputStream(Map<String,Object> session,int codeNumber) {
		//System.out.println("streamAction 30 session:"+session);
		byte[] image = this.randomImage(session,codeNumber);
		//System.out.println("image[]"+image);
		return new ByteArrayInputStream(image);
	}

	/**
	 * 
	 * @return
	 */
	private byte[] randomImage(Map<String,Object> session,int codeNumber) {
		Random r = new Random();

		// ͼƬ���ڴ�ӳ��
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// ��û��ʶ���
		Graphics g = image.getGraphics();
		g.setColor(randomColor(r));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));

		// ���ڴ洢������ɵ���֤��
		StringBuffer number = new StringBuffer();

		// ������֤��
		for (int i = 0; i < codeNumber; i++) {
			g.setColor(randomColor(r));
			int h = (int) ((HEIGHT * 60 / 100) * r.nextDouble() + (HEIGHT * 30 / 100));
			g.setFont(new Font(null, Font.BOLD | Font.ITALIC, h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * WIDTH / codeNumber * 90 / 100, h);
		}

		//System.out.println("number"+number.toString());
		//System.out.println("session:"+session);
		
		session.put("number", number.toString());
		
		//System.out.println("number:"+number.toString());
		
		// ���Ƹ�����
		for (int i = 0; i <= 12; i++) {
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r
					.nextInt(HEIGHT));
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		// ��BufferedImage�����е�ͼ����Ϣ�����
		// �򴴽��ö���(encoder)ʱָ������������
		try {
			encoder.encode(image);
			//System.out.println("return:");
			return os.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
}
