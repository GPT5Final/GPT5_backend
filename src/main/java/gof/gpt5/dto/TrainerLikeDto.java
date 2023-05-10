package gof.gpt5.dto;

public class TrainerLikeDto {
    private int id;            // 좋아요 고유 ID
    private int pt_seq;        // 게시물 seq
    private String nickname;   // 게시물을 좋아한 회원의 닉네임  
    private boolean isLiked;

    public TrainerLikeDto() {
    }

    public TrainerLikeDto(int id, int pt_seq, String nickname) {
        this.id = id;
        this.pt_seq = pt_seq;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPt_seq() {
        return pt_seq;
    }
    
    public boolean getIsLiked() {
        return isLiked;
    }

    public void setPt_seq(int pt_seq) {
        this.pt_seq = pt_seq;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;        
    }
    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

	@Override
	public String toString() {
		return "TrainerLikeDto [id=" + id + ", pt_seq=" + pt_seq + ", nickname=" + nickname + ", isLiked=" + isLiked
				+ "]";
	}

}
