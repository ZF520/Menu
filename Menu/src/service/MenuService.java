package service;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import dao.MenuDao;
import entity.FirstMenu;
import entity.SecondMenu;

public class MenuService {
	
	MenuDao menuDao = new MenuDao();
	
	public ArrayList<FirstMenu> getFirstMenuList()
	{
		ArrayList<FirstMenu> list = new ArrayList<FirstMenu>();
		String sql = "select * from firstmenu";
		Result result = menuDao.getList(sql);
		Object[][] data = result.getRowsByIndex();
		for(int i=0; i<data.length; i++)
		{
			FirstMenu fm = new FirstMenu();
			fm.setId(Integer.valueOf(data[i][0].toString()));
			fm.setName(data[i][1].toString());
			list.add(fm);
		}
		return list;
	}
	
	public ArrayList<SecondMenu> getSecondMenuList()
	{
		ArrayList<SecondMenu> list = new ArrayList<SecondMenu>();
		String sql = "select * from secondmenu";
		Result result = menuDao.getList(sql);
		Object[][] data = result.getRowsByIndex();
		for(int i=0; i<data.length; i++)
		{
			SecondMenu sm = new SecondMenu();
			sm.setId(Integer.valueOf(data[i][0].toString()));
			sm.setName(data[i][1].toString());
			sm.setMaster(Integer.valueOf(data[i][2].toString()));
			list.add(sm);
		}
		return list;
	}
	
	public boolean addFirstMenu(String name)
	{
		String sql = "insert into firstmenu(name) value('"+name+"')";
		if(menuDao.update(sql) > 0)
			return true;
		else
			return false;
	}
	
	public boolean addSecondMenu(String name)
	{
		String sql = "insert into secondmenu(name) value('"+name+"')";
		if(menuDao.update(sql) > 0)
			return true;
		else
			return false;
	}
	
	public boolean modFirstMenu(FirstMenu fm)
	{
		String sql = "update firstmenu set name= '"+fm.getName()+"' where id="+fm.getId();
		if(menuDao.update(sql) > 0)
			return true;
		else
			return false;
	}
	
	public boolean modSecondMenu(SecondMenu sm)
	{
		String sql = "update secondmenu set name= '"+sm.getName()+"' where id="+sm.getId();
		if(menuDao.update(sql) > 0)
			return true;
		else
			return false;
	}
	
	public boolean delFirstMenu(FirstMenu fm)
	{
		String sql = "delete from firstmenu where id="+fm.getId();
		if(menuDao.update(sql) > 0 )
			return true;
		else
			return false;
	}
	
	public boolean delSecondMenu(SecondMenu sm)
	{
		String sql = "delete from secondmenu where id="+sm.getId();
		if(menuDao.update(sql) > 0 )
			return true;
		else
			return false;
	}
	
	public boolean sortID()
	{
		String sql = "alter table firstmenu drop id";
		String sql2 = "ALTER TABLE firstmenu ADD id INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
		if(menuDao.update(sql)>0 && menuDao.update(sql2) > 0 )
			return true;
		else
			return false;
	}
}