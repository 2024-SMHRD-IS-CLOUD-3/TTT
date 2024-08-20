package com.smhrd.repository;

import java.time.LocalDate;

public interface UserWithLatestCountDTO {
	 String getTr_Id();
	 String getUsr_Id();
	 String getUsr_Name();
	 String getUsr_Gender();
	 LocalDate getUsr_Birthdate();
	 Integer getCount();
	 String getProfile_Img();
}