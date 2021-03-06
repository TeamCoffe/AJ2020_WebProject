package dto;

import java.sql.Date;

/*
>>### projectdata_tb
>>proj_id int not null
>>proj_writer varchar(20) not null 
>>proj_title varchar(50) not null 
>>proj_date datetime not null
>>proj_content text not null
>>proj_image varchar(50)
>>proj_deadline date not null
>>proj_goal int not null
>>proj_current int
>>proj_sponsor int
>>proj_approval tinyint(1) 
 */
public class ProjectDataBean implements java.io.Serializable{
	private int pid;
	private String writer;
	private String title;
	private Date date;
	private String content;
	private String imageURL;
	private Date deadline;
	private int goal;
	private int current;
	private int sponsor;
	private int category;
	private boolean approval;
	private String thumImageURL;
	
	public ProjectDataBean() {
		this(0, null, null, null, null, null, null, 0, 0, 0,0, false, null);
	}
	public ProjectDataBean(int pid, String writer, String title, Date date, String content, String imageURL,
			Date deadline, int goal, int current, int sponsor, int category, boolean approval) {
		super();
		this.pid = pid;
		this.writer = writer;
		this.title = title;
		this.date = date;
		this.content = content;
		this.imageURL = imageURL;
		this.deadline = deadline;
		this.goal = goal;
		this.current = current;
		this.sponsor = sponsor;
		this.category=category;
		this.approval = approval;
	}
	
	//배너 썸네일 추가
	public ProjectDataBean(int pid, String writer, String title, Date date, String content, String imageURL,
			Date deadline, int goal, int current, int sponsor, int category, boolean approval, String thumImageURL) {
		super();
		this.pid = pid;
		this.writer = writer;
		this.title = title;
		this.date = date;
		this.content = content;
		this.imageURL = imageURL;
		this.deadline = deadline;
		this.goal = goal;
		this.current = current;
		this.sponsor = sponsor;
		this.category=category;
		this.approval = approval;
		this.thumImageURL = thumImageURL;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getSponsor() {
		return sponsor;
	}

	public void setSponsor(int sponsor) {
		this.sponsor = sponsor;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public String getThumImageURL() {
		return thumImageURL;
	}

	public void setThumImageURL(String thumImageURL) {
		this.thumImageURL = thumImageURL;
	}

	@Override
	public String toString() {
		return "ProjectDataBean [pid=" + pid + ", writer=" + writer + ", title=" + title + ", date=" + date
				+ ", content=" + content + ", imageURL=" + imageURL + ", deadline=" + deadline + ", goal=" + goal
				+ ", current=" + current + ", sponsor=" + sponsor + ", category=" + category + ", approval=" + approval
				+ ", thumImageURL=" + thumImageURL + "]";
	}
	
	

}
