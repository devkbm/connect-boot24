package com.like.cooperation.team.infra.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.cooperation.team.domain.Team;

@Repository
public interface JpaTeam extends JpaRepository<Team, Long>, QuerydslPredicateExecutor<Team> {

}
