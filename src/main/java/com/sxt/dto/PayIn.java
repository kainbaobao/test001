package com.sxt.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PayIn {
    private Integer id;

    private String name;

    private String type;

    private Double money;

    private Integer aid;
    
    private String aname;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createTime;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date updateTime;
    
    private String remark;
    
    public PayIn() {
    	super();
    }
    
    public PayIn(String name, String type, Double money,
			Integer aid, Date createTime, Date updateTime,
			String remark) {
		super();
		this.name = name;
		this.type = type;
		this.money = money;
		this.aid = aid;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.remark = remark;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
}
