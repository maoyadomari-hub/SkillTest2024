import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class FileLoader {

	public static void read(String fname) throws Exception {
		//外部ファイル(CSV)の読み込み
		URL u = new URL(fname);
		InputStream strm = u.openStream();
		InputStreamReader in = new InputStreamReader(strm);
		BufferedReader br = new BufferedReader(in);
		
		
		//itAssets型へデータを格納する
		//初期化
		for(int j = 0; j < SystemManager.idata.length; j++) {
			SystemManager.idata[j] = new ItAssets();
		}
		//データの格納
		int i =0;
		String line;
		while((line = br.readLine()) != null){
			String[] data = line.split(",",0);//行をカンマ区切りの配列に変換
			SystemManager.idata[i].setValue(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]);
			i++;
		}
	}
}
