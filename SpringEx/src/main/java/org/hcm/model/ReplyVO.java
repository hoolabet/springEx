package org.hcm.model;

public class ReplyVO {
	private int rno;
	private String id;
	private String name;
	private String content;
	private String regdate;
	private	int bno;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", id=" + id + ", name=" + name + ", content=" + content + ", regdate=" + regdate
				+ ", bno=" + bno + "]";
	}
	
}
