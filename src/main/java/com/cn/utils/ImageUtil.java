package com.cn.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 图片处理工具类
 * <p>图片处理工具类<br>
 * @author 李文龙
 * @version 1.0 2016/6/12
 */
public class ImageUtil {
	
    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ConvertUtils.class);
    
	/**
	 * 生成缩略图
	 * @param is 输入流
	 * @param typeName 生成图片类型
	 * @param nWith 生成图片宽度
	 * @param nheight 生成图片高度
	 * @return 
	 * @throws IOException
	 */
    public static ByteArrayOutputStream createThumbImage(InputStream is, String typeName, int nWith, int nheight) throws IOException
    {   
    	// 开始日志
    	logger.debug("ByteArrayOutputStream：生成缩略图-----开始-----");
    
        AffineTransform transform = new AffineTransform(); 
        //读取图片  
        BufferedImage bis = ImageIO.read(is); 
        
        int w = bis.getWidth();  
        int h = bis.getHeight();  
        //int newhight = (newWith*h)/w ;  //按比例缩放
        double sx = (double)nWith/w;  
        double sy = (double)nheight/h; 
        
        transform.setToScale(sx, sy); 
        
        AffineTransformOp ato = new AffineTransformOp(transform, null);  
        BufferedImage bid = new BufferedImage(nWith, nheight, BufferedImage.TYPE_3BYTE_BGR);  
        
        ato.filter(bis,bid);  
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ImageIO.write(bid, typeName, out);  

        return out;
    }

    /**
     * 缩放图像（按高度和宽度缩放）
     * @param srcImageFile 源图像文件地址
     * @param result 缩放后的图像地址
     * @param height 缩放后的高度
     * @param width 缩放后的宽度
     * @param bb 比例不对时是否需要补白：true为补白; false为不补白;
     */
    public final static void paramImage(String srcImageFile, String result, int height, int width, boolean bb) {
        logger.debug("paramImage : 缩放图像（按高度和宽度缩放）");
        try {
            double ratio = 0.0; // 缩放比例
            File f = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(f);
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {// 补白
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null),
                            itemp.getHeight(null), Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null),
                            itemp.getHeight(null), Color.white, null);
                g.dispose();
                itemp = image;
            }
            ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));
        } catch (IOException e) {
            logger.error("paramImage : 缩放图像error :" + e);
        }
    }
}
