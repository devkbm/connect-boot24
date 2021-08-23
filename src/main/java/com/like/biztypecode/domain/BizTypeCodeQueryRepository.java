package com.like.biztypecode.domain;

import java.util.List;

import com.like.biztypecode.boundary.BizTypeCodeDTO;

public interface BizTypeCodeQueryRepository {

	List<BizTypeCode> getBizTypeCode(BizTypeCodeDTO.Search searchCondition);
}
