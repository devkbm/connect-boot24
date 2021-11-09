package com.like.cooperation.team.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class TeamMemberId implements Serializable {
	
	@Column(name="TEAM_ID")
	Long teamId;
		
	@Column(name="USER_ID")
	String userId;	
	
	public TeamMemberId(Long teamId, String userId) {
		this.teamId = teamId;
		this.userId = userId;
	}
	
}
