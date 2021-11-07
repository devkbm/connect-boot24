package com.like.workschedule.infra.jparepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.workschedule.boundary.WorkDTO.SearchWorkGroup;
import com.like.workschedule.domain.QWorkGroup;
import com.like.workschedule.domain.QWorkGroupMember;
import com.like.workschedule.domain.WorkGroup;
import com.like.workschedule.domain.WorkGroupQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WorkGroupQueryJpaRepository implements WorkGroupQueryRepository {
	private JPAQueryFactory queryFactory;
	private final QWorkGroup qWorkGroup = QWorkGroup.workGroup;
	private final QWorkGroupMember qWorkGroupMember = QWorkGroupMember.workGroupMember;
	
	public WorkGroupQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<WorkGroup> getWorkGroupList(SearchWorkGroup searchCondition) {
		return queryFactory
				.selectFrom(qWorkGroup)
				.where(searchCondition.getBooleanBuilder())
				.fetch();
	}

	@Override
	public List<WorkGroup> getWorkGroupList(String userId) {

		return queryFactory
				.selectFrom(qWorkGroup)
				.join(qWorkGroup.memberList, qWorkGroupMember)
				.where(qWorkGroupMember.user.userId.eq(userId))
				.fetch();
	}
	
	
}
