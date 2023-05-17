package gof.gpt5.dto;


public class TrainerLikeDto {
    private int id;            // 좋아요 고유 ID
    private int ptSeq;        // 게시물 seq
    private String nickname;   // 게시물을 좋아한 회원의 닉네임  
    private boolean isLiked;

    public TrainerLikeDto() {
    }
    
    public TrainerLikeDto(int ptSeq, String nickname) {
        this.ptSeq = ptSeq;
        this.nickname = nickname;
    }
    
    public TrainerLikeDto(int id, int ptSeq, String nickname) {
        this.ptSeq = ptSeq;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getptSeq() {
        return ptSeq;
    }
    
    public boolean getIsLiked() {
        return isLiked;
    }

    public void setptSeq(int ptSeq) {
        this.ptSeq = ptSeq;
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
		return "TrainerLikeDto [id=" + id + ", ptSeq=" + ptSeq + ", nickname=" + nickname + ", isLiked=" + isLiked
				+ "]";
	}

}
