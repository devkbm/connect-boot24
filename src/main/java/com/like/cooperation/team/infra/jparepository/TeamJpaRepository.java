package com.like.cooperation.team.infra.jparepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.like.cooperation.team.boundary.TeamDTO;
import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.TeamMember;
import com.like.cooperation.team.domain.TeamMemberId;
import com.like.cooperation.team.domain.TeamRepository;
import com.like.system.user.domain.SystemUser;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TeamJpaRepository implements TeamRepository {

	@Autowired
	private JPAQueryFactory  queryFactory;
	
	@Autowired
	private JpaTeam jpaTeam;
			
	@Autowired
	private JpaTeamMember jpaTeamMember;

	//private static final QTeamMember qTeamMember;
	
	@Override
	public Team getTeam(Long teamId) {
		Optional<Team> entity = jpaTeam.findById(teamId); 
				
		return entity.orElse(null);
	}

	@Override
	public List<Team> getTeamList(TeamDTO.SearchCondition searchCondition) {			
		return Lists.newArrayList(jpaTeam.findAll(searchCondition.getCondition()));
	}

	@Override
	public void saveTeam(Team team) {
		jpaTeam.save(team);
		//jpaTeam.saveAndFlush(team);		
	}

	@Override
	public void deleteTeam(Team team) {
		jpaTeam.delete(team);		
	}
	

	@Override
	public TeamMember getTeamMember(Team team, SystemUser member) {				
		Optional<TeamMember> entity = jpaTeamMember.findById(new TeamMemberId(team.getTeamId(), member.getUserId()));
		
		return entity.orElse(null);
	}

	@Override
	public void saveJoinTeam(TeamMember joinTeam) {
		jpaTeamMember.save(joinTeam);		
	}
	
	@Override
	public void saveJoinTeam(List<TeamMember> teamMemberList) {
		jpaTeamMember.saveAll(teamMemberList);		
	}

	@Override
	public void deleteJoinTeam(TeamMember joinTeam) {
		jpaTeamMember.delete(joinTeam);
	}

	@Override
	public void deleteJoinTeam(List<TeamMember> teamMemberList) {
		jpaTeamMember.deleteAll(teamMemberList);		
	}
	
}
