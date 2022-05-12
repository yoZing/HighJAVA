package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Util4 {
	public static Charset charset;
	public static Reader rd;
	public static SqlMapClient smc;

	public static void getConnection() {

		try {

			charset = Charset.forName("UTF-8");

			Resources.setCharset(charset);

			rd = Resources.getResourceAsReader("SqlMapConfig.xml");

			smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
