package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Board {

	private int no;			// 글번호
	private String title;	// 제목
	private String writer;	// 작성자
	private String content;	// 내용
	private Date createdAt;	// 등록일자
	private Date updatedAt;	// 수정일자
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	// 생성자
	public Board() {
		this(0, "무제", "무명", "내용 없음");
	}
	
	public Board(int no, String title, String writer, String content) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
//		this.createdAt = new Date();
//		this.updatedAt = new Date();
	}


	// getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createAt) {
		this.createdAt = createAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updateAt) {
		this.updatedAt = updateAt;
	}

	// toString
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
