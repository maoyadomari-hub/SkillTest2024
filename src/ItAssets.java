import java.nio.charset.Charset;

public class ItAssets {
		//フィールド部分
		private int id;
		private String kinds;
		private String name;
		private String data;
		private String address;
	
		//メソッド部分
		//受け取ったデータを自身のフィールドに格納していく
		public void setValue(int setid, String setkinds, String setname, String setdata, String setaddress) {
			this.id = setid;
			this.kinds = setkinds;
			this.name = setname;
			this.data = setdata;
			this.address = setaddress;
		}
		
		//データ一覧を画面に表示する処理
		public void displayValue() {

			 String formattedId = format(String.valueOf(this.id), 8);
			 String formattedKinds = format(this.kinds, 20);
			 String formattedName = format(this.name, 24);
			 String formattedData  = format(this.data, 16);
			 String formattedAddress = format(this.address, 15);
			 
			 System.out.println(formattedId + formattedKinds  + formattedName + formattedData + formattedAddress);
		}
		
		private static String format(String target, int length){
			//全角3バイト、半角1バイトのため、いくつ引けばよいか計算
			int byteDiff = (getByteLength(target, Charset.forName("UTF-8"))-target.length())/2;
			//出力桁の結果を表示して返却　%-12sや%-16s等
			return String.format("%-"+(length-byteDiff)+"s", target);
		}
		
		//文字のバイト数を取得して返す処理
			private static int getByteLength(String string, Charset charset) {
		    return string.getBytes(charset).length;
		}
		
		public void sortValue(ItAssets svalue ) {
			this.id = svalue.getId();
			this.kinds = svalue.getKinds();
			this.name = svalue.getName();
			this.data = svalue.getData();
			this.address = svalue.getAddress();
		}
		
		public void deleteValue() {
			this.id = 0;
			this.kinds = null;
			this.name = null;
			this.data = null;
			this.address = null;
		}
		
		//個別にフィールドの値を取得するメソッド
		public int getId(){
			return this.id;
		}
		
		public String getKinds(){
			return this.kinds;
		}
		
		public String getName(){
			return this.name;
		}
		
		public String getData(){
			return this.data;
		}
		
		public String getAddress(){
			return this.address;
		}
		
		
		//個別にフィールドの値を更新するメソッド
		public void setId(int sId) {
			this.id = sId;
		}
		
		public void setKinds(String sKinds) {
			this.kinds = sKinds;
		}

		public void setName(String sName) {
			this.name = sName;
		}
		
		public void setData(String sData) {
			this.data = sData;
		}
		
		public void setAddress(String sAddress) {
			this.address = sAddress;
		}
}
