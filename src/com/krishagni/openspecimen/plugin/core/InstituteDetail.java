package com.krishagni.openspecimen.plugin.core;

import java.sql.Time;
import java.util.Date;

public class InstituteDetail {

	private Long id;

	private String name;
	
	private Date date;
	
	private Time time;

	private String activityStatus;

	private int usersCount;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public int getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(int usersCount) {
		this.usersCount = usersCount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

/*	public static InstituteDetail from(Institute institute) {
		InstituteDetail detail = new InstituteDetail();
		detail.setId(institute.getId());
		detail.setName(institute.getName());
		detail.setActivityStatus(institute.getActivityStatus());
		return detail;
	}

	public static List<InstituteDetail> from(List<Institute> institutes) {
		List<InstituteDetail> result = new ArrayList<InstituteDetail>();

		if (CollectionUtils.isEmpty(institutes)) {
			return result;
		}

		for (Institute institute : institutes) {
			result.add(from(institute));
		}

		return result;
		*/
	}

