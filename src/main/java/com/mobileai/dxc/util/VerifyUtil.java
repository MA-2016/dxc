package com.mobileai.dxc.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyUtil {

    public static Object[] creatImage() {
        int width = 100, height = 28;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics(); // 创建Graphics对象，其作用于画笔
        Graphics2D g2d = (Graphics2D) g; // 创建Grapchics2D对象
        Random random = new Random();
        Font font = new Font("华文宋体", Font.BOLD, 24);
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(font);
        g.setColor(getRandColor(180, 200));

        // 绘制随机线条
        for (int i = 0; i < 10; i++) {
            g2d.setColor(getRandColor(120, 200));
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g2d.drawLine(x1, y1, x2, y2);
            ;
        }

        // 绘制验证码
        String sRand = "";
        char ctmp;
        for (int i = 0; i < 4; i++) {
            do{
                ctmp =  (char)('a'+Math.random()*('z'-'a'+1));
            }while(ctmp=='l'||ctmp=='o');
            sRand += ctmp;
            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110));
            g.setColor(color);
            g.drawString(ctmp+"", 19 *i + 19, 19);

        }
        g.dispose();

        return new Object[] { sRand, image };
    }

    public static Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255)
            s = 91;
        if (e > 255)
            e = 97;
        int r, g, b;
        r = s + random.nextInt(e - s);
        g = s + random.nextInt(e - s);
        b = s + random.nextInt(e - s);
        return new Color(r, g, b);
    }
}