package bean;

import java.sql.Date;

public class BenhNhan {
private int patid;
private String patname;
private Date patintday;
private Date patupdday;
public BenhNhan() {
	// TODO Auto-generated constructor stub
}
public int getPatid() {
	return patid;
}
public void setPatid(int patid) {
	this.patid = patid;
}
public String getPatname() {
	return patname;
}
public void setPatname(String patname) {
	this.patname = patname;
}
public Date getPatintday() {
	return patintday;
}
public void setPatintday(Date patintday) {
	this.patintday = patintday;
}
public Date getPatupdday() {
	return patupdday;
}
public void setPatupdday(Date patupdday) {
	this.patupdday = patupdday;
}

}
