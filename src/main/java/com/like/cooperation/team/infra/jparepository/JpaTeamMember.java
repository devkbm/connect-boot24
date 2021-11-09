package com.like.cooperation.team.infra.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.like.cooperation.team.domain.TeamMember;
import com.like.cooperation.team.domain.TeamMemberId;

@Repository
public interface JpaTeamMember extends JpaRepository<TeamMember, TeamMemberId> {

}
