package com.emall.base.component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

/**
 * Ftp共通方法类
 *
 * @author 苏振江
 * @version 1.0 2016/6/4
 */
@Component
public class FtpManage {

    /**
     * 日志处理的导入
     */
    private static final Log log = LogFactory.getLog(FtpManage.class);

    /**
     * FTP服务器
     **/
    @Value("${ftp.server.host}")
    private String serverHost;

    /**
     * FTP服务器 端口
     **/
    @Value("${ftp.server.post}")
    private String serverPost;

    /**
     * FTP服务器 连接用户
     **/
    @Value("${ftp.server.user}")
    private String serverUser;

    /**
     * FTP服务器 连接密码
     **/
    @Value("${ftp.server.password}")
    private String serverPassword;

    /**
     * FTP服务器 连接超时
     **/
    @Value("${ftp.server.timeout}")
    private String serverTimeout;

    /**
     * FTP服务器 连接默认路径
     **/
    @Value("${ftp.server.defaultPath}")
    private String serverDefaultPath;

    /**
     * FTP服务器 连接图片路径
     **/
    @Value("${ftp.server.imagesPath}")
    private String serverImagesPath;

    /**
     * FTP服务器 连接媒体路径
     **/
    @Value("${ftp.server.mediaPath}")
    private String serverMediaPath;

    /**
     * FTP服务器 连接静态网页路径
     **/
    @Value("${ftp.server.htmlPath}")
    private String serverHtmlPath;

    /**
     * FTP服务器 连接临时路径
     **/
    @Value("${ftp.server.tempPath}")
    private String serverTempPath;

    /**
     * FTP服务器 连接用户
     **/
    private Session session;

    /**
     * FTP服务器 连接用户
     **/
    private Channel channel;

    private ChannelSftp openChannel() throws JSchException {

        String host = serverHost;
        String port = serverPost;
        int defaultPost = 22;
        if (port != null && !port.equals("")) {
            defaultPost = Integer.valueOf(port);
        }

        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(serverUser, host, defaultPost); // 根据用户名，主机ip，端口获取一个Session对象
        log.debug("Session created.");
        if (serverPassword != null) {
            session.setPassword(serverPassword); // 设置密码
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(Integer.valueOf(serverTimeout)); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        log.debug("Session connected.");

        log.debug("Opening Channel.");
        channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        log.debug("Connected successfully to ftpHost = " + serverHost + ",as ftpUserName = " + serverUser
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    private void close() {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }

    /**
     * 将本地src文件上传到目标服务器dst的目录下。
     *
     * @param src
     * @param dst
     * @throws JSchException
     * @throws SftpException
     */
    public void filePut(String src, String dst) throws JSchException, SftpException {
       
    	ChannelSftp sftp = this.openChannel();
	    try{
	        src = src.replaceAll("\\\\", "/");
	        dst = dst.replaceAll("\\\\", "/");
	
	        File file = new File(src);
	        long fileSize = file.length();
	
	        autoMkdir(sftp, dst);
	
	        sftp.put(src, dst, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE);
        
		}catch(Exception e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
    }

    /**
     * 将本地的input stream对象src上传到目标服务器dst的目录下。
     *
     * @param src      文件
     * @param dst      服务器目标全路径
     * @param fileName 文件名
     * @throws JSchException
     * @throws SftpException
     * @throws IOException
     */
    public void filePut(InputStream src, String dst, String fileName) throws JSchException, SftpException, IOException {
        ChannelSftp sftp = this.openChannel();
	    try{
	        dst = dst.replaceAll("\\\\", "/");
	
	        int fileSize = src.available();
	
	        autoMkdir(sftp, dst);
	
	        sftp.put(src, dst + fileName, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE);
		}catch(Exception e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
    }
    /**
     * 取得ftp服务器上的文件内容
     *
     * @param path
     * @param fileName
     * @throws JSchException
     * @throws SftpException
     */
    public byte[] fileGet(String path, String fileName) throws JSchException, SftpException, IOException {
        ChannelSftp sftp = this.openChannel();
        byte[] b = null;
        try{
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        InputStream is = sftp.get(path + fileName);
	        
			byte[] buf = new byte[1024];
			int len = is.read(buf,0,1024);
			while(len != -1)
			{
				bos.write(buf,0,len);
				bos.flush();
		       len = is.read(buf,0,1024);
			}
			b =  bos.toByteArray();
			is.close();
			bos.close();
		
		}catch(Exception e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
        return b;
    }
    /**
     * 删除文件夹以及该文件夹中的文件
     *
     * @param path
     */
    public void deletePathAndFiles(String path) throws JSchException, SftpException {
        ChannelSftp sftp = this.openChannel();
        try{
	        path = path.replaceAll("\\\\", "/");
	
	        String homePath = this.serverDefaultPath;
	        sftp.cd(homePath);
	
	        path = path.replace(homePath, "");
	
	        delDir(homePath + path, sftp);
		}catch(Exception e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
    }

    /**
     * 删除文件夹
     *
     * @param dirName
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    private void delDir(String dirName, ChannelSftp sftp) throws JSchException, SftpException {

        Vector<ChannelSftp.LsEntry> list = null;
        sftp.cd(dirName);
        list = sftp.ls(sftp.pwd());

        for (ChannelSftp.LsEntry entry : list) {
            String itemName = entry.getFilename();
            if (!itemName.equals(".") && !itemName.equals("..")) {
                if (entry.getAttrs().isDir()) {
                    delDir(itemName, sftp);
                } else {
                    delFile(itemName, sftp);
                }
            }
        }

        sftp.cd("..");

        sftp.rmdir(dirName);
        log.debug("directory " + dirName + " successfully deleted");

    }

    /**
     * 删除文件
     *
     * @param fileName 文件名
     * @return boolean
     */
    private void delFile(String fileName, ChannelSftp sftp) throws SftpException {
        sftp.rm(fileName);
        log.debug("file " + fileName + " successfully deleted");

    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    public void delete(String fileName) throws JSchException, SftpException {
        ChannelSftp sftp = this.openChannel();
	    try{
	    	sftp.rm(fileName);
		}catch(SftpException e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
    }

    /**
     * @param oldpath 旧文件全路径
     * @param newpath 新文件全路径
     * @throws JSchException
     * @throws SftpException
     */
    public void rename(String oldpath, String newpath) throws JSchException, SftpException {
        ChannelSftp sftp = this.openChannel();
	    try{

	    	sftp.rename(oldpath, newpath);
		}catch(SftpException e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
    }

    /**
     * 自动在[serverDefaultPath]内创建路径
     *
     * @param sftp
     * @param dst  路径
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    private boolean autoMkdir(ChannelSftp sftp, String dst) throws SftpException {
        dst = dst.replaceAll("\\\\", "/");

        String homePath = this.serverDefaultPath;
        sftp.cd(homePath);

        String path = dst.replace(homePath, "");

        String[] pathArr = path.split("/");

        List<ChannelSftp.LsEntry> items = sftp.ls(homePath);

        boolean isExist = false;
        for (int i = 0; i < pathArr.length; i++) {
            String pathItem = pathArr[i];
            isExist = false;
            for (ChannelSftp.LsEntry lsItem : items) {
                SftpATTRS t = lsItem.getAttrs();
                boolean isdir = t.isDir();
                if (isdir) {
                    if (lsItem.getFilename().equals(pathItem)) {
                        isExist = true;
                        break;
                    }
                }
            }
            if (isExist) {
                sftp.cd(pathItem);
                items = sftp.ls(sftp.pwd());
            } else {
                sftp.mkdir(pathItem);
                sftp.cd(pathItem);
                items = sftp.ls(sftp.pwd());
            }
        }
        return true;
    }

    /**
     * 得到指定目录下的文件列表
     * @param dir
     * @return
     * @throws SftpException
     */
    @SuppressWarnings("unchecked")
    public List<String> getFileList(String dir) throws JSchException, SftpException {
        ChannelSftp sftp = this.openChannel();
        List<String> fileList = new ArrayList<String>();
	    try{
	        Vector<ChannelSftp.LsEntry> list = null;
	        list = sftp.ls(dir);
	
	        for (ChannelSftp.LsEntry entry : list) {
	            String itemName = entry.getFilename();
	            if (!itemName.equals(".") && !itemName.equals("..")) {
	                fileList.add(itemName);
	            }
	        }
		}catch(SftpException e)
		{
			log.error(e);
			throw e;
		}finally
		{
		    sftp.quit();
		    this.close();
		}
        return fileList;
    }

    /**
     * 得到服务器中图片的存放地址
     *
     * @return serverImagesPath 图片存放地址
     */
    public String getServerImagesPath() {
        return serverImagesPath;
    }

    /**
     * 得到服务器中视频的存放地址
     *
     * @return serverMediaPath 视频存放地址
     */
    public String getServerMediaPath() {
        return serverMediaPath;
    }

    /**
     * 得到服务器中html的存放地址
     *
     * @return serverHtmlPath html存放地址
     */
    public String getServerHtmlPath() {
        return serverHtmlPath;
    }

    /**
     * 得到服务器中临时目录的存放地址
     *
     * @return serverTempPath 临时目录
     */
    public String getServerTempPath() {
        return serverTempPath;
    }
}
