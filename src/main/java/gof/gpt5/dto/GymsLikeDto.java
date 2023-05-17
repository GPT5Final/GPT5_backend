package gof.gpt5.dto;

/*
	CREATE TABLE gymslike (
	id INT AUTO_INCREMENT PRIMARY KEY,    -- 각 좋아요에 대한 고유 ID
	gymSeq INT NOT NULL,                  -- pt 테이블의 게시물 seq
	nickname VARCHAR(50) NOT NULL,        -- 게시물을 좋아한 회원의 닉네임
	FOREIGN KEY (gymSeq) REFERENCES gyms(g_seq) ON DELETE CASCADE,
	FOREIGN KEY (nickname) REFERENCES member(nickname) ON DELETE CASCADE,
	UNIQUE KEY (gymSeq, nickname)         -- 사용자가 게시물을 한 번만 좋아할 수 있도록 보장
	);
*/

public class GymsLikeDto {
    private int id; // 좋아요 고유 ID
    private int gymSeq; // 게시물 seq
    private String nickname; // 게시물을 좋아한 회원의 닉네임  
    private boolean isLiked;

    public GymsLikeDto() {
    }
    
    public GymsLikeDto(int gymSeq, String nickname) {       
        this.gymSeq = gymSeq;
        this.nickname = nickname;
    }

    public GymsLikeDto(int id, int gymSeq, String nickname) {
        this.id = id;
        this.gymSeq = gymSeq;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getgymSeq() {
        return gymSeq;
    }

    public void setgymSeq(int gymSeq) {
        this.gymSeq = gymSeq;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    @Override
    public String toString() {
        return "GymsLikeDto [id=" + id + ", gymSeq=" + gymSeq + ", nickname=" + nickname + ", isLiked=" + isLiked + "]";
    }
}
