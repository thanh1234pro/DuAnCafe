package D5;

public class Table4 {
		private int stt;
		private String name;
		private String username;
		private String password;
		private String comfirmpass;
		
		public Table4() {
			
		}

		public Table4(int stt, String name, String username, String password, String comfirmpass) {
			this.stt = stt;
			this.name = name;
			this.username = username;
			this.password = password;
			this.comfirmpass = comfirmpass;
		}
		
		public Table4(String name, String username, String password, String comfirmpass) {
			this.name = name;
			this.username = username;
			this.password = password;
			this.comfirmpass = comfirmpass;
		}

		public int getStt() {
			return stt;
		}

		public void setStt(int stt) {
			this.stt = stt;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getComfirmpass() {
			return comfirmpass;
		}

		public void setComfirmpass(String comfirmpass) {
			this.comfirmpass = comfirmpass;
		}

		
}
