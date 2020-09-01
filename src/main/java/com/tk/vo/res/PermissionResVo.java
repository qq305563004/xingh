package com.tk.vo.res;

import java.util.List;

public class PermissionResVo implements Comparable<PermissionResVo> {

	private Integer id;

	private Integer parentId;

	private String title;

	private Integer level;

	private String mark;

	private boolean selected;

	private List<PermissionResVo> children;

	public PermissionResVo(Integer id, Integer parentId, String title, Integer level, String mark, boolean selected) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.title = title;
		this.level = level;
		this.mark = mark;
		this.selected = selected;
	}

	public PermissionResVo(Integer id, Integer parentId, String title, Integer level, String mark) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.title = title;
		this.level = level;
		this.mark = mark;
	}

	public PermissionResVo(Integer id, Integer parentId) {
		super();
		this.id = id;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<PermissionResVo> getChildren() {
		return children;
	}

	public void setChildren(List<PermissionResVo> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "PermissionResVo [id=" + id + ", parentId=" + parentId + ", title=" + title + ", level=" + level
				+ ", mark=" + mark + ", checked=" + selected + ", children=" + children + "]";
	}

	@Override
	public int compareTo(PermissionResVo o) {
		return this.getId() - o.getId();
	}

}
