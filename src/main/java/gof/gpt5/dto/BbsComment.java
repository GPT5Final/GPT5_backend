package gof.gpt5.dto;

import java.io.Serializable;

/*
create table bbscomment(
		seq decimal(5) not null,
		id varchar(50),
		content varchar(1000) not null,
		wdate timestamp not null
	);

	alter table bbscomment
	add foreign key(id) references member(id);
*/
public class BbsComment implements Serializable{
	private int seq;
	private String id;
	private String content;
	private String wdate;
	
	public BbsComment() {
	}

	public BbsComment(int seq, String id, String content, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "BbsComment [seq=" + seq + ", id=" + id + ", content=" + content + ", wdate=" + wdate + "]";
	}
	
	
	
}
