package com.mobileai.dxc.util;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
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
        Font font = new Font("华文宋体", Font.BOLD, 19);
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
        String ctmp = "";
        for (int i = 0; i < 4; i++) {
            // 根据需要该段生成汉字的代码可注释掉
            // 生成汉字
            String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
            // 生成第一位区码
            int r1 = random.nextInt(3) + 11;
            String str_r1 = rBase[r1];
            // 生成第二位区码
            int r2;
            if (r1 == 13) {
                r2 = random.nextInt(7);
            } else {
                r2 = random.nextInt(16);
            }
            String str_r2 = rBase[r2];
            // 生成第一位位码
            int r3 = random.nextInt(6) + 10;
            String str_r3 = rBase[r3];
            // 生成第二位位码
            int r4;
            if (r3 == 10) {
                r4 = random.nextInt(15) + 1;
            } else if (r3 == 15) {
                r4 = random.nextInt(15);
            } else {
                r4 = random.nextInt(16);
            }
            String str_r4 = rBase[r4];
            // 将生成的机内码转换为汉字
            byte[] bytes = new byte[2];
            // 将生成的区码保存到字节数组的第一个元素中
            String str_12 = str_r1 + str_r2;
            int tempLow = Integer.parseInt(str_12, 16);
            bytes[0] = (byte) tempLow;
            // 将生成的位码保存到字节数组的第二个元素中
            String str_34 = str_r3 + str_r4;
            int tempHigh = Integer.parseInt(str_34, 16);
            bytes[1] = (byte) tempHigh;
            ctmp = new String(bytes);// 该段生成汉字的代码可注释掉

            sRand += ctmp;
            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110));
            g.setColor(color);
            g.drawString(ctmp, 19 * i + 19, 19);
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