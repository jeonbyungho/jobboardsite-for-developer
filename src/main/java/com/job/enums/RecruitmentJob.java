package com.job.enums;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public enum RecruitmentJob {
		BACK_END ("백엔드")
	,	FRONT_END ("프론트 엔드")
	,	FULL_STACK ("풀스택")
	,	IOS ("IOS")
	,	ANDROID ("안드로이드")
	,	AI ("인공지능")
	,	DBA ("DBA")
	,	DATA_ENGINEERING ("데이터 엔지니어링")
	,	GAME ("게임 개발")
	,	SYSTEM_NETWORK ("시스템 네트워크")
	,	SYSTEM_SOFTWARE ("시스템 소프트웨어")
	,	EMBEDDED ("임베디드")
	,	DEVOPS ("데브옵스")
	,	SECURITY ("보안")
	,	BLOCKCHAIN ("블록체인")
	,	PM ("개발PM")
	,	WEB_PUBLISHING ("웹 퍼블리싱")
		;
	private String korean;
	
	RecruitmentJob(String korean) {
		this.korean = korean;
	}
	
}
