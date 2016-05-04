package test_s2dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;
import java.sql.Statement;


/**
 * シンプルなコネクション管理クラス
 * 
 * @author Shinji Miyamoto
 */
public class H2へつなげるConnectionManager {

	final static String DRIVER = "org.h2.Driver";
	public static Connection con;
	
	public static Connection getConnection()throws SQLException {

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("fail to class load : "+ e.getMessage());
		}

		//Connection con = DriverManager.getConnection("jdbc:h2:mem:mokuroku;MODE=PostgreSQL;DB_CLOSE_DELAY=-1");
		con = DriverManager.getConnection("jdbc:h2:mem:mokuroku;MODE=PostgreSQL");
		
		Statement st1 = con.createStatement();
		
		//インメモリはまずは「スキーマ」をクリエイト
		st1.execute("CREATE SCHEMA IF NOT EXISTS h2schema;");			
		
		//インメモリはまずは「テーブル」をクリエイト
		st1.execute(NameFinal.CREATE_SQL_H2);
		st1.execute("insert into h2schema.h2table values (1, 'hoge')");
		st1.execute("insert into h2schema.h2table values (2, 'hoge2')");
		ResultSet rs1 = st1.executeQuery("select * from h2schema.h2table");
		//assertThat(rs1.next(), is(true));//●trueってことは結果が返ってきたってことだ。
		//rs1.first();//●ResultSetをはじめからやってくれるっぽいメソッド。●しかしH2だからかうまくいってくれないのでコメントアウトした。。
		//-------------------------------------------
		//ここは本当に中身が入っているのか確認するためにやってみた。
		//-------------------------------------------
		while (rs1.next()) {
			int    id   = rs1.getInt   ("id");
			String text = rs1.getString("text");
			System.out.println(id);
			System.out.println(text);
			System.out.println();
		}
		//-------------------------------------------
		st1.close();
		//con1.close();
		
		return con;
	}

	/**
	 * 接続確認テスト用●指定したDBにちゃんと繋がっているか確認できる。●Ｈ２での取得方法はわからない。
	 */
	public static void main(String[] args)throws SQLException {

		Connection con = getConnection();
		

		
		con.close();
		System.out.println("END");
	}
}