package com.shinhan.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeptVO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
