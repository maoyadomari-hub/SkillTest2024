
public class SystemManager {
	static ItAssets[] idata;
	FileLoader fl;
	ItaSearch ss;
	ItaManagement sm;
	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SystemManager maneger = new SystemManager();
		try {
			maneger.load();
			maneger.run();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	//コンストラクタ
	SystemManager(){
		idata = new ItAssets[50];
		fl = new FileLoader();
		ss = new ItaSearch();
		sm = new ItaManagement();
	}

	public void run() throws Exception{
		String top =
				"\n△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼"+
				"\n具志川職業能力開発校　情報システム科　技能照査　"+
				"\n情報資産管理システム　メインメニュー"+
				"\n1:情報機器を検索（Sa）"+
				"\n2:情報機器の管理（Ma）"+
				"\n3:保存して終了（Sx）"+
				"\n終了(X)"+
				"\n△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼△▼"+
				"\nどの機能を実行しますか？"+
				"\n[ Sa, Ma, Sx, X ]>";
	
		System.out.print(top);
		
		String menuSelect = new java.util.Scanner(System.in).nextLine();
		
		switch(menuSelect){
			case "Sa":
				//情報機器検索画面へ遷移
				ss.searchTop();
				break;

			case "Ma":
				//情報機器管理画面へ遷移
				sm.managmentTop();
				break;

			case "Sx":
				//保存して終了
				this.save();
				System.out.println("保存して終了しました");
				return;
				//保存しないで終了
			case "X":
				System.out.println("終了");
				return;

			default:
				System.out.println("正しい値を入力してください。");
		}
		this.run();
	}

	
	public void load() throws Exception {
		//CSVファイルの読み込み処理
		//fl.read("http://192.168.1.181/java/Device.csv");
		fl.read("http://localhost/java/Device.csv");		

	}
	public void save() throws Exception {
		//CSVファイルの書き込み処理
		FileSaver w = new FileSaver();
		w.write("bin//Device_w.csv");
	}
}
