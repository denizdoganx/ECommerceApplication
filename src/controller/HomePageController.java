package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import context.DbHelperForCustomer;
import model.Item;
import util.HomePageItemElement;
import util.ImageResizer;
import util.ItemPageItemElement;

public class HomePageController {

	private static HomePageController instance = null;
	
	private HomePageController() {
		
	}
	
	public static HomePageController getInstance() {
		if(instance == null) {
			instance = new HomePageController();
		}
		return instance;
	}
	
	public ItemPageItemElement getItemPageElement(int id) {
		ItemPageItemElement itemToBeSent = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = DbHelperForCustomer.getConnection();
			preparedStatement = connection.prepareStatement("select items.*, images.data_ from items, images where items.id = ? and items.id = images.itemId;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			int id_ = - 1;
			String itemCode = null;
			String itemName = null;
			float unitPrice = 0;
			String brand = null;
			String category1 = null;
			String category2 = null;
			String category3 = null;
			String category4 = null;
			int stockNumber = - 1;
			String fileNameWithoutCompression = null;
			String fileNameWithCompression = null;
			ArrayList<String> imagePaths = new ArrayList<>();
			int index = 0;
			while(resultSet.next()) {
				id_ = resultSet.getInt("id");
				itemCode = resultSet.getString("itemCode");
				itemName = resultSet.getString("itemName");
				unitPrice = resultSet.getFloat("unitPrice");
				brand = resultSet.getString("brand");
				category1 = resultSet.getString("category1");
				category2 = resultSet.getString("category2");
				category3 = resultSet.getString("category3");
				category4 = resultSet.getString("category4");
				stockNumber = resultSet.getInt("stockNumber");
				
				InputStream inputStream = resultSet.getBinaryStream("data_");
				
				fileNameWithoutCompression = "images/"+ "image" + id_ + "WithoutCompression" + index +".jpg";
				fileNameWithCompression = "images/" + "image" + id_ + "WithCompression" + index + ".jpg";
				
				OutputStream outputStream = new FileOutputStream(fileNameWithoutCompression);
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				
				ImageResizer.resizeImage(fileNameWithoutCompression, fileNameWithCompression, 650, 910);
				outputStream.close();
				inputStream.close();
				
				imagePaths.add(fileNameWithCompression);
				index++;
			}
			Item item = new Item(itemCode, itemName, unitPrice, brand, category1, category2, category3, category4, stockNumber);
			item.setId(id_);
			itemToBeSent = new ItemPageItemElement(imagePaths, item);
		}
		catch(SQLException e) {
			DbHelperForCustomer.showErrorMessage(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		
		return itemToBeSent;
	}
	
	public ArrayList<HomePageItemElement> getHomePageItems(){
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		ArrayList<HomePageItemElement> items = null;
		try {
			connection = DbHelperForCustomer.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select items.id as id, min(unitPrice) as unitPrice, min(itemName) as itemName, max(data_) as data_ "
					+ "from items "
					+ "inner join images on items.id = images.itemId "
					+ "group by items.id;");
			items = new ArrayList<>();
			while(resultSet.next()) {
				String priceText = null;
				String informationText = null;
				String fileNameWithoutCompression = null;
				String fileNameWithCompression = null;

				InputStream inputStream = resultSet.getBinaryStream("data_");
				
				int productId = resultSet.getInt("items.id");
				
				fileNameWithoutCompression = "images/"+ "image" + productId + "WithoutCompression.jpg";
				fileNameWithCompression = "images/" + "image" + productId + "WithCompression.jpg";
				OutputStream outputStream = new FileOutputStream(fileNameWithoutCompression);
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				ImageResizer.resizeImage(fileNameWithoutCompression, fileNameWithCompression, 200, 235);
				outputStream.close();
				inputStream.close();
				priceText = resultSet.getString("unitPrice");
				informationText = resultSet.getString("itemName");
				
				items.add(
						new HomePageItemElement(
								productId,
								fileNameWithCompression,
								priceText,
								informationText)
						);
			}
		}
		catch(SQLException e) {
			DbHelperForCustomer.showErrorMessage(e);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				DbHelperForCustomer.killTheConnection();
			} catch (SQLException e) {
				DbHelperForCustomer.showErrorMessage(e);
			}
		}
		return items;
	}
	
}
