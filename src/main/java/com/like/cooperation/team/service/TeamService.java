package com.like.cooperation.team.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.TeamMember;
import com.like.cooperation.team.domain.TeamRepository;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.service.UserService;

@Service
@Transactional
public class TeamService {
	
	private TeamRepository teamRepository;	
	private UserService userService;	
	
	public TeamService(TeamRepository teamRepository					  
					  ,UserService userService) {
		this.teamRepository = teamRepository;		
		this.userService = userService;		
	}
	
	public Team getTeam(Long teamId) {
		return teamRepository.findById(teamId).orElse(null);
	}
		
	
	/**
	 * 팀을 저장한다.
	 * @param team 팀 엔티티
	 * @param teamMemberList 팀원 엔티티
	 */
	public void saveTeam(Team team, List<SystemUser> userList) {		
									
		if (userList != null) {		
			List<TeamMember> teamMemberList = new ArrayList<TeamMember>();		
			for (SystemUser user: userList) {
				teamMemberList.add(new TeamMember(team, user));
			}	
			
			team.addMemberList(teamMemberList);			
		}
		
		teamRepository.save(team);
	}
		
	public void deleteTeam(Long teamId) {
		teamRepository.deleteById(teamId);
	}
		
	public List<SystemUser> getTeamMemberList(Long teamId) {
		Team team = teamRepository.findById(teamId).orElse(null);
		
		return team.getMemberList();
	}
						
	
	/**
	 * 팀에 가입한다.
	 * @param teamId 팀 엔티티 Id
	 * @param userId 유저 엔티티 Id
	 * @return 
	 */
	public void joinTeam(Long teamId, String userId) {
		Team team = teamRepository.findById(teamId).orElse(null);
		SystemUser member = userService.getUser(userId);			
		
		team.addMember(member);			
	}			
	
}
