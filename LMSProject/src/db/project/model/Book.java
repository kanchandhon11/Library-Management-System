package db.project.model;

public class Book {

		private int id;
		private String TITLE;
		private String AUTHOR;
		private String GENRE;
	
		
			public int getId() {
			return id;
		}




		public void setId(int id) {
			this.id = id;
		}




		public String getTITLE() {
			return TITLE;
		}




		public void setTITLE(String tITLE) {
			TITLE = tITLE;
		}




		public String getAUTHOR() {
			return AUTHOR;
		}




		public void setAUTHOR(String aUTHOR) {
			AUTHOR = aUTHOR;
		}




		public String getGENRE() {
			return GENRE;
		}




		public void setGENRE(String gENRE) {
			GENRE = gENRE;
		}




		@Override
		public String toString() {
			String result ="\nId:"+this.getId()
			+"\nTITLE:"+this.getTITLE()
			+"\nAUTHOR:"+this.getAUTHOR()
			+"\nGENRE:"+this.getGENRE();
		
		return result;
		
		}




			
				
			}
		
	


