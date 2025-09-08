
public class ItaSearch {
	String columnName = "ID\t\t種類\t\t\t\t機器名\t\t\t\t\t購入年月日\t\tIPアドレス";
	
	public void searchTop(){

		String searchTopScreen =
				"\n<情報機器検索>"+
				"\n全件表示：Allと入力"+
				"\n種類別検索：検索したい「種類名」を入力"+
				"\n購入日で検索：日付を入力"+
				"\n機器名で検索：検索したい「機器名」を入力"+
				"\nメインメニューに戻る：Baと入力"+
				"\n△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼"+
				"\nどの方法で訓練生情報を検索しますか？"+
				"\n[ All, 種類名, 日付, 機器名, Ba ]>";

		System.out.print(searchTopScreen);

		String searchSelect = new java.util.Scanner(System.in).nextLine();
		
		String[] kindsname = {"ネットワーク機器","プリンタ","コンピュータ"};
		
		switch(searchSelect){
			case "Ba":
				//メインメニューへ戻る
				return;
	
			case "All":
				//全件表示(searchByAllメソッドの呼び出し）
				this.searchByAll();
				break;
	
			default:
				//種類別検索一覧表示(searchBykindsメソッドの呼び出し）
				for(int i = 0; i < kindsname.length; i++) {
					if(searchSelect.equals(kindsname[i]))
					searchBykinds(searchSelect);
				}
				
				//購入日別検索一覧表示(searchByDataメソッドの呼び出し）
				//先頭の文字が数字がどうかチェック
				if(Character.isDigit(searchSelect.charAt(0))) {
					searchByData(searchSelect); 
					break;
				}
				//機器名別検索一覧表示(searchByNameメソッドの呼び出し）
					searchByName(searchSelect); 
				break;
		}
		searchTop();
	}
	
	public void searchByAll(){
		System.out.println("<情報機器一覧表示>");
		System.out.println(columnName);

		for (int j = 0; j < SystemManager.idata.length && SystemManager.idata[j].getId() != 0; j++) {
			SystemManager.idata[j].displayValue();
		}
	}
	
	public void searchBykinds(String searchData) {
		System.out.println("<" + searchData + "の情報一覧>");
		System.out.println(columnName);
		
		for (int j = 0; j < SystemManager.idata.length && SystemManager.idata[j].getId() != 0; j++) {
			if((SystemManager.idata[j].getKinds().equals(searchData))) {
				SystemManager.idata[j].displayValue();
			}
		}
	}
	
	public void searchByData(String searchData) {
		System.out.println("<" + searchData + "の情報一覧>");
		System.out.println(columnName);
		
		for (int j = 0; j < SystemManager.idata.length && SystemManager.idata[j].getId() != 0; j++) {
			if((SystemManager.idata[j].getData().equals(searchData))) {
				SystemManager.idata[j].displayValue();
			}
		}
	}
	
	public void searchByName(String searchData) {
		System.out.println("<" + searchData + "の情報一覧>");
		System.out.println(columnName);
		
		for (int j = 0; j < SystemManager.idata.length && SystemManager.idata[j].getId() != 0; j++) {
			if((SystemManager.idata[j].getName().equals(searchData))) {
				SystemManager.idata[j].displayValue();
			}
		}
	}

}
