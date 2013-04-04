package br.com.caelum.mobileconf.persistence;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.com.caelum.mobileconf.modelo.Carro;
import br.com.caelum.mobileconf.util.MyLog;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DAO extends OrmLiteSqliteOpenHelper{

	private static final int VERSION = 1;
	private static final String DATABASE = "SysGraf.db";
	private static final Class<?>[] persitentClasses = {Carro.class};

	public DAO(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource cs) {
		for (Class<?> clazz : persitentClasses) {
			try {
				TableUtils.createTable(cs, clazz);
			} catch (SQLException e) {
				MyLog.e("Error creating database for entity: "+clazz.getName() +" -> "+ e);
			}
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource arg1, int arg2,	int arg3) {}
	
	public <T> void save(T o) {
		try {
			MyLog.i("SAVING: "+o);
			Dao<T, ?> dao = getDao(o.getClass());
			dao.create(o);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public <T> List<T> listAll(Class<T> clazz) {
		try {
			Dao<T, ?> dao = getDao(clazz);
			return dao.queryForAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public <T>void saveOrUpdate(T o) {
		try {
			MyLog.i("SAVING OR UPDATING: "+o);
			Dao<T, ?> dao = getDao(o.getClass());
			dao.createOrUpdate(o);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
