package com.project.phase1FSD;

public class UserDetails {
		String UserName;
		String Password;
		
		public UserDetails(String userName, String passCode) {
			super();
			UserName = userName;
			Password = passCode;
		}
		public UserDetails() {}

		public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String passCode) {
			Password = passCode;
		}
}