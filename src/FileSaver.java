import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileSaver {
	public void write( String fname ) throws Exception {
		// ファイル名＝fnameのファイルに書き込みを行う
		BufferedWriter output = null;
		output = new BufferedWriter( new FileWriter( fname ) );

		// 引数RecordListに格納されたレコードを１行ずつ書き込む
		int idx = 0;
		while( idx < SystemManager.idata.length ) {
			output.write( SystemManager.idata[idx].getId() + "," + SystemManager.idata[idx].getKinds() + "," + SystemManager.idata[idx].getName() + "," + SystemManager.idata[idx].getData()+ "," + SystemManager.idata[idx].getAddress());
			output.newLine();     // 改行文字をファイルに出力
			idx++;
		}
		output.close();
	}
}
