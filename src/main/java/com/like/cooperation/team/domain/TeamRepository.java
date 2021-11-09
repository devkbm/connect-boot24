package com.like.cooperation.team.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.boundary.TeamDTO;
import com.like.system.user.domain.SystemUser;

@Repository
public interface TeamRepository {

	Team getTeam(Long teamId);
	
	List<Team> getTeamList(TeamDTO.SearchCondition searchCondition);
	
	void saveTeam(Team team);
	
	void deleteTeam(Team team);
			
	TeamMember getTeamMember(Team team, SystemUser member);	
	
	void saveJoinTeam(TeamMember joinTeam);
	
	void saveJoinTeam(List<TeamMember> teamMemberList);
	
	void deleteJoinTeam(TeamMember joinTeam);
	
	void deleteJoinTeam(List<TeamMember> teamMemberList);
	
}
