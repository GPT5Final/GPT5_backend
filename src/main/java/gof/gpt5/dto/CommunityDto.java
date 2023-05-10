package gof.gpt5.dto;

public class CommunityDto {

	private int seq;
    private String email;
    private String nickname;
    private String groupname;
    private String career;
    private String stime;
    private String etime;
    private String category;
    private String banner;
    private String price;
    private String location;
    private String title;
    private String content;
    private String tag1;
    private String tag2;
    private String tag3;
    private int del;
	private int readcount;
	private int likecount;
    private int ref;
    private int step;
    private int depth;
    
    public CommunityDto() {
	}

	public CommunityDto(int seq, String email, String nickname, String groupname, String career, String stime,
			String etime, String category, String banner, String price, String location, String title, String content,
			String tag1, String tag2, String tag3, int del, int readcount, int likecount, int ref, int step,
			int depth) {
		super();
		this.seq = seq;
		this.email = email;
		this.nickname = nickname;
		this.groupname = groupname;
		this.career = career;
		this.stime = stime;
		this.etime = etime;
		this.category = category;
		this.banner = banner;
		this.price = price;
		this.location = location;
		this.title = title;
		this.content = content;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.del = del;
		this.readcount = readcount;
		this.likecount = likecount;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
	}   
	

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	

	@Override
	public String toString() {
		return "CommunityDto [seq=" + seq + ", email=" + email + ", nickname=" + nickname + ", groupname=" + groupname
				+ ", career=" + career + ", stime=" + stime + ", etime=" + etime + ", category=" + category
				+ ", banner=" + banner + ", price=" + price + ", location=" + location + ", title=" + title
				+ ", content=" + content + ", tag1=" + tag1 + ", tag2=" + tag2 + ", tag3=" + tag3 + ", del=" + del
				+ ", readcount=" + readcount + ", likecount=" + likecount + ", ref=" + ref + ", step=" + step
				+ ", depth=" + depth + "]";
	}


    
}
