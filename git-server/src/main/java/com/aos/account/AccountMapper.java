package com.aos.account;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
	public Account select(Account account) throws Exception;
}