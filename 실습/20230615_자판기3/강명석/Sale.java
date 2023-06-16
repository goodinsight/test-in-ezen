package kr.co.dong.japangi;

public class Sale {

		String sName  = null;
		int sCount = 0;
		int sPrice = 0;
		/**
		 * @param sName
		 * @param sCount
		 * @param sPrice
		 */
		public Sale(String sName, int sCount, int sPrice) {
			super();
			this.sName = sName;
			this.sCount = sCount;
			this.sPrice = sPrice;
		}
		public String getsName() {
			return sName;
		}
		public void setsName(String sName) {
			this.sName = sName;
		}
		public int getsCount() {
			return sCount;
		}
		public void setsCount(int sCount) {
			this.sCount = sCount;
		}
		public int getsPrice() {
			return sPrice;
		}
		public void setsPrice(int sPrice) {
			this.sPrice = sPrice;
		}
		@Override
		public String toString() {
			return "Sale [sName=" + sName + ", sCount=" + sCount + ", sPrice=" + sPrice + "]";
		}
	
		
		
				
}
