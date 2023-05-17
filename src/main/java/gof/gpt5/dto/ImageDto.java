package gof.gpt5.dto;
	/*
	CREATE TABLE pt_images (  
	  trainerSeq INT,
	  filename VARCHAR(255),
	  newfilename VARCHAR(255),
	  filesize INT,
	  FOREIGN KEY (trainerSeq) REFERENCES pt(seq) ON DELETE CASCADE
	);
	 */
public class ImageDto {	  	
	  	private int trainerSeq;
	    private String filename;			
		private String newfilename;
		private long filesize;	
		
		public ImageDto() {
		}

		public ImageDto(int trainerSeq, String filename, String newfilename, long filesize) {
			super();
			this.trainerSeq = trainerSeq;
			this.filename = filename;
			this.newfilename = newfilename;
			this.filesize = filesize;
		}

		public int gettrainerSeq() {
			return trainerSeq;
		}

		public void settrainerSeq(int trainerSeq) {
			this.trainerSeq = trainerSeq;
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
			return "ImageDto [trainerSeq=" + trainerSeq + ", filename=" + filename + ", newfilename=" + newfilename
					+ ", filesize=" + filesize + "]";
		}
		
}
