package gof.gpt5.dto;

	/*
	CREATE TABLE g_images (  
	  gimSeq INT,
	  filename VARCHAR(255),
	  newfilename VARCHAR(255),
	  filesize INT,
	  FOREIGN KEY (gimSeq) REFERENCES gyms(g_seq) ON DELETE CASCADE
	);
	 */

public class GimageDto {      
    private int gimSeq;
    private String filename;        
    private String newfilename;
    private long filesize;  

    public GimageDto() {
    }

    public GimageDto(int gimSeq, String filename, String newfilename, long filesize) {
        super();
        this.gimSeq = gimSeq;
        this.filename = filename;
        this.newfilename = newfilename;
        this.filesize = filesize;
    }

    public int getgimSeq() {
        return gimSeq;
    }

    public void setgimSeq(int gimSeq) {
        this.gimSeq = gimSeq;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNewfilename() {
        return newfilename;
    }

    public void setNewfilename(String newfilename) {
        this.newfilename = newfilename;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    @Override
    public String toString() {
        return "GimageDto [gimSeq=" + gimSeq + ", filename=" + filename + ", newfilename=" + newfilename + ", filesize=" + filesize + "]";
    }
}
