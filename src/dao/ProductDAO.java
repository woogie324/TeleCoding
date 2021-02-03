package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;

public class ProductDAO {

	ProductDTO pDTO = new ProductDTO();

	public void prodDB() {	// product DB 초기화
		
		pDTO.prodNumSelect();
		pDTO.prodNameSelect();
		pDTO.prodPriceSelect();
		
		ObjectOutputStream objOut = null;
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/productDB.txt")));
			
			for(int i = 0; i < pDTO.prodNameArr.size(); i++) {
				String productNum = pDTO.prodNumArr.get(i);		// 추가
				String productName = pDTO.prodNameArr.get(i);
				int productPrice = pDTO.prodPriceArr.get(i);
				ProductDTO p = new ProductDTO(productNum, productName, productPrice);
				// productNum 추가
				list.add(p);
			}
			for(int i = 0 ; i < list.size() ; i++) {
				objOut.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		ObjectInputStream objIn = null;	

		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));

			while(true) {
				System.out.println((ProductDTO)objIn.readObject());
			} 
		} catch (EOFException e) {
			System.out.println("초기화 완료");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(objIn != null) {
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	// prodDB 종료
	
	
	
	public List<ProductDTO> readDB() {	// 수정 후 DB read
				
		ObjectInputStream objIn = null;	
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));

			while(true) {
//				System.out.println((ProductDTO)objIn.readObject());
				list.add((ProductDTO)objIn.readObject());
			}	
		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;	
	}	// readDB 종료
	
	
	
	
	public void prodUpdate(ProductDTO pDTO) {	// product 상품/가격 수정
		
		ObjectInputStream objIn = null;
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));
					
				while(true) {
					ProductDTO update = (ProductDTO) objIn.readObject();
					if(update.getProductNum().equals(pDTO.getProductNum())) {
						list.add(pDTO);
					}else {
						list.add(update);
					}
				}
				
		} catch (EOFException e) {
			
		} catch (IOException e) {
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(objIn != null)
			try {
				objIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ObjectOutputStream objOut=null;
		
		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/productDB.txt", false)));
				
			for(ProductDTO object : list) {
				objOut.writeObject(object);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		readDB();
		
	}	// prodUpdate 종료
	
	
	public void prodRemove(ProductDTO pDTO) {	// 상품 삭제 

		ObjectInputStream objIn = null;

		List<ProductDTO> list = new ArrayList<ProductDTO>();

		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DB/productDB.txt")));

			while(true) {
				ProductDTO update = (ProductDTO) objIn.readObject();
				if(update.getProductNum().equals(pDTO.getProductNum())) {
					continue;
				} else {
					list.add(update);
				}
			}

		} catch (EOFException e) {

		} catch (IOException e) {

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if(objIn != null)
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}


		ObjectOutputStream objOut=null;

		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("DB/productDB.txt", false)));

			for(ProductDTO object : list) {
				objOut.writeObject(object);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		readDB();

	}	//prodRemove 종료


}	// class 종료
