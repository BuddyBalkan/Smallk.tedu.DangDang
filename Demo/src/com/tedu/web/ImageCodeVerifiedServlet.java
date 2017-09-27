package com.tedu.web;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageCodeVerifiedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("验证码自动生成程序启动成功");
        resp.setContentType("image/jpg");
        //  生成验证码图片的宽高以及颜色RGB搭配
        BufferedImage bufferedImage = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        // 用图片的得到画笔 准备绘画
        Graphics graphics = bufferedImage.getGraphics();
        // Random 随机数类
        Random random = new Random();
//        random.nextInt();// +-21亿内 int范围内的随机数
//        random.nextInt(256);// 0-255之间的整数
        graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        graphics.fillRect(0,0,60,20);
        // 随机获取0-9998之间的验证码数
        int numCode = random.nextInt(9999);
        graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        graphics.drawString(numCode + "", 10,15);

        // 随机生成干扰线
        graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        for (int i = 0; i < 3; i++){
            graphics.drawLine(random.nextInt(61),random.nextInt(61),random.nextInt(61),random.nextInt(61));
        }

        // 对图片进行压缩 以在浏览器中显示出来
            // 获取输出流
        OutputStream outputStream = resp.getOutputStream();
            // 将输出流压缩成图片格式
        JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
        jpegImageEncoder.encode(bufferedImage);



    }
}
