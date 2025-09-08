
public class ItaManagement {
	public void managmentTop(){
		String managmentTopScreen =
					"\n<情報機器管理>"+
					"\n情報機器の新規登録（Ad）"+
					"\n情報機器の更新（Up）"+
					"\n情報機器の削除（De）"+
					"\nメインメニューに戻る(Ba)"+
					"\n△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼"+
					"\nどの機能を実行しますか？"+
					"\n[ Ad, Up, De, Ba ]>";
	
		System.out.print(managmentTopScreen);
	
		String managmentSelect = new java.util.Scanner(System.in).nextLine();
		
		switch(managmentSelect) {	
			case "Ad":
				//情報機器の新規登録
				this.itaAdd();
				break;
		
			case "Up":
				//情報機器の更新
				this.itaUpdate();
				break;
		
			case "De":
				//情報機器の削除
				this.itaDelete();
				break;
		
			case "Ba":
				//メインメニューへ戻る
				return;
		
			default:
				System.out.println("正しい値を入力してください。");
				break;
		}
		managmentTop();
	}
	public void itaAdd() {
		String itaaddscreen =
				"\n<情報機器新規登録>"+
				"\n新規登録する情報を入力してください。";
		
		System.out.println(itaaddscreen);
		//新規登録用データの宣言
		ItAssets iadd = new ItAssets();
		//挿入位置の検索
		int i;
		for(i = 0; i <  SystemManager.idata.length && SystemManager.idata[i].getId() != 0; i++) {		
		}
		
		//新規登録データの入力
		iadd.setId(i+1);
		
		System.out.print("種類：");
		//キーボードから入力　String managmentSelect = new java.util.Scanner(System.in).nextLine();
		iadd.setKinds(new java.util.Scanner(System.in).nextLine());
		
		System.out.print("機器名：");
		iadd.setName(new java.util.Scanner(System.in).nextLine());
		
		System.out.print("購入年月日：");
		iadd.setData(new java.util.Scanner(System.in).nextLine());
		
		System.out.print("IPアドレス：");
		iadd.setAddress(new java.util.Scanner(System.in).nextLine());
		
		//新規登録データをsdata[]に挿入
		SystemManager.idata[i].setValue(iadd.getId(), iadd.getKinds(), iadd.getName(), iadd.getData(), iadd.getAddress());
		
		//完了画面呼び出し
		done("add",iadd);
		return;
	}
	
	public void itaUpdate() {
		String itaupscreen =
				"\n<情報機器更新>" +
				"\n更新する機器のID番号を入力してください。" +
				"\nID：";

		System.out.print(itaupscreen);

		int upcode = new java.util.Scanner(System.in).nextInt();
		
		//更新したいフィールドの位置を線形探索
		int j;
		for (j = 0; j < SystemManager.idata.length && SystemManager.idata[j].getId() != 0; j++) {
			if(SystemManager.idata[j].getId() == upcode) {
			break;
			}
		}
		System.out.print("更新する項目を選んで下さい。\n１：種類　２：機器名　３：購入日　４：IPアドレス＞");

		int upnumber = new java.util.Scanner(System.in).nextInt();
		
		System.out.print("更新データの値を入力してください。\n＞" );
		String updata = new java.util.Scanner(System.in).nextLine();
		
		switch(upnumber) {
			case 1: 
				SystemManager.idata[j].setKinds(updata);
				break;
				
			case 2:
				SystemManager.idata[j].setName(updata);
				break;
				
			case 3:
				SystemManager.idata[j].setData(updata);
				break;
				
			case 4:
				SystemManager.idata[j].setAddress(updata);
				break;
		}
		
		
		//更新したい値を格納する
		ItAssets  wita = new ItAssets();
		wita.setValue(SystemManager.idata[j].getId(), SystemManager.idata[j].getKinds(),SystemManager.idata[j].getName(), SystemManager.idata[j].getData(), SystemManager.idata[j].getAddress());
				
		done("up", wita);
		
		return;
	}

	
	public void itaDelete () {
		String itaDeleteScreen =
				"\n<情報機器削除>"+
				"\n情報機器のIDを入力してください。"+
				"\nID：";
		System.out.print(itaDeleteScreen);
		
		//削除したい出席番号の格納
		int sdeletecode = new java.util.Scanner(System.in).nextInt();
		
		//削除したいフィールドの位置を線形探索
		int j;
		for(j = 0; j < SystemManager.idata.length && SystemManager.idata[j].getId() != 0; j++) {
			if(SystemManager.idata[j].getId() == sdeletecode) {
				break;
			}
		}
		
		//削除したいフィールドを格納する（完了画面に送るデータ）
		ItAssets wita = new ItAssets();
		wita.setValue(SystemManager.idata[j].getId(), SystemManager.idata[j].getKinds(),SystemManager.idata[j].getName(), SystemManager.idata[j].getData(), SystemManager.idata[j].getAddress());
		
		//削除したいフィールドを一つ後ろのフィールドに上書きして削除
		int i;
		for( i = j+1; i < SystemManager.idata.length-1 && SystemManager.idata[j].getId() != 0; j++, i++) {
			//上書きの処理sortValueメソッド
			SystemManager.idata[j].sortValue(SystemManager.idata[i]);
		}		
		//末尾の値が冗長なので削除
		SystemManager.idata[j].deleteValue();
		
		//データチェック用
//		for(int n = 0; j < SystemManager.sdata.length && SystemManager.sdata[n].getNo() != 0; n++) {
//				SystemManager.sdata[n].displayValue();
//			}	
		
		//データを完了画面に送信
		done("de",wita);
		return;
	}


	
	public void done(String processing, ItAssets donedata) {
		String processingName = "";
		if(processing.equals("add")) {
			 processingName = "新規登録";
		}else if(processing.equals("up")) {
			 processingName = "更新";
		}else if(processing.equals("de")) {
			 processingName = "削除";
		}

		
		String doneScreen = 
				"\n<"+processingName+"完了情報>"+
				"\n以下の情報を"+processingName+"しました。"+
				"\nID："+donedata.getId()+
				"\n種類："+donedata.getKinds()+
				"\n機器名："+donedata.getName()+
				"\n購入日："+donedata.getData()+
				"\nIPアドレス："+donedata.getAddress();
		
		System.out.println(doneScreen);
		return;
	}


}
