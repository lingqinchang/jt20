package util;

import java.io.Serializable;

public class Page implements Serializable{
	private static final long serialVersionUID = 8798279435969982596L;
	private Integer n; //页码
	private Integer size; //每页显示的记录数
	private Integer totalSize; //总记录数
	private Integer totalPage; //总页数
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
