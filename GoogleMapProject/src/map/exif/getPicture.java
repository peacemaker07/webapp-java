package map.exif;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.SystemException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.opensymphony.xwork2.ActionSupport;


public class getPicture extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	// Form
	/** ファイル */
	private File uploadFile;
	/** ファイルの拡張子 */
	private String uploadFileContentType;
	/** ファイル名称 */
	private String uploadFileFileName;

	/**
	 * @return the uploadFile
	 */
	public File getUploadFile() {
		return uploadFile;
	}

	/**
	 * @param uploadFile
	 *            the uploadFile to set
	 */
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	/**
	 * @return the uploadFileContentType
	 */
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	/**
	 * @param uploadFileContentType
	 *            the uploadFileContentType to set
	 */
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	/**
	 * @return the uploadFileFileName
	 */
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	/**
	 * @param uploadFileFileName
	 *            the uploadFileFileName to set
	 */
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	
	long fileMaxSize = 2097152;//2MB
	
	String realPath = ServletActionContext.getServletContext().getRealPath("/image");  
	
	public String doInit() throws SystemException {
		
		return INPUT;
	}

	public String doFileUpload() throws SystemException, ImageProcessingException {
		
		String uploadFileFileName = this.getUploadFileFileName();
		
		System.out.println("doFileUpload");
		
		//uploadFileFileName = uploadFileFileName.substring(uploadFileFileName.lastIndexOf('.')); 
		//イメージファイルじゃない場合、異常を返す
		if(!isImageFile(this.getUploadFileContentType())) {
			// return error;//TODO
		}
		// 空ファイル、またはファイルサイズ２M以上の場合、異常を返す
		if(this.getUploadFile() == null || this.getUploadFile().length()>fileMaxSize) {
			// return maxSizeError;//TODO
		}
		
		File filePath = new File(new File(realPath), uploadFileFileName);
		// ディレクトリ存在しない場合、新なディレクトリを作成
		if(!filePath.getParentFile().exists()) {
			filePath.getParentFile().mkdirs();
		}
		
		try {  
		// ★コピーを実施
            FileUtils.copyFile(this.getUploadFile(), filePath);  
	    } catch (IOException e) {  
	        System.out.println("画像がアップロードできませんでした。");   
	        e.printStackTrace();  
	    }
		
		// Exif情報を取得
        try {
            //URL url    = new URL("http://blog-imgs-48-origin.fc2.com/h/o/g/hoge1231/2013120701.jpg");
            //Exif exif  = new Exif(url);

            // ローカルファイルから呼び出す場合は以下のように記述
//            File file  = new File("C:\\Users\\XXX\\Desktop\\2013120701.jpg");
//            File file  = new File(getUploadFile());
            File file  = getUploadFile();
            Exif exif  = new Exif(file);

            List<String> tags = exif.getTagNameList();
            for(String tag : tags) {
                System.out.println(tag + " : " + exif.getValue(tag));
            }
            
            System.out.println("======================================");
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.println(tag);
                }
            }
            System.out.println("======================================");
            
        } catch (JpegProcessingException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
		return "success";
	}
	
	
	/**
	 * 
	 * @param extension
	 *            　ファイルの拡張子
	 * @return
	 */
	private boolean isImageFile(String extension) {

		System.out.println("isImageFile");
		
		return (extension.equals("image/gif") 
				|| extension.equals("image/jpeg")
				|| extension.equals("image/png")
				|| extension.equals("image/bmp")
				|| extension.equals("image/x-icon") 
				|| extension.equals("image/pjpeg"));

	}
}
